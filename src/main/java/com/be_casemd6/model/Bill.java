package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer statusBill;
    private Integer orderTime;
    private Double total;
    private String dateOfBill;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Provider provider;
}
