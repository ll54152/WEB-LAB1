package com.web.lab1.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import org.springframework.lang.*;
import java.time.*;
import java.util.*;

@Entity
public class Ticket {

    @UuidGenerator
    @Id
    private UUID id;

    @NonNull
    private Long vatin;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private LocalDateTime TicketCreationTime;

    public Ticket(UUID id, Long vatin, String firstName, String lastName, LocalDateTime ticketCreationTime) {
        this.id = id;
        this.vatin = vatin;
        this.firstName = firstName;
        this.lastName = lastName;
        TicketCreationTime = ticketCreationTime;
    }

    public Ticket(Long vatin, String firstName, String lastName, LocalDateTime ticketCreationTime) {
        this.vatin = vatin;
        this.firstName = firstName;
        this.lastName = lastName;
        TicketCreationTime = ticketCreationTime;
    }

    public Ticket() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getVatin() {
        return vatin;
    }

    public void setVatin(Long vatin) {
        this.vatin = vatin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getTicketCreationTime() {
        return TicketCreationTime;
    }

    public void setTicketCreationTime(LocalDateTime ticketCreationTime) {
        TicketCreationTime = ticketCreationTime;
    }
}
