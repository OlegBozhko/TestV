CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `isAdmin` bit(1) DEFAULT NULL,
  `createdDate` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`name`, `age`, `isAdmin`) VALUES
  ('user1', 10, FALSE),
  ('user2', 10, FALSE),
  ('user3', 10, FALSE),
  ('user4', 10, TRUE ),
  ('user5', 10, FALSE),
  ('user6', 10, FALSE),
  ('user7', 10, FALSE),
  ('user8', 10, FALSE),
  ('user9', 10, FALSE),
  ('user10', 10, TRUE ),
  ('user11', 10, FALSE),
  ('user12', 10, FALSE),
  ('user13', 10, FALSE),
  ('user14', 10, FALSE),
  ('user15', 10, FALSE),
  ('user16', 10, FALSE),
  ('user17', 10, FALSE),
  ('user18', 10, FALSE),
  ('user19', 10, FALSE),
  ('user20', 10, FALSE),
  ('user21', 10, FALSE),
  ('user22', 10, FALSE),
  ('user23', 10, FALSE);

