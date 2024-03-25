package com.springboot.sampleappadd.Service;

import com.springboot.sampleappadd.Model.Inputs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class addService {

    public Float addNumbers(Inputs inputs) {

                System.out.println("Inside else block");

                float sum = inputs.getInput1() + inputs.getInput2();
                return sum;



    }
}
