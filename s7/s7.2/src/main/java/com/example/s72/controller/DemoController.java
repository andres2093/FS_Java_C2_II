package com.example.s72.controller;

import com.example.s72.entity.Auto;
import com.example.s72.entity.Casa;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/micro")
public class DemoController {

    @PostMapping("/auto")
    public void recibe(@RequestBody Auto auto){
        System.out.println(auto.toString());
    }

    @PostMapping("/casa")
    public void recibeCasa(@RequestBody Casa casa){
        System.out.println(casa.toString());
    }
}
