package com.sqg.flow.ui.config;


import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.ui.controller.FlowController;
import com.sqg.flow.ui.controller.IndexController;
import com.sqg.flow.ui.controller.NodeController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class ControllerAutoConfiguration {

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @Bean
    public NodeController nodeController(FlowHolder flowHolder) {
        return new NodeController(flowHolder);
    }

    @Bean
    public FlowController flowController(FlowHolder flowHolder) {
        return new FlowController(flowHolder);
    }

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
//        return factory -> {
//            factory.setPort(8080);
//            factory.setContextPath("/myapp");
//        };
//    }
}
