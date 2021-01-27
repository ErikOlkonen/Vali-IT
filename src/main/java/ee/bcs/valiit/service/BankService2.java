package ee.bcs.valiit.service;

import ee.bcs.valiit.repository.BankRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService2 {

    @Autowired
    private BankRepository2 bankRepository2;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    // http://localhost:8080/bank2/createAccount?accountNr=EE125
    public void createAccount(String accountNr) {

        bankRepository2.createAccount(accountNr);
    }

    // http://localhost:8080/bank2/accountBalance?accountNr=EE125
    public BigDecimal accountBalance(String accountNr) {
        return bankRepository2.getAccountBalance(accountNr);
    }

    // http://localhost:8080/bank2/depositMoney?accountNr=EE125&amount=12
    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository2.getAccountBalance(accountNr);

        BigDecimal newBalance = balance.add(amount);

        bankRepository2.updateBalance(accountNr, newBalance);
    }

    // http://localhost:8080/bank2/withdrawMoney?accountNr=EE125&amount=12
    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bankRepository2.getAccountBalance(accountNr);

        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bankRepository2.updateBalance(accountNr, newBalance);

    }

    // http://localhost:8080/bank2/transferMoney?fromAccount=EE125&toAccount=EE124&amount=12
    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal fromBalance = bankRepository2.getAccountBalance(fromAccount);

        if (fromBalance.compareTo(amount) < 1) {
            throw new RuntimeException("Not enough money to transfer");
        }

        BigDecimal newFromBalance = fromBalance.subtract(amount);
        bankRepository2.updateBalance(fromAccount, newFromBalance);

        BigDecimal newToBalance = bankRepository2.getAccountBalance(toAccount).add(amount);
        bankRepository2.updateBalance(toAccount, newToBalance);
    }
}
