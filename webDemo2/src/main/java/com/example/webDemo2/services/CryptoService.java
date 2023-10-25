package com.example.webDemo2.services;

import com.example.webDemo2.models.CryptoCurrency;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {
    private List<CryptoCurrency> currencies = new ArrayList<>();

    public String addCurrency(CryptoCurrency currency) {
        for (CryptoCurrency c: currencies) {
            if(c.getId().equals(currency.getId()))
                return "Id already in use";
        }
        currencies.add(currency);
        return "Crypto Currency added";
    }

    public List<CryptoCurrency> getAllCurrencies() {
        return currencies;
    }

    public CryptoCurrency getCurrenciesById(String id) {
        return currencies.stream().filter(c-> c.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<CryptoCurrency> getCurrenciesAbovePrice(double price) {
        return currencies.stream().filter(c-> c.getPrice() >= price).toList();
    }

    public String deleteCurrencyById(String id) {
        boolean found = false;
        for (CryptoCurrency currency: currencies) {
            if (currency.getId().equals(id)) {
                found = true;
                currencies.remove(currency);
            }
        }
        if (found)
            return "Currency deleted";
        else
            return "Currency not found";
    }
}
