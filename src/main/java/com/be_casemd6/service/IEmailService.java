package com.be_casemd6.service;

import com.be_casemd6.model.EmailDetails;
import com.be_casemd6.model.Image;

import java.util.List;

public interface IEmailService {
    String sendSimpleMail(EmailDetails details,String username,String password);

}
