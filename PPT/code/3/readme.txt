.java文件是Java编写的
.cpp文件是C编写的

java文件存储为UTF格式，而Windows环境默认编码非utf8，所以编译的时候，应该使用以下命令：

javac -encoding utf-8 OOPExample.java