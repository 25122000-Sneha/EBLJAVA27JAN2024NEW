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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






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

    @GetMapping("/customers/{customerID}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerID) {
        try 
        {
            Customers c = customerService.getCustomerById(customerID);
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
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/customers")
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) {
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

    @PutMapping("/customers/{customerID}")
    public ResponseEntity<Void> updateCustomer(@RequestBody Customers customers) {
        try {
            customerService.updateCustomer(customers);
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/customers/{customerID}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerID) {
        try 
        {
            customerService.deleteCustomer(customerID);
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

    @GetMapping("/customers/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersFromArraylist()
    {
        List<Customers> list = customerService.getAllCustomersFromArrayList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/customers/toArrayList")
    public List<Customers> addCustomersToArrayList(Customers customers)
    {
        List<Customers> list = customerService.addCustomersToArrayList(customers);
        return list;
    }

    @GetMapping("/customers/fromArrayList/{customerId}")
    public List<Customers> getAllCustomersSortedByNameFromArrayList()

    {
        List<Customers> list = customerService.getAllCustomersSortedByNameFromArrayList();
        return list;
    }



}
