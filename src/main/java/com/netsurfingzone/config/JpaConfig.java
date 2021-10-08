package com.netsurfingzone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.netsurfingzone.repository")
public class JpaConfig {

}