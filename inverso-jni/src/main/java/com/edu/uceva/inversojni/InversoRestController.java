package com.edu.uceva.inversojni;

import inversojni.lib.JavaInverso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inversojni-service")
public class InversoRestController {
    private JavaInverso inversor;

    public InversoRestController(){
        this.inversor = new JavaInverso();
    }

    @GetMapping("/inverso/{a}/{m}")
    public String inverso(@PathVariable int a, @PathVariable int m)  {return inversor.inversoJSON(a, m);}
}
