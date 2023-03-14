package com.be_casemd6.model.dto;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountToken {
    private Integer id;
    private String username;
    private String token;
    private Account account;

    private List<Role> roles;
}
