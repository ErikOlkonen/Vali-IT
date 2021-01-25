package ee.bcs.valiit.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {
        String sql = "INSERT INTO account (accountnr, balance) VALUES (:accountNr, :balance)";
        Map<String, Object> accountMap = new HashMap();
        System.out.println(sql);
        accountMap.put("accountNr", accountNr);
        accountMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, accountMap);
    }
    public BigDecimal getAccountBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE accountnr = :accountNumber";
        Map<String, String> accountMap = new HashMap<>();
        accountMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, accountMap, BigDecimal.class);
    }
    public BigDecimal updateAccountBalance(String accountNr, BigDecimal newBalance) {
        String updateStatement = "UPDATE account SET balance = :balance WHERE accountnr = :accountNumber";
        Map<String, Object> accountMap2 = new HashMap();
        accountMap2.put("accountNumber", accountNr);
        accountMap2.put("balance", newBalance);
        jdbcTemplate.update(updateStatement, accountMap2);
        return newBalance;
    }

}
