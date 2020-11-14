CREATE TABLE `users` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `created_at` timestamp default current_timestamp,
  `updated_at` timestamp default current_timestamp on update current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `news_feed` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `news_id` BIGINT  NOT NULL,
  `user_id` BIGINT  NOT NULL,
  `created_at` timestamp default current_timestamp,
  `updated_at` timestamp default current_timestamp on update current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `news` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `head_line` varchar(50) DEFAULT NULL,
  `summary` varchar(1024) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `image` blob,
  `created_at` timestamp default current_timestamp,
  `updated_at` timestamp default current_timestamp on update current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `created_at` timestamp default current_timestamp,
  `updated_at` timestamp default current_timestamp on update current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



--drop database duedots;
--create database duedots;
--use duedots;
--truncate table schema_version;
--select * from schema_version;
--drop table users;
--select * from news;