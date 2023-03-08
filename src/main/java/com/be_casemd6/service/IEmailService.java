package com.be_casemd6.service;

import com.be_casemd6.model.EmailDetails;

public interface IEmailService {
    String sendSimpleMail(EmailDetails details,String username,String password);
}
