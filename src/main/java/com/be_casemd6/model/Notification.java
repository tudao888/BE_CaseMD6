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
    private Account accountSend;

    @ManyToOne
    private Account accountReceive;

    private Integer statusNotification;

    private Integer id_answer;

    // nếu là 1 thì nội dung là gửi tin nhắn
    // nếu là 2 thì nội dung là yêu cầu duyệt lên provider
}
