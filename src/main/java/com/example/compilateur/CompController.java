package com.example.compilateur;

import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
public class CompController {
    // http://localhost:8080/comp?number=code
    @PostMapping("/comp")
    public Comp comp(@RequestBody String code){
        CompServices.lire(code);
    return new Comp(String.format(CompServices.status),String.format(CompServices.result), String.format(CompServices.exceptions) );
    }

    @GetMapping("/reset")
    public Comp comp(){
        CompServices.redemarrer();
        return new Comp(String.format(CompServices.status),String.format(CompServices.result), String.format(CompServices.exceptions) );
    }
}
