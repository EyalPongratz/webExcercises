package com.example.webDemo2.services;

import com.example.webDemo2.models.CryptoCurrency;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CryptoService {
    private List<CryptoCurrency> currencies = new ArrayList<>();

    public boolean addCurrency(CryptoCurrency currency) {
        for (CryptoCurrency c: currencies) {
            if(c.getId().equals(currency.getId()))
                return false;
        }
        currencies.add(currency);
        return true;
    }

    public List<CryptoCurrency> getAllCurrencies() {
        return currencies;
    }

    public CryptoCurrency getCurrenciesById(String id) {
        return currencies.stream().filter(c-> c.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<CryptoCurrency> getCurrenciesAbovePrice(double price) {
        return currencies.stream().filter(c-> c.getPrice() > price).toList();
    }

    public boolean deleteCurrencyById(String id) {
        Iterator<CryptoCurrency> iterator = currencies.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            CryptoCurrency currency = iterator.next();
            if (currency.getId().equals(id)) {
                iterator.remove(); // Use the iterator's remove method to safely remove the element.
                found = true;
            }
        }

        return found;
    }
}
