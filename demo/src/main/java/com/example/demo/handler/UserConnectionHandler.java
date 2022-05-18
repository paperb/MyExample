package com.example.demo.handler;


import com.example.demo.utils.WebSocketCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;


import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class UserConnectionHandler implements WebSocketHandler {


    private static Map<String,WebSocketSession> SESSION_MAP= new ConcurrentHashMap<>();
    public Session session;
    /**
     * 建立连接后触发的回调
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.warn("用户连接成功->{}",session);
        session.sendMessage(new TextMessage("ok"));
        WebSocketCountUtil.onlineCountAdd(session,"123");
        log.info(WebSocketCountUtil.getOnlineCount().toString());

    }

    /**
     * 收到消息时触发的回调
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        TextMessage textMessage = (TextMessage)message;
        log.warn("收到消息->{}",textMessage);
        //MessageEntity messageEntity = JSONObject.parseObject(textMessage.getPayload(), MessageEntity.class);
        WebSocketCountUtil.onlineCountAdd(session,"123");
    }

    /**
     * 传输消息出错时触发的回调
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("传输消息出错"+"afterConnectionClosed");
        System.out.println(session);
    }

    /**
     * 断开连接后触发的回调
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.warn("断开连接->{}",session);
        WebSocketCountUtil.onlineCountReduce(session);
        log.info("当前连接数"+WebSocketCountUtil.getOnlineCount());
    }

    /**
     * 是否处理分片消息
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


    public void sendAllSessionMessage(String msg) {
        for (WebSocketSession session : SESSION_MAP.values()) {
            try {
                session.sendMessage(new TextMessage(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }}
