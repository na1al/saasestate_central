package com.saasestate.central.service;

import com.saasestate.central.dto.EstateDto;
import com.saasestate.central.entity.Estate;
import com.saasestate.central.mappers.EstateMapper;
import com.saasestate.central.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstateService {

    EstateRepository estateRepository;

    EstateMapper mapper;


    public EstateService(EstateRepository estateRepository, EstateMapper mapper) {
        this.estateRepository = estateRepository;
        this.mapper = mapper;
    }

    public void save(EstateDto dto) {

        var entity = estateRepository
                .findOneByPeId(dto.getPeId())
                .orElse(null);
        
        var estate = mapper.toEntity(dto, entity);
        estateRepository.save(estate);
    }

    public Optional<Estate> findOne(int id) {
        return estateRepository.findById(id);
    }

}
