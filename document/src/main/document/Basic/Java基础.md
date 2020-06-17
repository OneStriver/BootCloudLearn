#### 实例化一个类的方式
1. 通过构造方法实例化一个类
2. 通过Class实例化一个类
3. 通过反射实例化一个类
4. 通过克隆实例化一个类
5. 通过反序列化实例化一个类
6. 通过Unsafe实例化一个类

#### StringUtils字符串工具类左侧补齐（leftPad）、右侧补齐（rightPad）、左右两侧补齐(center)工具方法
* 左侧补齐 第一个参数：原始字符串，第二个参数：字符串的长度，第三个是补充的字符串
* String s = StringUtils.leftPad("1", 5, "0");
* 左侧补齐 第一个参数：原始字符串，第二个参数：字符串的长度，第三个是补充的字符
* String s1 = StringUtils.leftPad("1", 5, 'a');
* 获取字符串左侧指定长度的字符串，第一个参数：原字符串，第二个参数：取左侧字符串的长度
* String s2 = StringUtils.left("177哈哈", 5);
* 左侧补齐，默认使用空格补齐，第一个参数：原字符串，第二个参数：字符串总长度，不足用空格补全
* String s3 = StringUtils.leftPad("21", 3);

#### Serializable兼容性问题及serialVersionUID的使用
兼容也就是版本控制，java通过一个名为UID（stream unique identifier）来控制，
这个UID是隐式的，它通过类名，方法名等诸多因素经过计算而得，理论上是一一映射的关系，也就是唯一的。
如果UID不一 样的话，就无法实现反序列化了，并且将会得到InvalidClassException。
当我们要人为的产生一个新的版本（实现并没有改动），而抛弃以前的版本的话，可以通过显式的声名UID来实现:
private static final long serialVersionUID=1L;

#### happen-before原则
1. 程序次序规则
2. 锁定规则
3. volatile变量规则
4. 传递规则
5. 线程启动规则
6. 线程中断规则
7. 线程终结规则
8. 对象终结规则

#### JDK1.7和JDK1.8之后的JVM内存区域划分
参考:https://blog.csdn.net/Hollake/article/details/92762180

#### Java中的Checked Exception和Unchecked Exception的区别
将派生于Error或者RuntimeException的异常称为unchecked异常,所有其他的异常成为checked异常

Checked Exception
代码需要处理API抛出的checked exception,要么用catch语句,要么直接用throws语句抛出去
Unchecked Exception
代码不需要处理它们的异常也能通过编译

检查性异常: 不处理编译不能通过
非检查性异常：不处理编译可以通过,如果有抛出直接抛到控制台
运行时异常： 就是非检查性异常
非运行时异常： 就是检查性异常

```text
根据List<User>中User对象的age属性计算总和
方式一:
int ageSum = userList.stream().collect(Collectors.summingInt(User::getAge));
方式二:
int ageSumTwo = userList.stream().filter(user -> user.getAge() != null).mapToInt(User::getAge).sum();
List转Map
方式一:
如果name相同就会报错
Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, 
                        Hosting::getWebsites
                )
        );
方式二:
添加 (oldValue, newValue) -> oldValue
如果name相同取旧值
Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, 
                        Hosting::getWebsites,
                        (oldValue, newValue) -> oldValue
                )
        );
```




























































