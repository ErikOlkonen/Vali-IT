package ee.bcs.valiit.service;


import ee.bcs.valiit.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// ARVUTUSED TULEB TEHA SERVICES  !!!!!!

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(@RequestParam("accountNr") String accountNr) {
        bankRepository.createAccount(accountNr);
    }

    public BigDecimal getAccountBalance(String accountNr) {
        return bankRepository.getAccountBalance(accountNr);
    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = getAccountBalance(accountNr);

        BigDecimal newBalance = balance.add(amount);

        bankRepository.updateAccountBalance(accountNr, newBalance);
    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = getAccountBalance(accountNr);

        BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        bankRepository.updateAccountBalance(accountNr, newBalance);
    }
    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal fromBalance = bankRepository.getAccountBalance(fromAccount);
        // kas fromAccountil on piisavalt raha?
        if (fromBalance.compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money to transfer");
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


