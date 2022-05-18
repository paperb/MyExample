package com.example.demo.config;

import com.example.demo.handler.AdminConnectionHandler;
import com.example.demo.handler.UserConnectionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.websocket.server.ServerEndpoint;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new UserConnectionHandler(),"/ws/userCount") // 普通用户websocket的连接路径
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*");
        registry.addHandler(new AdminConnectionHandler(),"/ws/admin") // 管理员websocket的连接路径
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*");
    }

    /**
     * 以下是配置WebSocket的配置属性，例如消息缓冲区大小，空闲超时等。
     * @return
     */
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        container.setMaxSessionIdleTimeout(300000L);
        return container;
    }

}
