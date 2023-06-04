package com.example.repo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="employee")
public class Employee {
   @Id
   @Column(name="id", nullable = false)
    private long id;
   @Column(name="first_name",nullable = false)
    @NotBlank(message = "first_name cannot be blank")
    private String firstName;
   @Column(name = "last_name",nullable = false)
   @NotBlank(message = "last_name cannot be blank")
    private String lastName;
   @Column(name="email_id",nullable = false)
   @NotBlank(message = "email_id cannot be blank")
    private String emailId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
