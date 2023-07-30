package com.zayver.testservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@Slf4j
public class DatabaseConfig {


    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Autowired
    private DataSourceProperties dataSourceProperties;


    @Bean
    public DataSource dataSource(){
        try{
            DriverManager.getConnection(dataSourceUrl, dataSourceProperties.getUsername(), dataSourceProperties.getPassword());
            log.info("Connected to primary database");
        } catch (Exception e) {
            log.error("Failed to connect to primary Database, using h2 fallback. "+ e.getMessage());
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .build();
        }
        return DataSourceBuilder.create()
                .url(dataSourceUrl)
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }
}
