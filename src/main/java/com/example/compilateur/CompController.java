package com.example.compilateur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompController {
    // http://localhost:8080//comp?name=Tremblay
    @GetMapping("/comp")
    public Comp comp(@RequestParam(value = "name", defaultValue = "world")String name){
    return new Comp(String.format(CompServices.greetingTemplate, name));
    }
}
