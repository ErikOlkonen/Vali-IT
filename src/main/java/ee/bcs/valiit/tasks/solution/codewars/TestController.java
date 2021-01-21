package ee.bcs.valiit.tasks.solution.codewars;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test/name")
    public String getHelloWorld(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
            //@RequestParam("lastName") String lastName
            ) {

        return "Hello " + firstName + " " + lastName;
    }

    @GetMapping("demo/{name}/cars")
    public String getCars(@PathVariable("name") String firstName, @RequestParam("cars") String cars) {
        return "Cars owned by " + firstName + " are " + cars;
    }

    @GetMapping("demo/{name}/siblings")
    public String getSiblings(@PathVariable("name") String name, @RequestParam("siblings") String siblings) {
        return name + " has siblings which are called: " + siblings;
    }

}



