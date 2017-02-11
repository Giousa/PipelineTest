package com.giousa.pipelinetest.handler;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.UpstreamMessageEvent;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:19
 */

public class Handler1 extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        ChannelBuffer buffer = (ChannelBuffer) e.getMessage();

        byte[] array = buffer.array();

        String message = new String(array);
        System.out.println("handler 1 :"+message);

        ctx.sendUpstream(new UpstreamMessageEvent(ctx.getChannel(),message,e.getRemoteAddress()));

    }
}
