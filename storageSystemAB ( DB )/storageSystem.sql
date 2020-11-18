DROP SCHEMA IF EXISTS `storageSystem`;

CREATE SCHEMA `storageSystem`;

use `storageSystem`;

SET FOREIGN_KEY_CHECKS = 0;
# --------------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long,
  `is_admin` int(11) default 0,
  `user_name` varchar(50) NOT NULL ,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `date_modify` datetime ,
  `modified_by` int(11) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `sys_gender`;

CREATE TABLE `sys_gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `gender` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;