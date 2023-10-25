package com.example.webDemo1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("add")
    public int addNums(int num1, int num2) {
        return num1 + num2;
    }

    @GetMapping("mult")
    public int multNums(int num1, int num2) {
        return num1 * num2;
    }

    @GetMapping("isPrime")
    public String isPrime(int num) {
        if(isPrimeUtil(num))
            return num + " is prime";
        else
            return num + " is not prime";
    }

    public boolean isPrimeUtil(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
