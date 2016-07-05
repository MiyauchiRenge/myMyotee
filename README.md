# myMyotee
脸萌（FaceQ) Android简单demo

### 编译环境

Nexus 6.0.1 API23

###应用截图

<img src="https://raw.githubusercontent.com/Winky93/myMyotee/master/2.png" width = "473" height = "800" alt="图片名称" align=center />

<img src="https://raw.githubusercontent.com/Winky93/myMyotee/master/1.png" width = "473" height = "800" alt="图片名称" align=center />

### myMyotee实现了哪些功能？

* 脸萌的主界面布局，按键响应，声音 ，分享（待实现?)
* 核心UI的实现，包括ViewPage, SVG, Android与Javascript响应。
* 考虑到只是原理解析，只实现了face，eyes，hair的替换，其他部件可以触类旁通。
* 实现原理参考了脸萌官方（通过ApkTool获取解析包，获得思路，当然，代码很多部分都是参考了他们的。
* 有个Bug， ViewPage下的gridview组件'listselector'属性无法实现selected响应，但能实现pressed响应。


###有问题反馈

* 邮件: jxyouwei@gmail.com
* QQ: 932992110

###使用的第三方开源库

* [ViewPagerIndicator](https://github.com/LuckyJayce/ViewPagerIndicator) /实现横向菜单导航
* [Dialogplus](https://github.com/orhanobut/dialogplus)  /分享按钮
* [Material Dialogs](https://github.com/afollestad/material-dialogs) /新品对话框按钮
