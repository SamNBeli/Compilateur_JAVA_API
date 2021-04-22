package com.example.compilateur;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class CompController{
    // http://localhost:8080/comp?number=code

        @PostMapping("/dem")
        public Comp dem (@RequestBody String id ){
            System.out.println(id);
            CompServices.creeJsh(id);
            CompServices.creetmr(id);
            CompServices.sessTimeOut(id);
            return new Comp(String.format(CompServices.status), String.format(CompServices.result), String.format(CompServices.exceptions));
        }

    @PostMapping("/comp")
    public Comp comp(@RequestBody String code, String id){
        System.out.println("le Code est:"+code);
        if(CompServices.idenf.containsKey(id)) {
            CompServices.lire(code, id);
            CompServices.sessTimeOut(id);
        }else{
            CompServices.creeJsh(id);
            CompServices.lire(code, id);
            CompServices.sessTimeOut(id);
        }
    return new Comp(String.format(CompServices.status),String.format(CompServices.result), String.format(CompServices.exceptions) );
    }

    @PostMapping("/reset")
    public Comp reset(@RequestBody String id){
        CompServices.creeJsh(id);
        CompServices.creetmr(id);
        CompServices.redemarrer();
        System.out.println(id);
        CompServices.sessTimeOut(id);
        return new Comp(String.format(CompServices.status),String.format(CompServices.result), String.format(CompServices.exceptions) );
    }

}
