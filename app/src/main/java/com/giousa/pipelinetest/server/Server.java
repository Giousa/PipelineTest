package com.giousa.pipelinetest.server;

import com.giousa.pipelinetest.handler.Handler1;
import com.giousa.pipelinetest.handler.Handler2;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:16
 */

public class Server {

    public static void main(String[] args) {

        //服务类
        ServerBootstrap bootstrap = new ServerBootstrap();
        //创建线程池
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();
        //设置NioSocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
        //设置管道工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
//                pipeline.addLast("decoder", new StringDecoder());
//                pipeline.addLast("encode", new StringDecoder());
                pipeline.addLast("handler1", new Handler1());
                pipeline.addLast("handler2", new Handler2());

                return pipeline;
            }
        });

        bootstrap.bind(new InetSocketAddress(7788));
        System.out.println("-----Server Start-----");
    }

}
