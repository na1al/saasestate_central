package com.saasestate.central.service;


import com.saasestate.central.entity.Currency;
import com.saasestate.central.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository repository){
        currencyRepository = repository;
    }

    public Currency findByType(Currency.CurrencyType type){
        return currencyRepository.findOneByType(type);
    }

    public ArrayList<Currency> findAll() {
        return (ArrayList<Currency>) currencyRepository.findAll();
    }

}
