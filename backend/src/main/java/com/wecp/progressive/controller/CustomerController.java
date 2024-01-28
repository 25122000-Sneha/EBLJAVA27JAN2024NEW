package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllCustomers() {
        try
        {
            List<Customers> list = customerService.getAllCustomers();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch(SQLException e)
        {
            return null;
        }
        
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId) {
        try 
        {
            Customers c = customerService.getCustomerById(customerId);
            if(c == null)
            {
                return new ResponseEntity<Customers>(c, HttpStatus.NOT_FOUND);
            }
            else 
            {
                return new ResponseEntity<Customers>(c, HttpStatus.OK);
            }

        }
        catch(SQLException e)
        {
            return null;
        }
    }

    public ResponseEntity<Integer> addCustomer(Customers customers) {
        try 
        {
            customerService.addCustomer(customers);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
    }

    public ResponseEntity<Void> updateCustomer(int customerId, Customers customers) {
        return null;
    }
    public ResponseEntity<Void> deleteCustomer(int customerId) {
        try 
        {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
        
    }

    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
        return null;
    }
}
