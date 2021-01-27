package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Employee> employeelist = new ArrayList<>();

    // http://localhost:8080/test/test2?name=Erik&kood=1
    // http://localhost:8080/test/test?first_name=Paul&last_name=Puu&number_of_accounts=2
    // (Get puhul kasutame t2is urli, path+query)
    // http://localhost:8080/test/test
    // saab teha l2bi browseri, Post mapping ainult l2bi postmani
    @GetMapping("test")
    public String addcustomer(@RequestParam("first_name") String first_name,
                              @RequestParam("last_name") String last_name,
                              @RequestParam("number_of_accounts") String number_of_accounts) {
        String sql = "INSERT INTO customer (first_name, last_name, number_of_accounts) " +
                "VALUES (:first_name, :last_name, :number_of_accounts)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("first_name", first_name);
        paramMap.put("last_name", last_name);
        paramMap.put("number_of_accounts", number_of_accounts);
        jdbcTemplate.update(sql, paramMap);
        return "Employee created: " + first_name + last_name + number_of_accounts;
    }

    // localhost:8080/test/name
    @PostMapping("name")
    public Employee test2(@RequestBody Employee employee) {
        System.out.println(employee.getName());
        return employee;
    }

    // /empolyees (GET)
    // http://localhost:8080/test2/add
    @PostMapping("add")
    public void addEmployee(@RequestBody Employee employee) {
        employeelist.add(employee);
    }

    //
    // http://localhost:8080/test2/show
    @GetMapping("show")
    public List<Employee> showEmployees(Employee employee) {
        return employeelist;
    }

    // /employee/{id} (GET)
    // http://localhost:8080/test2/test2/2 siia l6ppu siis misiganes kohal ta listis on !!!
    @GetMapping("test2/id")
    public Employee EmployeeId(@PathVariable("kood") int kood) {
        return employeelist.get(kood);
    }

    // /employee/{id} (PUT)
    // http://localhost:8080/test2/replace/3
    @PutMapping("test2/replace/{id}")
    public void replaceEmployee(@PathVariable("id") int kood, @RequestBody Employee employee) {
        employeelist.set(kood, employee);
    }

    // /employee/{id} (DELETE)
    // http://localhost:8080/test2/delete/2
    @DeleteMapping("test2/delete/{id}")
    public String deletecustomer(@RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("number_of_accounts") String number_of_accounts) {
        String sql = "DELETE FROM customer WHERE id = 8";
        Map<String, String> paramMap = new HashMap<>();
        // paramMap.delete("first_name", first_name);
        paramMap.put("last_name", last_name);
        paramMap.put("number_of_accounts", number_of_accounts);
        jdbcTemplate.update(sql, paramMap);
        return first_name + last_name + number_of_accounts + ": has been deleted.";
    }
}
