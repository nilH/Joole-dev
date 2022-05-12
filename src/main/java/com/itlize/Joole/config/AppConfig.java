package com.itlize.Joole.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath: /application-dev.properties")
public class AppConfig {
}
