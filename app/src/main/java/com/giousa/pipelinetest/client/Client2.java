package com.giousa.pipelinetest.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/2/11
 * Time:下午4:31
 */

public class Client2 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",7788);

        socket.getOutputStream().write("hello Giousa".getBytes());

        socket.close();

    }
}
