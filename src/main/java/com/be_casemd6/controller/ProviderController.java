package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/providers")
@CrossOrigin("*")
public class ProviderController {
    @Autowired
    IProviderService iProviderService;
    @Autowired
    IAccountService iAccountService;

//    hiển thị dịch vụ của tài khoản là nhà cung cấp
    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviderAcc() {
        return new ResponseEntity<>(iProviderService.getAllProviderAcc(), HttpStatus.OK);
    }
//    hiển thị 8 nhà cung cấp có lượt view cao nhất
    @GetMapping("/top/view")
    public ResponseEntity<List<Provider>> getProviderTopView() {
        return new ResponseEntity<>(iProviderService.getProviderTopView(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Provider> findProviderByIdAndIncreaseView(@PathVariable Integer id) {
        return new ResponseEntity<>(iProviderService.findProviderById(id),HttpStatus.OK);
    }
    @PostMapping("/view/{id}")
    public ResponseEntity<Provider> increaseViewProviderById(@PathVariable Integer id) {
        return new ResponseEntity<>(iProviderService.increaseViewProviderById(id),HttpStatus.OK);
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<Provider> changeStatusProvider(@PathVariable Integer id) {
        return new ResponseEntity<>(iProviderService.changeStatusProvider(id),HttpStatus.OK);
    }
}
