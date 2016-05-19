# Kafka客户端


kafka版本:0.9.0.0


## 运行Demo
#### 第一步
打开 `demo`中的 `test/resources/spring/spring-context.xml` 配置文件,修改kafka集群地址.
#### 第二步
启动 demo模块中的`com.system.kafka.clients.demo.producer.ProducerTest.singleSendMessageTest()` 方法，即可发送消息到kafka集群。
默认情况下，消费者也同时启动。
<br/><br/><br/>

## 项目中引入

#### 第一步
在项目中,需要引入

```
        <dependency>
            <groupId>com.system.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>2.1.0-SNAPSHOT</version>
        </dependency>
```
#### 第二步
引入`test/resources/spring/spring-context.xml`配置。
### 第三步
修改集群地址。

### 第四步

修改`test/resources/spring/spring-context.xml`中的扫描路径。

替换`消息传输对象` ，在 `<bean name =consumerHandler`中的属性【<b>transObj</b>】替换为你自己的传输对象。

同样替换`注入消息处理类对象` 的属性【receiptObj】为你自己的处理对象。

注意： receiptObj必须继承`BizHandleInterface`.