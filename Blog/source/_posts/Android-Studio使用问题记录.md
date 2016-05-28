---
title: Android Studio使用问题记录
date: 2016-05-22 21:48:31
tags: as工具
---
使用as工作开发时经常遇到一些奇葩问题，这里记录下,方便日后查找。
## 1.问题: 之前好端端的工程过段时间就莫名其妙的报错，报错如下:
> Plugin is too old,please update to a more recent version,or set ANDROID_DAILY_OVERRIDE environment variable to ""
然后就算点击 Fix plugin version and sync project 也没啥用，粗略的知道它的意思再加上网上的搜索，大概要更新gradle的版本，解决的办法: 修改build.gradle文件中classpath的gradle版本为2.1.0，
```
dependencies {
        classpath 'com.android.tools.build:gradle:2.1.0'
}
```
然后sycn下项目，再修改项目中目录gradle/wrapper下的文件gradle-wrapper.properties的distributionUrl: 
distributionUrl=https\://services.gradle.org/distributions/gradle-2.10-all.zip，问题就解决了。

------
(更新ing....)
