package project.chatwebsocket.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import project.chatwebsocket.handler.ChatHandler;

@EnableWebSocket
@Configuration
@RequiredArgsConstructor
@Log4j2
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/chat/websocket")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();

        log.info("registerWebSocketHandlers connect");
    }

}
