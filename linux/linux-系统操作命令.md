#linux 系统操作命令#

**环境:centos7**

##具体操作命令


###显示当前的目录名称


- pwd 显示当前的⽬目录名称


###文件查看


-  ls 查看当前⽬目录下的⽂文件
-  ls [选项，选项… ] 参数 …  
    
-  常用参数：
-  -l 长格式显示⽂文件
-  -a 显示隐藏⽂文件
-  -r 逆序显示
-  -t 按照时间顺序显示
-  -R 递归显示



### 更改当前的操作目录
**1.cd 更改当前的操作目录**
- cd /path/to/…. 绝对路径
- cd ./path/to/… 相对路径
-  cd ../path/to/… 相对路径

### 建立目录

- mkdir 建立目录
- 建立多级目录
- -p 建立多及目录

###复制文件

1.cp 复制文件和目录
2.cp [选项] 文件路径
3.cp [选项] 文件… 路径
**4.常用参数**
-  -r 复制目录
-  -p 保留用户、权限、时间等文件属性
-  -a 等同于 -dpR

### 移动文件

-   mv 源文件 目标文件
-   mv 源文件 目录
   
###删除文件
 ** rm删除文件**
   rm -r 删除目录（包括目录下的所有文件）
   rm -f 删除文件下不进行提示

###文件查看命令
- cat 文件内容显示到终端
- head 查看文件开头
- tail 查看文件结尾
- 常用参数 -f文件内容更新后，显示信息同步更新
- wc 统计文件内容信息

### 压缩与解压缩

**压缩**

- tar -cvf jpg.tar *.jpg //将目录里所有jpg文件打包成jpg.tar 

- tar -czf jpg.tar.gz *.jpg   //将目录里所有jpg文件打包成jpg.tar后，并且将其用gzip压缩，生成一个gzip压缩过的包，命名为jpg.tar.gz
 
-  tar -cjf jpg.tar.bz2 *.jpg //将目录里所有jpg文件打包成jpg.tar后，并且将其用bzip2压缩，生成一个bzip2压缩过的包，命名为jpg.tar.bz2

- tar -cZf jpg.tar.Z *.jpg   //将目录里所有jpg文件打包成jpg.tar后，并且将其用compress压缩，生成一个umcompress压缩过的包，命名为jpg.tar.Z

- rar a jpg.rar *.jpg //rar格式的压缩，需要先下载rar for linux zip jpg.zip *.jpg //zip格式的压缩，需要先下载zip for linux

**解压**

- tar -xvf file.tar //解压 tar包
 
- tar -xzvf file.tar.gz //解压tar.gz
 
- tar -xjvf file.tar.bz2   //解压 tar.bz2
 
- tar -xZvf file.tar.Z   //解压tar.Z
 
- unrar e file.rar //解压rar
 
- unzip file.zip //解压zip