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

public class HelloHandler extends SimpleChannelHandler {

    private int count;

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        System.out.println("HelloHandler :" + e.getMessage()+"  count="+count++);

    }
}
