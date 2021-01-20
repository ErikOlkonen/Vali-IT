package ee.bcs.valiit.tasks;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test2")
public class EmployeeController {

    public List<Employee> employeelist = new ArrayList<>();

    // http://localhost:8080/test2/test2?name=Erik&kood=1
    @GetMapping("test2")
    public Employee getEmployee(@RequestParam("name") String name, @RequestParam("kood") int kood) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setKood(kood);
        return employee;
    }

    @PostMapping("test2")
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
    public Employee EmployeeId(@PathVariable("kood")int kood) {
        return employeelist.get(kood);
    }

    // /employee/{id} (PUT)
    // http://localhost:8080/test2/replace/3
    @PutMapping("test2/replace/{id}")
    public void replaceEmployee(@PathVariable("id")int kood, @RequestBody Employee employee) {
        employeelist.set(kood, employee);
    }

    // /employee/{id} (DELETE)
    // http://localhost:8080/test2/delete/2
    @DeleteMapping("test2/delete/{id}")
    public void deleteEmployee(@PathVariable("id")int kood) {
        employeelist.remove(kood);
    }
}
