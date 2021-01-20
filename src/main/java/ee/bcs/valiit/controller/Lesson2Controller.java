package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("lesson2")
@RestController
public class Lesson2Controller {


    // http://localhost:8080/lesson2/fib?a=1
    @GetMapping("fib")
    public static int fib(@RequestParam("a") int a) {
        return Lesson2.exercise4(a); // Tagasta fibonacci jada n element
    }

    // http://localhost:8080/lesson2/length?x=1&y=6
    @GetMapping("length")
    public static String length(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson2.exercise5(x, y);
    }

    // VOID
    // http://localhost:8080/lesson2/paarisarv?x=8
    //@GetMapping("paarisarv")
    //public static int paarisarv(@RequestParam("x") int x ) {
    //    return Lesson2.exercise2(x);
    //}


}
