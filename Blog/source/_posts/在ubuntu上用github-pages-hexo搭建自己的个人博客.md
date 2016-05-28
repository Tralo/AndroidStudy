---
title: 在ubuntu上用github pages + hexo搭建自己的个人博客
date: 2016-05-20 17:24:50
tags: [ubuntu,github,hexo]
---


这应该是本人的第一篇博客吧，说实在的，本人很懒，但命运又让我走上程序员的道路，本来乖乖以为撸码就行，但其实还是不够，要善于总结，学会分享，于是也开始跟着别人玩博客，期望是个好开头吧。记录自己搭建的过程。由于自己开发的pc系统是ubuntu(很少用window，那是用来娱乐的)，所以相对于window，安装git和nodejs更容易一些。接下来开始以下在准备工作: 

> * git安装
> * nodejs环境搭建
> * hexo安装以及使用
> * 将hexo生成的blog部署到自己github上

### git搭建

ubuntu下安装git命令:

```shell
sudo apt-get install git
sudo apt-get install git-core
```
当然之后还要去申请github账号，一般都是邮箱注册验证，接着还要在本地生成公钥，使用命令:
```shell
ssh-keygen -C "your email address@xx.com" -t rsa
```
会在用户目录下生成 ~/.ssh/下生成相应的密钥文件，然后你要将~/.ssh/目录的文件id_rsa.pub内容
拷贝到自己网上github的public key，具体就是点击Settings -> SSH and GPG keys，然后随便命令key的title，再将id_ras.pub的内容拷进即可。如果想测试链接是否畅通的话，可以通过命令:
```shell
ssh -v git@github.com
```
------


### 安装nodejs

在ubuntu安装nodejs很简单，只需执行命令:

```shell
sudo apt-get install nodejs

```
当然你如果想做node开发，那这种做法并不推荐，使用nvm来搭建node.js环境会更好，nvm可以快速更新node版本，或者切换node版本。具体做法是: 先将nvm工程clone下来，一般我会在用户目录下创建git的文件夹，用来存放clone下来的目录，方便以后整理，clone nvm工程的命令:
```shell
git clone https://github.com/cnpm/nvm.git
```
clone之后执行命令:
```shell
source ~/git/nvm/nvm.sh
```
执行命令重新打开终端，输入nvm install v0.12.14，出现Now using node v0.12.14的提示，就说明已经搭建好版本为0.12.14的nodejs环境，还可以查询下其他版本，通过命令:
```shell
nvm ls-remote
```
------

### 安装Hexo
nodejs和git安装完后，就可以安装hexo，输入命令:
```shell
npm install -g hexo-cli

```
安装过程可能会有点久，安装完开始用用hexo搭建博客。
```shell
#新建一个文件夹用于存放本地存放博客
mkdir Blog
cd Blog
#用hexo命令初始化
hexo init
#执行npm命令，npm会根据package.json创建相应的库和文件
npm install
```
生成静态文件
```shell
#使用hexo generate(hexo g也可以)命令可以把markdown文件转换成html文件
hexo generate
```
本地服务开启
```shell
hexo server
```
之后就可以下面这个样子
> 然后打开浏览器，输入localhost:4000，就可以看到生成的博客了
![](/img/first_create_blog.png)

新建博客
```shell
hexo new postname
```
会在source/_post目录下生成postname.md文件，之后就用[markdown](https://www.zybuluo.com/mdeditor)来写博客。

------
### 将hexo生成的blog部署到自己github上

在自己的github创建一个name.github.io的仓库，将https的链接复制下来，在Blog根目录的配置文件_config.yml，找到Deployment那一行，进行github pages的配置
```shell
deploy:
  type: git
  repo: https://github.com/Tralo/tralo.github.io.git
  branch: master
```
配置好后，就可以把博客部署到github上,执行命令
```shell
hexo clean
hexo generate
#部署到自己的github上，需要输入用户名和密码
hexo deploy
```
然后在浏览器地址输入 name.github.io就可以访问博客了,至此可以开始自己的博客之旅了。

------
## 记录一些细节问题
> 1.执行hexo deploy出现ERROR Deployer not found: git的错误
某些hexo插件并没有安装,稳妥点，运行以下这些命令就解决了。
```shell
npm install hexo-generator-index --save
npm install hexo-generator-archive --save
npm install hexo-generator-category --save
npm install hexo-generator-tag --save
npm install hexo-server --save
npm install hexo-deployer-git --save
npm install hexo-deployer-heroku --save
npm install hexo-deployer-rsync --save
npm install hexo-deployer-openshift --save
npm install hexo-renderer-marked@0.2 --save
npm install hexo-renderer-stylus@0.2 --save
npm install hexo-generator-feed@1 --save
npm install hexo-generator-sitemap@1 --save
```
> 2.文章插入图片
使用markdown写文章，插入图片的格式为\!\[\]\(链接地址\)，这里要说的是链接地址怎么写。这里的链接地址可以是网络地址，也可以是本地地址，在source目录下新建images文件夹，将展示图片放入，插入图片时链接地址为/images/图片名称。




