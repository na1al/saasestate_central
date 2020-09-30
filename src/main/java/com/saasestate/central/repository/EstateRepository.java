package com.saasestate.central.repository;


import com.saasestate.central.entity.Estate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstateRepository extends CrudRepository<Estate, Integer>, PagingAndSortingRepository<Estate, Integer> {


    public Optional<Estate> findOneByPeId(String peId);


}
