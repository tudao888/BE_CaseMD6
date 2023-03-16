package com.be_casemd6.controller;

import com.be_casemd6.model.Order;
import com.be_casemd6.model.Provider;
import com.be_casemd6.model.Provision;
import com.be_casemd6.model.ProvisionProvider;
import com.be_casemd6.service.*;
import com.be_casemd6.service.impl.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/providers")
@CrossOrigin("*")
public class ProviderController {
    @Autowired
    IProviderService iProviderService;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IProvisionProviderService iProvisionProviderService;
    @Autowired
    ProvisionService provisionService;
    @Autowired
    IOrderService iOrderService;

    //    hiển thị dịch vụ của tài khoản là nhà cung cấp
    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviderAcc() {
        return new ResponseEntity<>(iProviderService.getAllProviderAcc(), HttpStatus.OK);
    }

    //    hiển thị 8 nhà cung cấp có lượt view cao nhất
    @GetMapping("/top/view")
    public ResponseEntity<List<Provider>> getProviderTopView() {
        return new ResponseEntity<>(iProviderService.getProviderTopView(), HttpStatus.OK);
    }
    //    hiển thị các nhà cung cấp nam top 4 view hot
    @GetMapping("/top/view/boy")
    public ResponseEntity<List<Provider>> getBoyProviderTopView() {
        return new ResponseEntity<>(iProviderService.getBoyProviderTopView(), HttpStatus.OK);
    }
    //    hiển thị các nhà cung cấp nữ top 4 view hot
    @GetMapping("/top/view/girl")
    public ResponseEntity<List<Provider>> getGirlProviderTopView() {
        return new ResponseEntity<>(iProviderService.getGirlProviderTopView(),HttpStatus.OK);
    }
    @GetMapping("/top/sell/provider")
    public ResponseEntity<Set<Provider>> getProvidersByOrderStatus5() {
        Map<Provider, Integer> map = iProviderService.getProvidersByOrderStatus5();
        Set<Provider> set = map.keySet();
        return new ResponseEntity<>(set,HttpStatus.OK);
    }
    @GetMapping("/top/sell/provider/luotthue")
    public ResponseEntity<List<Integer>> getLuotThue() {
        Map<Provider, Integer> map = iProviderService.getProvidersByOrderStatus5();
        Set<Provider> set = map.keySet();
        List<Integer> luotthue = new ArrayList<>();
        for (Provider provider : set) {
            luotthue.add(map.get(provider));
        }
        return new ResponseEntity<>(luotthue,HttpStatus.OK);
    }

    @GetMapping("/viewer/{id}")
    public ResponseEntity<Provider> findProviderByIdAndIncreaseView(@PathVariable Integer id) {
        return new ResponseEntity<>(iProviderService.findProviderById(id), HttpStatus.OK);
    }

    @PostMapping("/view/{id}")
    public ResponseEntity<Provider> increaseViewProviderById(@PathVariable Integer id) {
        return new ResponseEntity<>(iProviderService.increaseViewProviderById(id), HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Provider> changeStatusProvider(@PathVariable Integer id) {
        return new ResponseEntity<>(iProviderService.changeStatusProvider(id), HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<Provider> findProvider(@PathVariable String username) {
        return new ResponseEntity<>(iProviderService.findProviderByAccountUsername(username), HttpStatus.OK);
    }

    @PostMapping("/a/createProviderAndService")
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider providerCreate= iProviderService.save(provider);
        Provider providerThenCreate= iProviderService.findProviderByAccount_Id(providerCreate.getAccount().getId());
        for(int i =1;i<18;i++){
            ProvisionProvider provisionProvider= new ProvisionProvider();
            Provision provision= provisionService.findProvisionById(i);
            provisionProvider.setStatusServiceProvider(2);
            provisionProvider.setProvision(provision);
            provisionProvider.setProvider(providerThenCreate);
            iProvisionProviderService.save(provisionProvider);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/orders/{idProvider}")
    public ResponseEntity<List<Order>> getProviderById(@PathVariable int idProvider) {
        return new ResponseEntity<>(iOrderService.getAllBillOfProviderById(idProvider), HttpStatus.OK);
    }

    @GetMapping("/a/getProviderByAccountId/{accountId}")
    public ResponseEntity<Provider> findProviderByAccount_Id(@PathVariable Integer accountId) {
        return new ResponseEntity<>(iProviderService.findProviderByAccount_Id(accountId), HttpStatus.OK);
    }

    @GetMapping("/user/getOrdersByStatus/{idProvider}/{statusOrder}")
    public ResponseEntity<List<Order>> getAllBillOfProviderAndStartOrder(@PathVariable int idProvider, @PathVariable int statusOrder){
        return new ResponseEntity<>(iOrderService.getAllBillOfProviderAndStartOrder(idProvider, statusOrder),HttpStatus.OK);
    }
}
