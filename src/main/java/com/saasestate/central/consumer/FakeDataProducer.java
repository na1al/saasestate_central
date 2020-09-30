package com.saasestate.central.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saasestate.central.dto.EstateDto;
import com.saasestate.central.entity.Estate;
import com.saasestate.central.mappers.EstateMapper;
import com.saasestate.central.service.EstateService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public class FakeDataProducer {

    public FakeDataProducer(Validator validator, EstateMapper mapper, EstateService estateService, KafkaTemplate<String, EstateDto > kafkaTemplate) throws IOException, ExecutionException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        EstateDto dto = objectMapper.readValue(new File("./staff.json"), EstateDto.class);

//        var errors = validator.validate(dto);
//
//        for (ConstraintViolation<EstateDto> constraintViolation : errors) {
//            System.out.println(constraintViolation.getMessage());
//        }


       kafkaTemplate.send("estate.sale.kyiv",dto).get();

//        Estate estate = mapper.toEntity(dto);
//        estateService.save(estate);
//
//        System.out.println("OKKKKKKKK++++++++++++++++++++++++++++++");

    }



}
