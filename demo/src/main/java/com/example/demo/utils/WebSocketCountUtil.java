package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
public class WebSocketCountUtil {
    /**
     * 静态变量，用来记录当前在线连接数。即返回前台的人数。
     */
    private static Long onlineCount = 0L;
    /**
     * 用来存放普通用户ID。
     */
    private static CopyOnWriteArraySet<String> userIdSet = new CopyOnWriteArraySet<>();
    /**
     * 用来存放普通用户Session和id。
     */
    //private static CopyOnWriteArraySet<SessionEntity> usersSessionEntitySet = new CopyOnWriteArraySet<>();
    /**
     * 用来存放管理员Session和id。
     */
    //private static CopyOnWriteArraySet<SessionEntity> adminSessionEntitySet = new CopyOnWriteArraySet<>();


    /**
     * 在线人数增加
     */
    public static void onlineCountAdd(WebSocketSession session, String userId) {
        onlineCount+=1;
//        userIdSet.add(userId);
//        //SessionEntity sessionEntity = new SessionEntity(userId, session);
//        //usersSessionEntitySet.add(sessionEntity);
//        onlineCountChangeIf();
    }

    /**
     * 在线人数减少
     */
    public static void onlineCountReduce(WebSocketSession session) {
        onlineCount-=1;
//        usersSessionEntitySet.forEach(sessionEntity -> {
//            if (sessionEntity.getSession().getId().equals(session.getId())) {
//                usersSessionEntitySet.remove(sessionEntity);
//                userIdSet.remove(sessionEntity.getUserId());
//                onlineCountChangeIf();
//            }
//        });
    }

    /**
     * admin用户增加
     */
    public static void adminSessionAdd(WebSocketSession session, String adminUserId) {
//        SessionEntity sessionEntity = new SessionEntity(adminUserId, session);
//        adminSessionEntitySet.add(sessionEntity);
    }

    /**
     * admin用户减少
     */
    public static void adminSessionReduce(WebSocketSession session) {
//        log.info("admin用户减少");
//        log.info(adminSessionEntitySet.toString());
//        adminSessionEntitySet.forEach(sessionEntity -> {
//            if (sessionEntity.getSession().getId().equals(session.getId())) {
//                adminSessionEntitySet.remove(sessionEntity);
//                log.info(adminSessionEntitySet.toString());
//            }
//        });
    }

    /**
     * 向admin推送消息
     */
    public static void setMessageToAdmin() {
//        adminSessionEntitySet.forEach(sessionEntity -> {
//            MessageEntity messageEntity = new MessageEntity("2", String.valueOf(getOnlineCount()));
//            String messageString = JSONObject.toJSONString(messageEntity);
//            try {
//                sessionEntity.getSession().sendMessage(new TextMessage(messageString));
//            } catch (IOException e) {
//                e.printStackTrace();
//                log.error("发送信息失败-->{}", e.getMessage());
//            }
//        });

    }

    public static Long getOnlineCount() {
        return onlineCount;
    }

    /**
     * 在线人数是否改变
     */
    private static void onlineCountChangeIf() {
        Long size = Long.valueOf(userIdSet.size());
        if (onlineCount.equals(size)) {
            // 在线人数没有变
            return;
        }
        // 在线人数变了
        onlineCount = size;
        // 向admin发送消息
        setMessageToAdmin();
    }
}
