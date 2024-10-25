package com.web.lab1.service;

import com.web.lab1.domain.*;
import com.web.lab1.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.time.*;

@Service
public class TicketServiceJPA {

    @Autowired
    private TicketRepo ticketRepo;

    public String generateTicket(TicketDTO ticketDTO) {
        if(ticketRepo.countByvatin(ticketDTO.getVatin()) > 3){
            return "You have reached the limit of 3 tickets per Person";
        } else {
            Ticket newTicket = new Ticket();
            newTicket.setFirstName(ticketDTO.getFirstName());
            newTicket.setLastName(ticketDTO.getLastName());
            newTicket.setVatin(ticketDTO.getVatin());
            newTicket.setTicketCreationTime(LocalDateTime.now());
            ticketRepo.save(newTicket);
            return String.valueOf(newTicket.getVatin());
        }
    }

    public int countAll() {
        return (int) ticketRepo.count();
    }
}
