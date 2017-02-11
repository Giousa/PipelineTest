package com.giousa.pipelinetest.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Description: 粘包和分包处理
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:31
 */

public class Client4 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",7788);

        String message = "hello Giousa";

        byte[] bytes = message.getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(4 + bytes.length);
        buffer.putInt(bytes.length);
        buffer.put(bytes);

        byte[] array = buffer.array();

        for (int i = 0; i < 1000; i++) {
            socket.getOutputStream().write(array);
        }

        socket.close();

    }
}
