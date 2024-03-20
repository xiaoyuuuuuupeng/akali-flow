package com.sqg.flow.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "akali.flow", ignoreUnknownFields = true)
public class FlowConfigProps {
    private String source;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
