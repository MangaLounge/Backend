package com.readowo.api.ConfigWeb;

import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public SaveGenreDtos saveGenreDtos() {
        return new SaveGenreDtos();
    }
}
