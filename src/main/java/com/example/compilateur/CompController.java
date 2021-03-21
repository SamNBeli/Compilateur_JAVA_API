package com.example.compilateur;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class CompController {
    // http://localhost:8080/comp?number=code
    @PostMapping("/comp")
    public Comp comp(@RequestParam(value = "number")String v1){
        CompServices.lire(v1);
    return new Comp(String.format(CompServices.status),String.format(CompServices.result), String.format(CompServices.exceptions) );
    }

}
