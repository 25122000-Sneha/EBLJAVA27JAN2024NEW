package com.wecp.progressive.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Accounts;
import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer>{
    List<Accounts> getAccountsByCustomerCustomerId(int customerId);
    List<Accounts> findByOrderByBalance();
    Accounts findByAccountId(int accountId);
}