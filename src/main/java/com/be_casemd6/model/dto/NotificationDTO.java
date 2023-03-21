package com.be_casemd6.model.dto;

import com.be_casemd6.model.Account;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class NotificationDTO {

    private Integer id;

    private LocalDate date;


    private Integer idAccountSend;

    private Integer idAccountReceive;

    private Integer statusNotification;
    // mặc định 1: đã tạo thông báo



    private Integer id_answer;

    // 1: nội dung là gửi tin nhắn
    // 2 : nội dung là yêu cầu admin duyệt nhà cung cấp

    public NotificationDTO(Integer id, LocalDate date, Integer idAccountSend, Integer idAccountReceive, Integer statusNotification, Integer id_answer) {
        this.id = id;
        this.date = date;
        this.idAccountSend = idAccountSend;
        this.idAccountReceive = idAccountReceive;
        this.statusNotification = statusNotification;
        this.id_answer = id_answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getIdAccountSend() {
        return idAccountSend;
    }

    public void setIdAccountSend(Integer idAccountSend) {
        this.idAccountSend = idAccountSend;
    }

    public Integer getIdAccountReceive() {
        return idAccountReceive;
    }

    public void setIdAccountReceive(Integer idAccountReceive) {
        this.idAccountReceive = idAccountReceive;
    }

    public Integer getStatusNotification() {
        return statusNotification;
    }

    public void setStatusNotification(Integer statusNotification) {
        this.statusNotification = statusNotification;
    }

    public Integer getId_answer() {
        return id_answer;
    }

    public void setId_answer(Integer id_answer) {
        this.id_answer = id_answer;
    }
}
