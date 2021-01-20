package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson3;
import ee.bcs.valiit.tasks.solution.SolutionLesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("lesson3")
@RestController
public class Lesson3Controller {

    // localhost:8080/lesson3/sum?x=10,9,8,7,6,5,4,3,2,1
    @GetMapping("sum")
    public int sum(@RequestParam("x") int[] x) {
        return Lesson3.sum(x);
    }

    // localhost:8080/lesson3/factorial?x=10
    @GetMapping("factorial")
    public int factorial(@RequestParam("x") int x) {
        return Lesson3.factorial(x);
    }

    // localhost:8080/lesson3/sort?x=6,2,9,1,7,3,10
    @GetMapping("sort")
    public int[] sort(@RequestParam("x") int[] a) {
        return Lesson3.sort(a);
    }
    // localhost:8080/lesson3/isprime?x=6
    @GetMapping("isprime")
    public boolean isPrime(@RequestParam("x") int x) {
        return Lesson3.isPrime(x);

    }

}
