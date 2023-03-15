package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orderLover")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer statusOrder;
    private Integer orderTime;
    private Double total;
    private Date dateOfOrder;
    private Date startDay;
    private Date endDay;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Provider provider;
}
