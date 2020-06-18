#### Bean的生命周期
1. 实例化Bean：Ioc容器通过获取BeanDefinition对象中的信息进行实例化，实例化对象被包装在BeanWrapper对象中
2. 设置对象属性（DI）：通过BeanWrapper提供的设置属性的接口完成属性依赖注入
3. 注入Aware接口（BeanFactoryAware， 可以用这个方式来获取其它 Bean，ApplicationContextAware）：
Spring会检测该对象是否实现了xxxAware接口，并将相关的xxxAware实例注入给bean
4. BeanPostProcessor：自定义的处理（分前置处理和后置处理）
5. InitializingBean和init-method：执行我们自己定义的初始化方法
6. 使用
7. destroy:bean的销毁

#### Spring的IOC注入方式
构造器注入
setter方法注入
注解注入
接口注入

#### 怎么检测循环依赖
Bean在创建的时候可以给该Bean打标，如果递归调用回来发现正在创建中的话，即说明了循环依赖了

#### 怎么解决Spring循环依赖
参考:https://zhuanlan.zhihu.com/p/62382615

#### Spring AOP原理 JDK动态代理和CGLIB动态代理
参考:
https://juejin.im/post/5c3e9c37f265da61263862f1
https://mp.weixin.qq.com/s/NZP2_I918SplJy_zAuhing

#### Spring的事务传播机制
REQUIRED:如果当前没有事务就创建一个事务，如果当前有事务，就加入事务
SUPPORTS:支持当前事务，如果当前存在事务，就加入事务，如果当前不存在事务，就以非事务方式执行
MANDATORY:支持当前事务，如果当前存在事务，就加入是我，如果当前不存在事务，就抛出异常
REQUIRES_NEW:创建新事务，无论当前是否存在事务，都创建新事务
NOT_SUPPORTED:以非事务方式运行，如果当前存在事务，就把当前事务挂起
NEVER:以非事务方式执行，如果当前存在事务，则抛出异常
NESTED:如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行 savepoints

#### Spring中都使用了哪些设计模式
1. 工厂模式
2. 单例模式
3. 代理模式
......

#### SpringMVC执行流程
1. 用户发送请求至前端控制器DispatcherServlet
2. DispatcherServlet收到请求调用HandlerMapping处理器映射器
3. 处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet
4. DispatcherServlet通过HandlerAdapter处理器适配器调用处理器
5. HandlerAdapter执行处理器(handler，也叫后端控制器)
6. Controller执行完成返回ModelAndView
7. HandlerAdapter将handler执行结果ModelAndView返回给DispatcherServlet
8. DispatcherServlet将ModelAndView传给ViewResolver视图解析器
9. ViewResolver解析后返回具体View对象
10. DispatcherServlet对View进行渲染视图(即将模型数据填充至视图中)
11. DispatcherServlet响应用户

#### 原生Spring组件装配的方式
1. 使用模式注解@Component等
2. 使用配置类@Configuration和@Bean
3. 使用模块注解@Enablexxx和@Import

#### Spring如何解决的循环依赖
```text
参考文章:
https://mp.weixin.qq.com/s/5mwkgJB7GyLdKDgzijyvXw
```
























































