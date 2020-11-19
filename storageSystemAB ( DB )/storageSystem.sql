DROP SCHEMA IF EXISTS `storageSystem`;

CREATE SCHEMA `storageSystem`;

use `storageSystem`;

SET FOREIGN_KEY_CHECKS = 0;
# --------------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long,
  `user_name` nvarchar(50) NOT NULL ,
  `email` nvarchar(50) NOT NULL,
  `password` nvarchar(150) NOT NULL,
  `address` nvarchar(300) ,
  `phone` int(15),
  `role_id` int(11),
  `date_modify` datetime ,
  `modified_by` int(11) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------
DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `units`;

CREATE TABLE `units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `stores`;

CREATE TABLE `stores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  `location` nvarchar(200),
  `user_id` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `store_type`;

CREATE TABLE `store_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  `location` nvarchar(200),
  `store_id` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  `unit_id` int(11),
  `store_type_id` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `projects`;

CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  `address` nvarchar(200),
  `user_id` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `incoming_companies`;

CREATE TABLE `incoming_companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  `address` nvarchar(200),
  `phone` int(15),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------
# الاذنات

DROP TABLE IF EXISTS `bill_type`;

CREATE TABLE `bill_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` nvarchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `bills`;

CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_generation` nvarchar(50),
  `incoming_company_id` int(11),
  `store_id` int(11),
  `bill_type_id` int(15),
  `project_id` int(15),
  `store_id_to` int(15),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `bill_products`;

CREATE TABLE `bill_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11),
  `bill_id` int(11),
  `category_id` int(11),
  `notes` nvarchar(300),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `sys_gender`;

CREATE TABLE `sys_gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` nvarchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;