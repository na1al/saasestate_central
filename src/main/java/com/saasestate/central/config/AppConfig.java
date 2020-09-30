package com.saasestate.central.config;

import com.saasestate.central.component.geo.GeoCoder;
import com.saasestate.central.component.geo.GeoCoderImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GeoCoder geoCoder(@Value("${geo.url}") String url, @Value("${geo.access}") String access) {
        return new GeoCoderImpl( url, access);
    }

}
