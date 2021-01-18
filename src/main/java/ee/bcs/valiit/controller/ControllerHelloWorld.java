package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHelloWorld {

    @GetMapping("test")
    public String getHelloWorld(
            //@PathVariable("userName") String userName, @PathVariable("lastName") String lastName
    ) {

        return "Hello";
        //+ userName + lastName ;
    }


}
