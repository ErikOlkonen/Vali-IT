package ee.bcs.valiit.repository;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("createCustomer")
    public String createCustomer(String firstName, String lastName, String number_of_accounts) {
        String sql8 = "INSERT INTO customer (first_name, last_name, number_of_accounts) VALUES (:first_name, :last_name, :number_of_accounts)";
        // String sql9 = "INSERT INTO account (customer_id) VALUES (:customer_id)";
        Map<String, String> accountMap = new HashMap();
        accountMap.put("first_name", firstName);
        accountMap.put("last_name", lastName);
        accountMap.put("number_of_accounts", number_of_accounts);
        jdbcTemplate.update(sql8, accountMap);
        // Map<String, String> customerMap = new HashMap();
        // customerMap.put("customer_id", customer_id);
        // jdbcTemplate.update(sql9, customerMap);
        return "Customer created " + firstName + " " + lastName;
    }

    public void createAccount(String accountNr, int id) {
        String sql = "INSERT INTO account (accountnr, balance, customer_id) VALUES (:accountNr, :balance, :customer_id)";
        Map<String, Object> accountMap = new HashMap();
        System.out.println(sql);
        accountMap.put("accountNr", accountNr);
        accountMap.put("balance", BigDecimal.ZERO);
        accountMap.put("customer_id", id);
        jdbcTemplate.update(sql, accountMap);
    }

    public BigDecimal getAccountBalance(String accountNr) {
        String sql = "SELECT balance FROM account WHERE accountnr = :accountNumber";
        Map<String, String> accountMap = new HashMap<>();
        accountMap.put("accountNumber", accountNr);

        return jdbcTemplate.queryForObject(sql, accountMap, BigDecimal.class);
        // throw new BankException("Invalid money!")
    }


    public BigDecimal updateAccountBalance(String accountNr, BigDecimal newBalance) {
        String updateStatement = "UPDATE account SET balance = :balance WHERE accountnr = :accountNumber";
        Map<String, Object> accountMap2 = new HashMap();
        accountMap2.put("accountNumber", accountNr);
        accountMap2.put("balance", newBalance);
        jdbcTemplate.update(updateStatement, accountMap2);
        return newBalance;
    }

    public String findPasswordByUsername(String username) {
        String sql55 = "SELECT password FROM clients WHERE username = :username";
        Map<String, Object> passwordMap = new HashMap<>();
        passwordMap.put("username", username);
        return jdbcTemplate.queryForObject(sql55, passwordMap, String.class);

        // return jdbcTemplate.queryForObjects(sql55, passwordMap);
        // mida peaksin siit returnima ???
    }

}
