#### Netty客户端处理逻辑
1.解析控制台指令
2.封装指令对象
3.二进制转换(编码)
4.对于收到服务端的数据，首先需要截取出一段完整的数据

#### 传统IO通信的问题
1.线程资源受限
2.线程切换效率低下
3.数据读写以字节流为单位

由此出现了NIO JDK1.4之后
第一个问题的解决:新来连接注册到selector中