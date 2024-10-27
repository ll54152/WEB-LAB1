package com.web.lab1.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import org.springframework.lang.*;

import java.sql.*;
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
    private Timestamp TicketCreationTime;

    public Ticket(UUID id, Long vatin, String firstName, String lastName, Timestamp ticketCreationTime) {
        this.id = id;
        this.vatin = vatin;
        this.firstName = firstName;
        this.lastName = lastName;
        TicketCreationTime = ticketCreationTime;
    }

    public Ticket(Long vatin, String firstName, String lastName, Timestamp ticketCreationTime) {
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

    public Timestamp getTicketCreationTime() {
        return TicketCreationTime;
    }

    public void setTicketCreationTime(Timestamp ticketCreationTime) {
        TicketCreationTime = ticketCreationTime;
    }
}
