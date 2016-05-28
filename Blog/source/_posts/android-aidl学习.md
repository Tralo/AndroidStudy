---
title: android aidl学习
date: 2016-05-23 16:41:56
tags: android aidl
---

Android 系统中，各应用程序都运行在自己的进程中，进程之间一般无法直接进行数据交换，为了实现这种跨进程通信(interprocess communication，简称IPC)，Android提供了AIDL Service。Java中是部支持跨进程内存共享的，因此需要传递对象，需要把对象解析成操作系统能够理解的数据格式，以达到跨界对象访问的目的。在JavaEE中，采用RMI通过序列化传递对象。在Android中，则采用AIDL(Android Interface Define Language: 接口定义语言)方式实现。
