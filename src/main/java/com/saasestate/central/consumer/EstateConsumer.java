package com.saasestate.central.consumer;

import com.saasestate.central.dto.EstateDto;
import com.saasestate.central.service.EstateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.Validator;

@Service
@Slf4j
@Validated
public class EstateConsumer {

    EstateService estateService;

    Validator validator;

    public EstateConsumer(EstateService estateService, Validator validator) {
        this.estateService = estateService;
        this.validator = validator;
    }

    @KafkaListener(topics = "estate.sale.kyiv")
    public void estateListenerOne(@Valid EstateDto dto, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(dto);
        estateService.save(dto);
    }



}
