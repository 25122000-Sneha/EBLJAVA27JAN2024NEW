package com.wecp.progressive.service;

import com.wecp.progressive.entity.CreditCard;
import com.wecp.progressive.repository.CreditCardRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCards() {
        return null;
    }

    public CreditCard getCreditCardById(Long id) {
        return null;
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        return null;
    }

    public void updateCreditCard(CreditCard creditCard) {
        
    }

    public void deleteCreditCard(Long id) {
       
    }
}
