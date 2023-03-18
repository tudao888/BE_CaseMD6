package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer statusImg;
    private String url;
    @ManyToOne
    private Account account;
}
