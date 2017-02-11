package com.giousa.pipelinetest.client;

import com.giousa.pipelinetest.handler.Handler1;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:16
 */

public class Client {

    public static void main(String[] args) throws InterruptedException {

        //服务类
        ClientBootstrap bootstrap = new  ClientBootstrap();

        //线程池
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        //socket工厂
        bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));

        //管道工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
//                pipeline.addLast("decoder", new StringDecoder());
//                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("handler1", new Handler1());
                return pipeline;
            }
        });

        //连接服务端
        ChannelFuture connect = bootstrap.connect(new InetSocketAddress("127.0.0.1", 7788));
        Channel channel = connect.sync().getChannel();

        System.out.println("-----Client Start-----");

    }
}
