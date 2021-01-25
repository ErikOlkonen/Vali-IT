package ee.bcs.valiit.controller;


import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("bank")
public class BankController {
    @Autowired
    private BankService bankService;

    // HashMap<String, BigDecimal> accountMap2 = new HashMap<>();

    // http://localhost:8080/bank/bank?accountNr=EE123
    @PostMapping("bank")
    public String createAccount(@RequestParam("accountNr") String accountNr) {
        bankService.createAccount(accountNr);
        return "Sinu konto number on: " + accountNr;
        /*
        String sql = "INSERT INTO account (accountnr, balance) VALUES (:accountNr, :balance)";
        Map<String, Object> accountMap = new HashMap();
        System.out.println(sql);
        accountMap.put("accountNr", accountNr);
        accountMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, accountMap);

         */
        // return BankService createAccount;
        // accountMap.put(accountNr, BigDecimal.ZERO);
    }

    // http://localhost:8080/bank/accountBalance?accountNr=EE123
    // get account balance (show balance)
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        // Kuidas saaks teha nii, et returni hulgas oleks ka midagi nagu näiteks "Your account number
        // is EEXXX" ? Et seda kuvatakse Postmanis.
        return bankService.getAccountBalance(accountNr);
        // return accountMap.get(accountNr);
    }

    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService.depositMoney(accountNr, amount);
        /*
        BigDecimal balance = getAccountBalance(accountNr);

        BigDecimal newBalance = balance.add(amount);

        updateAccountBalance(accountNr, newBalance);

         */
    }

    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService.withdrawMoney(accountNr, amount);
        //BigDecimal balance = accountMap.get(accountNr);
        /*
        BigDecimal balance = getAccountBalance(accountNr);

        BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }

        updateAccountBalance(accountNr, newBalance);

         */
    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bankService.transferMoney(fromAccount, toAccount, amount);
        /*
        //100
        BigDecimal fromBalance = getAccountBalance(fromAccount);
        // kas fromAccountil on piisavalt raha?
        if (fromBalance.compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money to transfer");
        }
        // kontol on piisavalt raha, 100-50=50, newFromBalance on 50
        BigDecimal newFromBalance = fromBalance.subtract(amount);
        updateAccountBalance(fromAccount, newFromBalance);
        // uus muutuja newToBalance = toAccountBalance + amount.
        BigDecimal newToBalance = getAccountBalance(toAccount).add(amount);
        updateAccountBalance(toAccount, newToBalance);

         */

    }
/*
    // meetod andmebaasist balance pärimiseks, sisend accounrNr
    public BigDecimal getAccountBalance(String accountNr) {
        String sql = "SELECT balance FROM account where accountnr = :accountNumber";
        Map<String, String> accountMap = new HashMap<>();
        accountMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, accountMap, BigDecimal.class);

    }

    // meetod andmebaasist balanci uuendamiseks, sisendid accountNr ja uus balance
    public void updateAccountBalance(String accountNr, BigDecimal newBalance) {
        String updateStatement = "UPDATE account SET balance = :balance WHERE accountnr = :accountNumber";
        Map<String, Object> accountMap2 = new HashMap();
        accountMap2.put("accountNumber", accountNr);
        accountMap2.put("balance", newBalance);
        jdbcTemplate.update(updateStatement, accountMap2);
    }

 */
}
