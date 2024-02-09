package com.example.clouddemo.schedule;

import com.example.clouddemo.config.ServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Component
@Slf4j
public class TriggerConfig {
    @Autowired
    private ServerConfig serverConfig;

    // Executes every 5 seconds after the previous invocation completes.
    @Scheduled(fixedDelay = 5000)
    public void checkMessage() {

        log.info("The message invoke at :: "+ LocalDateTime.now() +" Message is ::"+ serverConfig.showMyProperty());
    }
}
