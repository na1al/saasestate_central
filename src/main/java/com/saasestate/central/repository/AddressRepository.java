package com.saasestate.central.repository;

import com.saasestate.central.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    public Optional<Address> findOneByPlaceId(String id);
}
