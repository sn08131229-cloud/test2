package com.example.trace.config;
import com.example.trace.service.ChainService;
import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.context.annotation.*;
@Configuration
public class ChainConfig {
 @Bean public ChainService chainService(@Qualifier("mockChainService") ChainService mock){ return mock; }
}
