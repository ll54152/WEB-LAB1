package com.web.lab1.rest;

import com.web.lab1.domain.*;
import com.web.lab1.service.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

@Controller
public class TicketController {



    @Autowired
    private TicketServiceJPA ticketService;

    @PostMapping("/generateTicket")
    public ResponseEntity<?> generateTicket(@RequestBody TicketDTO ticketDTO) {

        try {
            if (ticketDTO == null) {
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            } else if (ticketDTO.getFirstName() == null || ticketDTO.getLastName() == null || ticketDTO.getVatin() == null) {
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            } else {
                String vatin = ticketService.generateTicket(ticketDTO);
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




}
