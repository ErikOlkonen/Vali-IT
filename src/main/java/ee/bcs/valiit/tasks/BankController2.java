package ee.bcs.valiit.tasks;

import ee.bcs.valiit.service.BankService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController
public class BankController2 {

    @Autowired
    private BankService2 bankService2;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/bank2/createCustomer?firstName=Peeter&lastName=Puu
    @GetMapping("createCustomer")
    public String createCustomer( String firstName, String lastName) {
        String sql8 = "INSERT INTO customer (first_name, last_name) VALUES (:first_name, :last_name)";
        Map<String, String> paramMap = new HashMap();
        paramMap.put("first_name", firstName);
        paramMap.put("last_name", lastName);
        jdbcTemplate.update(sql8, paramMap);
        return "Customer created";
    }
    // http://localhost:8080/bank2/createAccount?accountNr=EE123
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr){
        bankService2.createAccount(accountNr);
        //accountMap.put(accountNr, BigDecimal.ZERO);
    }

    // http://localhost:8080/bank2/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr){
        return bankService2.accountBalance(accountNr);
        // return accountMap.get(accountNr);
    }

    // http://localhost:8080/bank2/depositMoney?accountNr=EE123&amount=12
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount){
        bankService2.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bank2/withdrawMoney?accountNr=EE123&amount=12
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount){
        bankService2.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank2/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount){
        bankService2.transferMoney(fromAccount, toAccount, amount);
    }
    // customer tabel juurde teha, kus on kirjas kliendid (nimi, peremini ja siis customer id).
    // customer tabel on juba kasutuses.
    // account tabelisse siis ainult id ja kontode list?
    // omavahel need 2ra linkida siis id-de kaudu.
    // lvl 2. transaction history ka teha

    // jdbcTemplate.queryForList <-- tagastab 1 tulba

    // TTY andmebaasid loengud, netis yleval ka.
    //
}
