package com.example.webDemo2.controllers;

import com.example.webDemo2.models.CryptoCurrency;
import com.example.webDemo2.services.CryptoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CryptoCurrency getById(String id) {
        return service.getCurrenciesById(id);
    }

    @GetMapping("abovePrice")
    public List<CryptoCurrency> getAbovePrice(double price) {
        return service.getCurrenciesAbovePrice(price);
    }

    @PostMapping
    public String add(@RequestBody CryptoCurrency currency) {
        return service.addCurrency(currency);
    }

    @DeleteMapping
    public String delete(String id) {
        return service.deleteCurrencyById(id);
    }
}
