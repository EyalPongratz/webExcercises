package com.example.webHomeExcercise1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    @GetMapping("greet")
    public String greet() {
        String[] greetings = {"hello", "hi", "greetings"};
        return greetings[(int) (Math.random() * greetings.length)];
    }

    @GetMapping("length")
    public int textLength(String txt) {
        return txt.length();
    }

    @GetMapping("reverse")
    public String reverseText(String txt) {
        StringBuilder reversed = new StringBuilder();
        for (int i = txt.length() - 1; i >= 0; i--) {
            reversed.append(txt.charAt(i));
        }
        return reversed.toString();
    }

    @GetMapping("count")
    public int countInText(String txt, String toFind) {
        int count = 0;
        int index = 0;

        while (index < txt.length()) {
            index = txt.indexOf(toFind, index);
            if (index != -1) {
                count++;
                index += 1;
            } else {
                break;
            }
        }

        return count;
    }

    @GetMapping("password")
    public String passwordStrength(String password) {
        boolean hasDigit = false, hasUppercase = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                hasDigit = true;
            else if (Character.isUpperCase(password.charAt(i)))
                hasUppercase = true;

            if (hasDigit && hasUppercase)
                return "Strong password";
        }
        if (hasDigit)
            return "Average password";
        else
            return "Weak password";
    }

}
