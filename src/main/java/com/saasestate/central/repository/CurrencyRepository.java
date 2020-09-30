package com.saasestate.central.repository;


import com.saasestate.central.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {

    public Currency findOneByType(Currency.CurrencyType type);

}
