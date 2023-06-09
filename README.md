<pre style="text-align:center">
 _  _ ___ _____   _____   ___  ___   ___ _____   ___ _____ _   ___ _____ ___ ___
| \| | __| _ \ \ / / __| | _ )/ _ \ / _ \_   _| / __|_   _/_\ | _ \_   _| __| _ \
| .` | _||   /\ V /| _|  | _ \ (_) | (_) || |   \__ \ | |/ _ \|   / | | | _||   /
|_|\_|___|_|_\ \_/ |___| |___/\___/ \___/ |_|   |___/ |_/_/ \_\_|_\ |_| |___|_|_\
</pre>

<div align=center>

![Language](https://img.shields.io/github/languages/top/0604hx/boot-starter?logo=java&color=blue)
![License](https://img.shields.io/badge/License-MIT-green)
![LastCommit](https://img.shields.io/github/last-commit/0604hx/boot-starter?color=blue&logo=github)

</div>

🎉 基于 Spring Boot、Mybatis-Plus 的数据接口快速开发框架，默认使用 undertow 容器

# ✈️ 快速开始 / Quick Start
> 详细示例请见 [example](example)

① 添加依赖

```xml
<dependency>
    <groupId>org.nerve</groupId>
    <artifactId>boot-starter</artifactId>
    <version>${version}</version>
</dependency>
```

② 编辑 application.yml

```yaml
spring:
  application:
    name: EXAMPLE（演示程序）
  profiles:
    active: dev
    include: basic
```

③ 编写 Application 入口类

```java
// 将 your.pkg.name 替换成真实的包路径
package your.pkg.name;

@SpringBootApplication
@ComponentScan({"org.nerve", "your.pkg.name"})
@MapperScan({"org.nerve.boot.module", "org.nerve.boot.web.auth", "your.pkg.name"})
public class ExampleApp {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }
}
```

④ 启动应用

```text

  _  _ ___ _____   _____   ___  ___   ___ _____   ___ _____ _   ___ _____ ___ ___
 | \| | __| _ \ \ / / __| | _ )/ _ \ / _ \_   _| / __|_   _/_\ | _ \_   _| __| _ \
 | .` | _||   /\ V /| _|  | _ \ (_) | (_) || |   \__ \ | |/ _ \|   / | | | _||   /
 |_|\_|___|_|_\ \_/ |___| |___/\___/ \___/ |_|   |___/ |_/_/ \_\_|_\ |_| |___|_|_\

集成显卡  https://github.com/0604hx/boot-starter
-------------------------------------------------------------------------------------
Application 名称  ：EXAMPLE（演示程序）
SpringBoot  版本  ：2.7.5
-------------------------------------------------------------------------------------

🙂 Enjoy 🙂
```

# 🏅 关于 / About

## 版本说明

* `1.x` 开始仅支持 spring boot 3（需要 JDK 17+）
* `0.x` 为 spring boot 2
