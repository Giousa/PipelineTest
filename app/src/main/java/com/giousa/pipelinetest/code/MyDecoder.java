package com.giousa.pipelinetest.code;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:46
 */

public class MyDecoder extends FrameDecoder {
    @Override
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {

        if(channelBuffer.readableBytes() > 4){

            //标记
            channelBuffer.markReaderIndex();

            //长度
            int length = channelBuffer.readInt();

            if(channelBuffer.readableBytes() < length){
                channelBuffer.resetReaderIndex();
                //缓存当前剩余的buffer数据,等待剩下数据包到来
                return  null;
            }

            //读数据
            byte[] bytes = new byte[length];
            channelBuffer.readBytes(bytes);

            //往下传递对象
            return new String(bytes);
        }


        //缓存当前剩余的buffer数据,等待剩下数据包到来



        return null;
    }
}
