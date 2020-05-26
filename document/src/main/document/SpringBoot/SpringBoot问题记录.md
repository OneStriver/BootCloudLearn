#### SpringBoot启动原理
首先主启动类上必须标注@SpringBootApplication注解，如果没有标注会报出一个错误:
Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean
包含三个注解: @Configuration + @EnableAutoConfiguration + @ComponentScan
@ComponentScan注解可以指定包扫描的路径，让Spring来扫描指定包及子包下的组件，也可以不指定路径，默认扫描当前配置类所在包及子包下的组件
这也就解释了为什么SpringBoot的启动类要放到所有类所在包的最外层
