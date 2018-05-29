CREATE TABLE ` article` (
  `id` bigint (20
) NOT NULL AUTO_INCREMENT,
  `title` varchar (200
) NOT NULL,
  `brief` varchar (255
) NOT NULL,
  ` content ` text,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
PRIMARY KEY (`id`
)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET= utf8