package com.sqg.flow.starter;


import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.spring.FlowInstancesScanner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ FlowConfigProps.class })
public class FlowAutoConfiguration {

    @Bean
    public FlowInstancesScanner flowInstancesScanner(FlowHolder flowHolder,FlowConfigProps flowConfigProps) {
        return new FlowInstancesScanner(flowHolder, flowConfigProps.getSource());
    }

    @Bean
    public FlowHolder flowHolder() {
        return new FlowHolder();
    }
}
