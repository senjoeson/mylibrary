# mylibrary




用于日常使用开发的基类库
---内部集成一些常用的工具类
---增加适配资源文件
---增加ButterKnife使用
---增加简易MVP使用



注意:
>由于很多基类都默认使用了基类库中的application,

>所以使用本依赖创建主Module的Appcalition时,

>一定要继承LibraryApplication

>本依赖库已经集成ButterKnife使用,

>请在项目级gradle文件中加入 classpath 'com.jakewharton:butterknife-gradle-plugin:8.8.1'

>以及在主APP的gradle文件中加入 annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
