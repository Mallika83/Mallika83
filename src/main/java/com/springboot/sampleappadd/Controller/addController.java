package com.springboot.sampleappadd.Controller;

import com.springboot.sampleappadd.Model.Inputs;
import com.springboot.sampleappadd.Service.addService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class addController {
    @Autowired
    private addService service;
    @PostMapping("/addNumbers")
    public ResponseEntity<Float> addNumbers(@RequestBody Inputs inputs) throws RuntimeException
    {
        System.out.println("Inside Add Controller");
        try
        {
            if((inputs.getInput1()) ==  null || inputs.getInput2() == null)
            {
                System.out.println("Inside if block");
                throw new IllegalArgumentException("Inputs are invalid");
             }
            else {
               float result = service.addNumbers(inputs);
               return ResponseEntity.ok(result);
            }
        }
        catch(Exception ex)
        {
           throw new IllegalArgumentException(ex);
        }

    }
}
