package ee.bcs.valiit.controller;


import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("bank")
public class BankController {


    @Autowired
    private BankService bankService;

    // http://localhost:8080/bank/createCustomer?firstName=Peeter&lastName=Puu

    @PostMapping("createCustomer")
    public void createCustomer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, String number_of_accounts) {
        bankService.createCustomer(firstName, lastName, number_of_accounts);
    }

    // http://localhost:8080/bank/createAccount?accountNr=EE123&customer_id=1
    @PostMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String accountNr, int customer_id) {
        bankService.createAccount(accountNr, customer_id);
        return "Sinu konto number on: " + accountNr;
    }

    // http://localhost:8080/bank/accountBalance?accountNr=EE123
    // get account balance (show balance)
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        // Kuidas saaks teha nii, et returni hulgas oleks ka midagi nagu näiteks "Your account number
        // is EEXXX" ? Et seda kuvatakse Postmanis.
        return bankService.getAccountBalance(accountNr);
    }

    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=12
    @PutMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bankService.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=12
    @PutMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal
            amount) {
        bankService.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @PutMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bankService.transferMoney(fromAccount, toAccount, amount);
    }
}


