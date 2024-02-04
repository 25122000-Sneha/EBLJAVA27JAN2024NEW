package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.exception.AccountNotFoundException;
import com.wecp.progressive.exception.OutOfBalanceException;
import com.wecp.progressive.exception.WithdrawalLimitException;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.repository.TransactionRepository;

@Service
public class TransactionServiceImplJpa implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public TransactionServiceImplJpa() {

    }

    public TransactionServiceImplJpa(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Transactions> getAllTransactions() throws SQLException {
        return transactionRepository.findAll();
    }

    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException {
        return transactionRepository.findById(transactionId).get();
    }

    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        Accounts account = accountRepository.findByAccountId(transaction.getAccounts().getAccountId());
        double balance = account.getBalance();
        if (transaction.getAmount() > 30000 && transaction.getTransactionType().equalsIgnoreCase("debit")) {
            throw new WithdrawalLimitException("Exceeded the withdrawal limit.");
        }
        if (balance < transaction.getAmount() && transaction.getTransactionType().equalsIgnoreCase("debit")) {
            throw new OutOfBalanceException("Transaction amount exceeds the total balance available in the account.");
        }
        if (transaction.getTransactionType().equalsIgnoreCase("credit")) {
            balance = balance + transaction.getAmount();
        }
        else {
            balance = balance - transaction.getAmount();
        }
        account.setBalance(balance);
        accountRepository.save(account);
        return transactionRepository.save(transaction).getTransactionId();
    }


    @Override
    public void updateTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTransaction'");
    }

    @Override
    public void deleteTransaction(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTransaction'");
    }

    @Override
    public List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException {
        List<Accounts> accountsList = accountRepository.getAccountsByCustomerCustomerId(customerId);
        List<Transactions> allTransactions = new ArrayList<>();
        if (accountsList.isEmpty()) {
            throw new AccountNotFoundException("No accounts found linked with this customer");
        }
        for (Accounts account : accountsList) {
            List<Transactions> transactionsForAccount = transactionRepository.findByAccountsAccountId(account.getAccountId());
            allTransactions.addAll(transactionsForAccount);
        }
        return allTransactions;
    }

}
