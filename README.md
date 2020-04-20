# translate-tool
基于mybatis-plus的批量翻译工具

## 功能
1. 使用注解`@Translate`配置翻译规则，使用注解`@Dictionary`配置字典信息
2. 使用`Translate.parse()`方法即可实现单值翻译或集合批量翻译
## Todo
1. 在方法上使用注解进行aop对返回值翻译，而无需手动调用`Translate.parse()`方法
