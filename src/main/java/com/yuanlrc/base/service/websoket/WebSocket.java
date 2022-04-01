package com.yuanlrc.base.service.websoket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {

    /**
     * 在线人数
     */
    public static int onlineNumber = 0;
    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();

    /**
     * 会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String userId;




    /**
     * OnOpen 表示有浏览器链接过来的时候被调用
     * OnClose 表示浏览器发出关闭请求的时候被调用
     * OnMessage 表示浏览器发消息的时候被调用
     * OnError 表示有错误发生，比如网络断开了等等
     */

    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        onlineNumber++;
        log.info("现在来连接的客户id：" + userId);
        this.userId = userId;
        this.session = session;

        log.info("有新连接加入！ 当前在线人数" + onlineNumber);
        try {
            clients.put(userId, this);
            //给自己发一条消息：告诉自己现在都有谁在线
            Map<String, Object> map2 = new HashMap<>();
            map2.put("messageType", 1);
            //移除掉自己
            Set<String> set = clients.keySet();
            map2.put("onlineUsers", set);
            map2.put("userId",userId);
            sendMessageAll(JSON.toJSONString(map2));
        } catch (IOException e) {
            log.info(userId + "上线的时候通知所有人发生了错误");
        }

    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.info("服务端发生了错误" + error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber--;
        //webSockets.remove(this);
        clients.remove(userId);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String, Object> map1 = new HashMap<>();
            map1.put("messageType", 2);
            map1.put("onlineUsers", clients.keySet());
            map1.put("userId", userId);
            sendMessageAll(JSON.toJSONString(map1));
        } catch (IOException e) {
            log.info(userId + "下线的时候通知所有人发生了错误");
        }
        log.info("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            log.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
            JSONObject jsonObject = JSON.parseObject(message);
            String textMessage = jsonObject.getString("message");
            String userId = jsonObject.getString("userId");
            String to = jsonObject.getString("to");
            //如果不是发给所有，那么就发给某一个人
            //messageType 1代表上线 2代表下线  4代表普通消息
            Map<String, Object> map1 = new HashMap<>();
            map1.put("messageType", 4);
            map1.put("textMessage", textMessage);
            map1.put("fromusername", userId);
            map1.put("tousername", to);
            sendMessageTo(JSON.toJSONString(map1), to);
        } catch (Exception e) {
            log.info("发生了错误了");
        }
    }

    public void sendMessageTo(String message, String userId) throws IOException {
        for (WebSocket item : clients.values()) {
            if (item.userId.equals(userId)) {
                item.session.getAsyncRemote().sendText(message);
                break;
            }
        }
    }

    public void sendMessageAll(String message) throws IOException {
        for (WebSocket item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

//    public static synchronized int getOnlineCount() {
//        return onlineNumber;
//    }

}


