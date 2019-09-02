drop database if exists lumchine;
drop user if exists 'lumchine'@'localhost';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database lumchine default character set utf8mb4 collate utf8mb4_unicode_ci;
use lumchine;
create user 'lumchine'@'localhost' identified by 'lumchine';
grant all privileges on lumchine.* to 'lumchine'@'localhost';
flush privileges;