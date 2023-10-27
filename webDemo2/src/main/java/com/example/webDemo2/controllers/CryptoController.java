package com.example.webDemo2.controllers;

import com.example.webDemo2.models.CryptoCurrency;
import com.example.webDemo2.services.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("crypto")
public class CryptoController {
    private CryptoService service;

    public CryptoController(CryptoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CryptoCurrency> getAll() {
        return service.getAllCurrencies();
    }

    @GetMapping("byId")
    public ResponseEntity<?> getById(String id) {
        try {
            return ResponseEntity.ok(service.getCurrenciesById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
        }
    }

    @GetMapping("abovePrice")
    public List<CryptoCurrency> getAbovePrice(double price) {
        return service.getCurrenciesAbovePrice(price);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody CryptoCurrency currency){
        if(service.addCurrency(currency))
            return ResponseEntity.status(HttpStatus.CREATED).body("Added the currency " + currency.getName());
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency id already exists!!");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(String id){
        if(service.deleteCurrencyById(id))
            return ResponseEntity.ok("Deleted!");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such id found...");
    }
}
