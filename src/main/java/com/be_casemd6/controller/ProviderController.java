package com.be_casemd6.controller;

import com.be_casemd6.model.Provider;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class ProviderController {
    @Autowired
    IProviderService iProviderService;

//    hiển thị dịch vụ của tài khoản là nhà cung cấp
    @GetMapping("/providers")
    public ResponseEntity<List<Provider>> getAllProviderAcc() {
        return new ResponseEntity<>(iProviderService.getAllProviderAcc(), HttpStatus.OK);
    }
    @GetMapping("{username}")
    public ResponseEntity<Provider> findProvider(@PathVariable String username){
        return new ResponseEntity<>(iProviderService.findProviderByAccountUsername(username),HttpStatus.OK);
    }
}
