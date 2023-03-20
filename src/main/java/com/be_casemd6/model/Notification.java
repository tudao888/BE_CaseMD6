package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;


    @ManyToOne
    private Account account;

    @ManyToOne
    private Account accountSend;

    private Integer statusNotification;

    private Integer id_answer;
}
