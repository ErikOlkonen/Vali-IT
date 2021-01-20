package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson3;
import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("lesson3hard")
@RestController
public class Lesson3HardController {

    /*


    static int count = 0;
    static String answer = " ";
    // localhost:8080/lesson3Hard/guess?a=123
    @GetMapping("randomgame")
    public String randomgame(@RequestParam("a") int a) {
        count++;
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (count < 10){
            answer = "Sinu katsed on otsas! 6ige number on " + randomNumber;
            return answer;
        } else if (a == randomNumber){
            answer = "6ige vastus! Arvasid 2ra " + count + "korral!";
            return  answer;
        }
        return Lesson3Hard.randomGame(a);
    }

     */

}
