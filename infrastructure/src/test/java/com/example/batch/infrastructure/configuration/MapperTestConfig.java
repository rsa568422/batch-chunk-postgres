package com.example.batch.infrastructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.batch.infrastructure.mapper")
public class MapperTestConfig {
}
