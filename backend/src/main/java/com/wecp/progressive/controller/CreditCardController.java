package com.wecp.progressive.controller;


import com.wecp.progressive.entity.CreditCard;
import com.wecp.progressive.service.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credit-cards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        return null;
    }

    
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
       return null;
    }

   
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        return null;
    }

  
    public ResponseEntity<Void> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        return null;
    }

    
    public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
        return null;
    }
}