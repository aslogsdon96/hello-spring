package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //Handles request at localhost:8080/hello
    @GetMapping("firstHello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //Handles request at localhost:8080/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of form /hello?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name ) {
        return "Hello, " + name + "!";
    }

    //Handles requests of form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
