package com.web.lab1.domain;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.*;
import org.hibernate.annotations.*;
import java.time.*;
import java.util.*;

@Entity
public class Ticket {

    @UuidGenerator
    @Id
    private UUID id;

    @NotNull
    private Long vatin;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
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
