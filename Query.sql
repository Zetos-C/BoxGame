-- Dumping database structure for BoxGame
CREATE DATABASE IF NOT EXISTS `BoxGame` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BoxGame`;

-- Dumping structure for table BoxGame.Items
CREATE TABLE IF NOT EXISTS `Items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
);

-- Data exporting was unselected.

-- Dumping structure for table BoxGame.UserItems
CREATE TABLE IF NOT EXISTS `UserItems` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `itemId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_UserItems_Users` (`userId`),
  KEY `FK_UserItems_Items` (`itemId`),
  CONSTRAINT `FK_UserItems_Items` FOREIGN KEY (`itemId`) REFERENCES `Items` (`id`),
  CONSTRAINT `FK_UserItems_Users` FOREIGN KEY (`userId`) REFERENCES `Users` (`id`)
);

-- Data exporting was unselected.

-- Dumping structure for table BoxGame.Users
CREATE TABLE IF NOT EXISTS `Users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password_hash` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `coin` int DEFAULT '0',
  `points` int DEFAULT '0',
  PRIMARY KEY (`id`)
);

-- Data exporting was unselected.

-- Dumping structure for table BoxGame.UserTheme
CREATE TABLE IF NOT EXISTS `UserTheme` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `themeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_UserTheme_Users` (`userId`),
  KEY `FK_UserTheme_Items` (`themeId`),
  CONSTRAINT `FK_UserTheme_Items` FOREIGN KEY (`themeId`) REFERENCES `Items` (`id`),
  CONSTRAINT `FK_UserTheme_Users` FOREIGN KEY (`userId`) REFERENCES `Users` (`id`)
);
