---
title: python学习笔记
date: 2016-05-24 17:17:31
tags: python
---
### 1.input函数和raw_input函数
raw_input(string)函数从标准输入中读取一行，并返回一个字符串(去掉换行符号):

```python
#!/usr/bin/python
# -*- coding: UTF-8 -*- 
str = raw_input("请输入：");
print "你输入的内容是: ", str
```
运行:
> 请输入: 啦啦
> 你输入的内容是:  Hello Python！

------

input函数与raw_input函数基本类似，但是input可以接受一个Python表达式作为输入，并将运算结果返回:

```python
#!/usr/bin/python
# -*- coding: UTF-8 -*- 
str = input("请输入：");
print "你输入的内容是: ", str
```
运行:
> 请输入: [x*5 for x in range(2,10,2)]
> 你输入的内容是:  [10, 20, 30, 40]


