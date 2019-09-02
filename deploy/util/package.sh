#!/bin/bash

# 请注意
# 本脚本的作用是把本项目编译的结果保存到deploy文件夹中
# 1. 把项目数据库文件拷贝到deploy/db
# 2. 编译lumchine-admin
# 3. 编译lumchine-all模块，然后拷贝到deploy/lumchine

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
cd $DIR/../..
LITEMALL_HOME=$PWD
echo "LITEMALL_HOME $LITEMALL_HOME"

# 复制数据库
cat $LITEMALL_HOME/lumchine-db/sql/lumchine_schema.sql > $LITEMALL_HOME/deploy/db/lumchine.sql
cat $LITEMALL_HOME/lumchine-db/sql/lumchine_table.sql >> $LITEMALL_HOME/deploy/db/lumchine.sql
cat $LITEMALL_HOME/lumchine-db/sql/lumchine_data.sql >> $LITEMALL_HOME/deploy/db/lumchine.sql

cd $LITEMALL_HOME/lumchine-admin
# 安装阿里node镜像工具
npm install -g cnpm --registry=https://registry.npm.taobao.org
# 安装node项目依赖环境
cnpm install
cnpm run build:dep

cd $LITEMALL_HOME
mvn clean package
cp -f $LITEMALL_HOME/lumchine-all/target/lumchine-all-*-exec.jar $LITEMALL_HOME/deploy/lumchine/lumchine.jar