package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("math")
@RestController
public class MathUtilController {

    // http://localhost:8080/math/min2?a=15&b=15
    @GetMapping("min2")
    public static int min(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1MathUtil.min(a, b);

    }

    // http://localhost:8080/math/min3?a=15&b=15&c=4
    @GetMapping("min3")
    public static int min(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        int miinimum = Lesson1MathUtil.min(a, b, c);
        return miinimum;
    }

    // http://localhost:8080/math/max3?a=15&b=15&c=4
    @GetMapping("max3")
    public static int max3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        int maksimum = Lesson1MathUtil.max(a, b, c);
        return maksimum;
    }

    // http://localhost:8080/math/isEven?a=7
    @GetMapping("isEven")
    public static boolean isEven(@RequestParam("a") int a) {
        boolean isEven = Lesson1MathUtil.isEven(a);

        return isEven;
    }

    // http://localhost:8080/math/abs?a=-89
    @GetMapping("abs")
    public static int abs(@RequestParam("a") int a) {
        return Lesson1MathUtil.abs(a);

    }


}


