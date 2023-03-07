package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    private String comment;
    private Double rate;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Provider provider;

}
