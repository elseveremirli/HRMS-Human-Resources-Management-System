package kodlama.io.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWorldController {

    @GetMapping("/public")
    public String helloWorld(){
        return "Hello World Public";
    }

    @GetMapping("/private")
    public String helloWorldPrivate(){
        return "Hello World Private";
    }
}
