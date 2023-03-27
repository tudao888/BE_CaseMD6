package com.be_casemd6.controller;

import com.be_casemd6.model.*;

import com.be_casemd6.service.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IEmailService emailService;

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IProviderService iProviderService;

    @PostMapping("/register")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(2);
        roles.add(role);
        account.setRoles(roles);
        account.setDateOfRegister(new Date().toString());
        account.setStatusAccount(3);
        account.setStatusVip(1);
        account.setStatusComment(1);
        account.setWallet(1000.0);
        String randomCode = RandomString.make(64);
        account.setVerificationCode(randomCode);
        account.setAvatar("https://phongreviews.com/wp-content/uploads/2022/11/avatar-facebook-mac-dinh-15.jpg");
        emailService.sendHTMLEmail(account);
        iAccountService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping("verify/{verificationCode}")
    public boolean findAccountByVerificationCode(@PathVariable String verificationCode){
        Account account=iAccountService.findAccountByVerificationCode(verificationCode);
        if (account!=null){
            account.setStatusAccount(1);
            iAccountService.createAccount(account);
            return true;
        }
        return false;
    }

    @PostMapping("/register/forgetPass")
    public ResponseEntity<Account> forgetPassword(@RequestBody Account account){
        int newPassword =  Math.abs((int) Math.floor(((Math.random() * 899999) + 100000)));
        String newPasswordConvert= Integer.toString(newPassword);
        account.setPassword(newPasswordConvert);
        iAccountService.save(account);
        EmailDetails emailDetails= new EmailDetails(account.getEmail());
        String subject="Thư hệ thống: Website Thuê người yêu - Uy tín số 1 Việt Nam.";
        String text="Chúc mừng bạn đã đổi mật khẩu thành công!"
                 +"\nMật khẩu mới của bạn là: " + account.getPassword()
                +"\nĐây là email tự động vui lòng không trả lời.";
        emailService.sendSimpleMail(emailDetails,subject,text);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllProvider() {
        return new ResponseEntity<>(iAccountService.getAllProvider(), HttpStatus.OK);
    }

    @GetMapping("/register/findAccountByUsername/{username}")
    public ResponseEntity<Account> findAccountByUsername(@PathVariable String username) {
        return new ResponseEntity<>(iAccountService.findAccountByUsername(username), HttpStatus.OK);
    }
    @GetMapping("/register/findAccountByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Account> findAccountByPhoneNumber(@PathVariable String phoneNumber) {
        return new ResponseEntity<>(iAccountService.findAccountByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/register/findAccountByEmail/{email}")
    public ResponseEntity<Account> findAccountByEmail(@PathVariable String email) {
        return new ResponseEntity<>(iAccountService.findAccountByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/admin/accounts")
    public ResponseEntity<List<Account>> findAllAccounts() {
        return new ResponseEntity<>(iAccountService.findAllAccounts(), HttpStatus.OK);
    }

    @PostMapping("/admin/accounts/block/{id}")
    public ResponseEntity<?> blockAccount(@PathVariable int id) {
        Account account = iAccountService.findAccountById(id);
        if (account.getStatusAccount() == 1) {
            account.setStatusAccount(2);
        } else {
            account.setStatusAccount(1);
        }
        return new ResponseEntity<>(iAccountService.save(account), HttpStatus.OK);
    }

    @GetMapping("/admin/search/{stringSearch}")
    public ResponseEntity<List<Account>> search(@PathVariable String stringSearch) {
        return new ResponseEntity<>(iAccountService.findAllByFullNameContaining(stringSearch), HttpStatus.OK);
    }

    @GetMapping("/admin/accounts/{id}")
    public ResponseEntity<Account> search(@PathVariable int id) {
        return new ResponseEntity<>(iAccountService.findAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/admin/accounts/vip/{id}")
    public ResponseEntity<?> upVip(@PathVariable int id) {
        Account account = iAccountService.findAccountById(id);
        if (account.getStatusVip() == 1||account.getStatusVip() == 3) {
            account.setStatusVip(2);
        } else {
            account.setStatusVip(1);
        }
        return new ResponseEntity<>(iAccountService.save(account), HttpStatus.OK);
    }


    //user

    @PostMapping("/user/editProfile")
    public ResponseEntity<Account> editProfileT(@RequestBody Account account){
        return new ResponseEntity<>(iAccountService.createAccount(account),HttpStatus.OK);
    }
    @GetMapping("/user/getAccount/{id}")
    public ResponseEntity<Account> getAccountT(@PathVariable int id){
        return new ResponseEntity<Account>(iAccountService.findAccountById(id),HttpStatus.OK);
    }

    @GetMapping("/user/getOrders/{idAccount}")
    public ResponseEntity<List<Order>> getAllBillOfAccountById(@PathVariable int idAccount){
        return new ResponseEntity<>(iOrderService.getAllBillOfAccountById(idAccount),HttpStatus.OK);
    }

    @GetMapping("/user/getOrdersByStatus/{idAccount}/{statusOrder}")
    public ResponseEntity<List<Order>> getAllBillOfAccountByIdAndStartOrder(@PathVariable int idAccount, @PathVariable int statusOrder){
        return new ResponseEntity<>(iOrderService.getAllBillOfAccountByIdAndStartOrder(idAccount, statusOrder),HttpStatus.OK);
    }

    @GetMapping("/user/searchProvider/{stringSearch}")
    public ResponseEntity<List<Provider>> findProvidersByAccount_FullNameContaining(@PathVariable String stringSearch){
        return new ResponseEntity<>(iProviderService.findProvidersByAccount_FullNameContaining(stringSearch),HttpStatus.OK);
    }



}
