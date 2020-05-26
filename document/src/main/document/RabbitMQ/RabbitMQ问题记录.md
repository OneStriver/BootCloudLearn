#### RabbitMQ的交换器类型
一般情况下交换器分发会先找出绑定的队列，然后再判断routekey，来决定是否将消息分发到某一个队列中
1. fanout  不判断routekey,直接将消息转发到绑定的队列
2. direct  判断routekey是完全匹配模式
3. topic   判断routekey是模糊匹配模式
4. header  (类型为headers的交换器与前面三种匹配方式完全不一样，它不依赖与bindingKey和routingKey，而是在绑定队列与交换器的时候指定一个键值对；
当交换器在分发消息的时候会先解开消息体里的headers数据，然后判断里面是否有所设置的键值对，如果发现匹配成功，才将消息分发到队列中)
参考:https://segmentfault.com/a/1190000022588933








































