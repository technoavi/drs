package com.as.drs.controller;

import com.as.drs.models.OrderDiscount;
import com.as.drs.models.OrderRequest;
import com.as.drs.models.Person;
import com.as.drs.service.OrderDiscountService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drs")
public class DRSController {

    @Autowired
    private OrderDiscountService orderDiscountService;

    @GetMapping("/test/{msg}")
    public String test(@PathVariable("msg") String msg) {
        return "Hello "+ msg;
    }
    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

}
