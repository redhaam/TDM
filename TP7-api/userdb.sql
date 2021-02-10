-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 10 fév. 2021 à 15:03
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `userdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `actors`
--

DROP TABLE IF EXISTS `actors`;
CREATE TABLE IF NOT EXISTS `actors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `actors`
--

INSERT INTO `actors` (`id`, `firstName`, `lastName`, `gender`) VALUES
(1, 'zzl', 'zo', 'mass'),
(2, 'zoooz', 'eeeee', 'fam'),
(3, 'tt', 'ttt', 'male'),
(4, 'allo', 'rak tesme3', 'male'),
(5, '56', '56', 'm'),
(6, 'moh', 'lamso', 'm');

-- --------------------------------------------------------

--
-- Structure de la table `cast`
--

DROP TABLE IF EXISTS `cast`;
CREATE TABLE IF NOT EXISTS `cast` (
  `id_Movie` int(11) NOT NULL,
  `id_Actor` int(11) NOT NULL,
  PRIMARY KEY (`id_Movie`,`id_Actor`),
  KEY `fk_to_actors` (`id_Actor`),
  KEY `fk_to_movies` (`id_Movie`),
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cast`
--

INSERT INTO `cast` (`id_Movie`, `id_Actor`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `year` int(11) NOT NULL,
  `language` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `movies`
--

INSERT INTO `movies` (`id`, `title`, `year`, `language`) VALUES
(1, '7rr', 2021, 'ar');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cast`
--
ALTER TABLE `cast`
  ADD CONSTRAINT `fk_to_actors` FOREIGN KEY (`id_Actor`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `fk_to_movies` FOREIGN KEY (`id_Movie`) REFERENCES `movies` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
