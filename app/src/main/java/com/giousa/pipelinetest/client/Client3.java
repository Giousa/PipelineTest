package com.giousa.pipelinetest.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Description: 粘包和分包
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:31
 */

public class Client3 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",7788);

        for (int i = 0; i < 1000; i++) {
            socket.getOutputStream().write("hello Giousa".getBytes());
        }

        socket.close();

    }
}
