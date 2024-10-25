package com.web.lab1.domain;

public class TicketDTO {

    private Long vatin;
    private String firstName;
    private String lastName;


    public TicketDTO(Long vatin, String firstName, String lastName) {
        this.vatin = vatin;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
