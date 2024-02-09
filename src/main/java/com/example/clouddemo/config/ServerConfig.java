package com.example.clouddemo.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Configuration
@PropertySource("file:/etc/config/application.properties") // Specify the mount path of the custom property file
@NoArgsConstructor
@Setter
@Getter
@Slf4j
public class ServerConfig {
    @Value("${farewell.message}")
    private String farewellMsg;

    @Bean
    public String showMyProperty(){
        return "Properties file attribute vale is ::"+ getFarewellMsg();
    }

}
