package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.PrintQuality;
import java.time.LocalDate;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private LocalDate birthday;
    private Integer statusAccount;
    private String dateOfRegister;
    private Double wallet;
    private LocalDate logoutTime;
    private String fullName;
    private String gender;
    private String city;
    private String country;
    private String avatar;
    private Integer height;
    private Integer weight;
    private String hobby;
    private String description;
    private Integer view;
    private Integer statusComment;
    private Integer statusVip;
}
