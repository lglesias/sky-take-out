package com.sky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *
 * ClassName: WebSocketConfiguration
 * Package: com.sky.config
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/10/8 14:22
 * @Version 1.0
 */
@Configuration
public class WebSocketConfiguration {

    /**
     * 配置WebSocket
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
