package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Loan;
import com.wecp.progressive.service.LoanService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LoanController {

    

   
    public ResponseEntity<List<Loan>> getAllLoans() {
        return null;
    }

   
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return null;
    }

    
    public ResponseEntity<Void> updateLoan(@PathVariable Long id,@RequestBody Loan loan) {
    return null;        
    }

    
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        return null;
    }
}
