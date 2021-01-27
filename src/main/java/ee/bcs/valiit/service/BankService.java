package ee.bcs.valiit.service;


import ee.bcs.valiit.exception.ErrorResponse.BankException;
import ee.bcs.valiit.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// ARVUTUSED TULEB TEHA SERVICES  !!!!!!

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createCustomer(String firstName, String lastName, String number_of_accounts) {

        bankRepository.createCustomer(firstName, lastName, number_of_accounts);
    }

    public void createAccount(String accountNr, int customer_id) {

        bankRepository.createAccount(accountNr, customer_id);
    }

    public BigDecimal getAccountBalance(String accountNr) {

        return bankRepository.getAccountBalance(accountNr);
    }

    @Transactional
    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = getAccountBalance(accountNr);

        BigDecimal newBalance = balance.add(amount);

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new BankException("Amount must be bigger than 0!");
        }


        bankRepository.updateAccountBalance(accountNr, newBalance);
    }

    @Transactional
    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = getAccountBalance(accountNr);

        BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BankException("Not enough money");
        }

        bankRepository.updateAccountBalance(accountNr, newBalance);
    }

    @Transactional
    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal fromBalance = bankRepository.getAccountBalance(fromAccount);
        // kas fromAccountil on piisavalt raha?
        if (fromBalance.compareTo(amount) < 1) {
            throw new BankException("Not enough money to transfer");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 1) {
            throw new BankException("Transfer amount must be bigger than 0!");
        }

        // kontol on piisavalt raha, 100-50=50, newFromBalance on 50
        BigDecimal newFromBalance = fromBalance.subtract(amount);
        bankRepository.updateAccountBalance(fromAccount, newFromBalance);
        // uus muutuja newToBalance = toAccountBalance + amount.
        BigDecimal newToBalance = bankRepository.getAccountBalance(toAccount).add(amount);
        bankRepository.updateAccountBalance(toAccount, newToBalance);
        // bankRepository.updateAccountBalance(accountNr, newBalance);

    }
}


