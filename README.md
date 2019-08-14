# spiderLibrary
![一个闪亮的jitpack狗牌](https://www.jitpack.io/v/littleSpdier/spiderLibrary.svg "狗版闪闪闪, 闪瞎你眼")<br/>
这是我正式做的一个依赖库, 里面会加入各种常用的工具类、封装类, 还有一些常用的第三方法也会将其jar包加入进来
<br/>自定义封装类使用方法也会尽可能的罗列出来.

在项目中使用该库的方法
在你当前modole的gradle中添加
```groovy
    	dependencies {
	        implementation 'com.github.littleSpdier:spiderLibrary:Tag'
	}
```
在你项目的gradle中添加
```groovy
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```