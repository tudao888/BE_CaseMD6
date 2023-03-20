package com.be_casemd6.model.dto;

import java.time.LocalDate;

public class NotificationDTO {

    private Integer id;


    private Integer id_account;


    private String name;

    private String img;

    private LocalDate date;


    private long status;

    private long id_answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_account() {
        return id_account;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getId_answer() {
        return id_answer;
    }

    public void setId_answer(long id_answer) {
        this.id_answer = id_answer;
    }

    public NotificationDTO(Integer id, Integer id_account, String name, String img, LocalDate date, long status, long id_answer) {
        this.id = id;
        this.id_account = id_account;
        this.name = name;
        this.img = img;
        this.date = date;
        this.status = status;
        this.id_answer = id_answer;
    }


}
