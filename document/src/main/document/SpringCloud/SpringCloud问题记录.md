### Eureka
#### Eureka的基本概念
Register:服务注册
当Eureka客户端向Eureka Server注册时，它提供自身的元数据，比如IP地址、端口，运行状况指示符URL，主页等

Renew:服务续约
Eureka客户会每隔30秒发送一次心跳来续约。通过续约来告知Eureka Server该Eureka客户仍然存在，没有出现问题。
正常情况下，如果Eureka Server在90秒没有收到Eureka客户的续约，它会将实例从其注册表中删除。 建议不要更改续约间隔。

Fetch Registries:获取注册列表信息
Eureka客户端从服务器获取注册表信息，并将其缓存在本地。客户端会使用该信息查找其他服务，从而进行远程调用。
该注册列表信息定期（每30秒钟）更新一次。
每次返回注册列表信息可能与Eureka客户端的缓存信息不同， Eureka客户端自动处理。
如果由于某种原因导致注册列表信息不能及时匹配，Eureka客户端则会重新获取整个注册表信息。
Eureka服务器缓存注册列表信息，整个注册表以及每个应用程序的信息进行了压缩，压缩内容和没有压缩的内容完全相同。
Eureka客户端和Eureka服务器可以使用JSON/XML格式进行通讯。在默认的情况下Eureka客户端使用压缩JSON格式来获取注册列表的信息。

Cancel:服务下线
Eureka客户端在程序关闭时向Eureka服务器发送取消请求。发送请求后，该客户端实例信息将从服务器的实例注册表中删除。
该下线请求不会自动完成，它需要调用以下内容：DiscoveryManager.getInstance().shutdownComponent()；

Eviction:服务剔除
在默认的情况下，当Eureka客户端连续90秒没有向Eureka服务器发送服务续约，即心跳，Eureka服务器会将该服务实例从服务注册列表删除，即服务剔除。

#### Eureka注册原理分析
DiscoveryClient的register方法
EurekaClient注册一个实例为什么这么慢:
EurekaClient启动完成，不是立即向Eureka Server注册，它有一个延迟向服务端注册的时间，通过跟踪源码，可以发现默认的延迟时间为40秒
EurekaServer的响应缓存:
EurekaServer维护每30秒更新的响应缓存,可通过更改配置eureka.server.responseCacheUpdateIntervalMs来修改。 
EurekaServer刷新缓存:
Eureka客户端保留注册表信息的缓存。该缓存每30秒更新一次（如前所述）。因此，客户端决定刷新其本地缓存并发现其他新注册的实例可能需要30秒。
LoadBalancerRefresh:
Ribbon的负载平衡器从本地的EurekaClient获取服务注册列表信息。Ribbon本身还维护本地缓存，以避免为每个请求调用本地客户端。 
此缓存每30秒刷新一次（可由ribbon.ServerListRefreshInterval配置）。所以可能需要30多秒才能使用新注册的实例。

#### Eureka的自我保护模式
当一个新的EurekaServer出现时，它尝试从相邻节点获取所有实例注册表信息。如果从Peer节点获取信息时出现问题，EurekaServe会尝试其他的Peer节点。
如果服务器能够成功获取所有实例，则根据该信息设置应该接收的更新阈值。
如果有任何时间，EurekaServer接收到的续约低于为该值配置的百分比（默认为15分钟内低于85％），则服务器开启自我保护模式，即不再剔除注册列表的信息。
这样做的好处就是，如果是EurekaServer自身的网络问题，导致EurekaClient的续约不上，EurekaClient的注册列表信息不再被删除，也就是EurekaClient还可以被其他服务消费。

#### Feign原理分析
@FeignClient(value = "service-a",configuration = FeignConfig.class)
value是调用服务的名称,configuration是配置文件
FeignClient注解被@Target(ElementType.TYPE)修饰,表示FeignClient注解的作用目标在接口上
```java
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}
```
你可以重写FeignClientsConfiguration中的bean，从而达到自定义配置的目的，
比如FeignClientsConfiguration的默认重试次数为Retryer.NEVER_RETRY，即不重试，那么希望做到重写就需要自定义配置类FeignConfig
更改了该FeignClient的重试次数，重试间隔为100ms，最大重试时间为1s,重试次数为5次

#### 总结:Feign源码的实现的过程
1.首先通过@EnableFeignCleints注解开启FeignCleint
2.根据Feign的规则实现接口，并加@FeignCleint注解
3.程序启动后，会进行包扫描，扫描所有的@FeignCleint的注解的类，并将这些信息注入到ioc容器中。
4.当接口的方法被调用，通过jdk的代理，来生成具体的RequestTemplate
5.RequestTemplate在生成Request
6.Request交给Client去处理，其中Client可以是HttpUrlConnection、HttpClient也可以是Okhttp
7.最后Client被封装到LoadBalanceClient类，这个类结合类Ribbon做到了负载均衡。













































































































