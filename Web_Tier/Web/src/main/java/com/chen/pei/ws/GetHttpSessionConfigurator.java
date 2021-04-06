package com.chen.pei.ws;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
    //此方法用来获取httpssion对象
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        if(httpSession != null) {
            //运用session的字节码作为user的唯一标识
            sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
        }
    }
}
