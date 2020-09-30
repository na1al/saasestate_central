package com.saasestate.central.config;

import com.saasestate.central.dto.EstateDto;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.LoggingErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;

@Configuration
public class KakfaConfiguration {


    @Bean
    public KafkaTemplate<String, EstateDto> kafkaTemplate(ProducerFactory<String, EstateDto> factory) {
        return new KafkaTemplate<>(factory);
    }

    @Bean
    public ProducerFactory<String, EstateDto> producerFactory(KafkaProperties properties) {
        return new DefaultKafkaProducerFactory<>(properties.buildProducerProperties());
    }

    @Bean
    protected ConsumerFactory<Object, EstateDto> createConsumerFactory(KafkaProperties properties) {
        return new DefaultKafkaConsumerFactory<>(properties.buildConsumerProperties());
    }

    @Bean
    public LoggingErrorHandler errorHandler() {
        return new LoggingErrorHandler();
    }

}
