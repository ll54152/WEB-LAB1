package com.web.lab1.rest;

import com.web.lab1.domain.*;
import com.web.lab1.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {

    @Autowired
    private TicketServiceJPA ticketService;

    @PostMapping("/generateTicket")
    public ResponseEntity<String> generateTicket(@RequestBody TicketDTO ticketDTO) {

        try {
            if (ticketDTO == null) {
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            } else if (ticketDTO.getFirstName() == null || ticketDTO.getLastName() == null || ticketDTO.getVatin() == null) {
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            } else {

                System.out.println("GENERIRAM QR KOD");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
