package com.work.learn.test1.netty;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @description: 客户端
 * @author: HeYin
 * @date: 2020-05-22 13:50
 * @version: 1.0
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
