package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.repository.CustomerRepository;

@Service
public class CustomerServiceImplJpa implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAllCustomers'");
        return customerRepository.findAll();
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
        return null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'addCustomer'");
        customerRepository.save(customers);
        return -1;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");

    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByName'");
       List<Customers> sortedList = customerRepository.findAll();
       Collections.sort(sortedList);
       return sortedList;
    }

    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersFromArrayList'");
       List<Customers> arr = customerRepository.findAll();
       return arr;
    }

    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'addCustomersToArrayList'");
        Customers c = customerRepository.save(customers);
        List<Customers> list = customerRepository.findAll();
        return list;

    }

    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByNameFromArrayList'");
        List<Customers> list = customerRepository.findAll();
        Collections.sort(list);
        return list;
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'emptyArrayList'");
        
    }

    

}