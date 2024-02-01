package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;



public class AccountController {

    
    
    public ResponseEntity<List<Accounts>> getAllAccounts() throws SQLException {
        return null;
    }


    public ResponseEntity<Accounts> getAccountById(@PathVariable int accountId) throws SQLException {
        return null;
    }
   
    public ResponseEntity<List<Accounts>> getAccountsByUser(@PathVariable String param) throws NumberFormatException, SQLException {
       return null;
    }
   
    public ResponseEntity<Integer> addAccount(@RequestBody Accounts accounts) throws SQLException {
        return null;
    }
    
    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) {
        return null;
    }

    public ResponseEntity<Void> deleteAccount(int accountId) {
        return null;
    }
}