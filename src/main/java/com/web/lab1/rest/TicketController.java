package com.web.lab1.rest;

import com.web.lab1.domain.*;
import com.web.lab1.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.authentication.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.security.*;
import java.util.*;

@Controller
public class TicketController {

    @Autowired
    private TicketServiceJPA ticketService;


    @GetMapping("/")
    public String home(Model model) {
        long ticketCount = ticketService.countAll();
        model.addAttribute("ticketCount", ticketCount);
        return "home";
    }


    @PostMapping("/generateTicket")
    public ResponseEntity<?> generateTicket(@RequestBody TicketDTO ticketDTO) {
        try {
            if (ticketDTO == null) {
                return new ResponseEntity<>("Error Code 400 (Bad Request): Invalid input", HttpStatus.BAD_REQUEST);
            } else if (ticketDTO.getFirstName() == null || ticketDTO.getLastName() == null || ticketDTO.getVatin() == null) {
                return new ResponseEntity<>("Error Code 400 (Bad Request): Invalid input", HttpStatus.BAD_REQUEST);
            } else {
                String vatin = ticketService.generateTicket(ticketDTO);
                if (vatin.equals("You have reached the limit of 3 tickets per Person")) {
                    return new ResponseEntity<>("Error Code 400 (Bad Request): You have reached the limit of 3 tickets per Person", HttpStatus.BAD_REQUEST);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
                sb.append("/").append(vatin);
                BufferedImage qrCode = ticketService.generateQRCodeImage(sb.toString());

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(qrCode, "png", baos);
                byte[] imageBytes = baos.toByteArray();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_PNG);
                return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }


    @GetMapping("/{id}")
    public String getTicketByVatin(@PathVariable UUID id, Model model, Principal principal) {
        Ticket ticket = ticketService.findByid(id);
        if (ticket == null) {
            return "ticketNotFound";
        }
        model.addAttribute("ticket", ticket);

        String email = null;
        if (principal instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) principal;
            email = authToken.getPrincipal().getAttribute("email");
        }
        model.addAttribute("email", email);

        return "ticketDetails";
    }


}
