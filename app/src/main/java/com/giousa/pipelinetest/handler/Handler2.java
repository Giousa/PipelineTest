package com.giousa.pipelinetest.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:19
 */

public class Handler2 extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        String message = (String) e.getMessage();

        System.out.println("handler 2 :" + message);

    }
}
