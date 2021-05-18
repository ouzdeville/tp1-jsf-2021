-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 17 mai 2021 à 19:58
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
-- Base de données :  `deliberation`
--

-- --------------------------------------------------------

--
-- Structure de la table `ec`
--

DROP TABLE IF EXISTS `ec`;
CREATE TABLE IF NOT EXISTS `ec` (
  `IDEC` int(11) NOT NULL AUTO_INCREMENT,
  `IDUE` int(11) NOT NULL,
  `VALEUR` decimal(20,0) DEFAULT NULL,
  `COEFFICIENT` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDEC`),
  KEY `FK_DEPENDRE` (`IDUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IDETUDIANT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` char(30) DEFAULT NULL,
  `PRENOM` char(30) DEFAULT NULL,
  `NUMERO_CARTE` char(15) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `EMAIL` char(30) DEFAULT NULL,
  `TEL` decimal(11,0) DEFAULT NULL,
  `LIEU` char(30) DEFAULT NULL,
  PRIMARY KEY (`IDETUDIANT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_promo`
--

DROP TABLE IF EXISTS `etudiant_promo`;
CREATE TABLE IF NOT EXISTS `etudiant_promo` (
  `IDETUDIANTP` int(11) NOT NULL AUTO_INCREMENT,
  `IDPROMO` int(11) NOT NULL,
  `IDETUDIANT` int(11) NOT NULL,
  `MONTANT` float DEFAULT NULL,
  PRIMARY KEY (`IDETUDIANTP`),
  KEY `FK_FAIRE_PARTIR` (`IDETUDIANT`),
  KEY `FK_INSCRIRE` (`IDPROMO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `IDEVALUATION` int(11) NOT NULL AUTO_INCREMENT,
  `IDEC` int(11) NOT NULL,
  `TYPE` char(15) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  PRIMARY KEY (`IDEVALUATION`),
  KEY `FK_ENRICHIR` (`IDEC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `IDFILIERE` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11) NOT NULL,
  `NOM` char(30) DEFAULT NULL,
  PRIMARY KEY (`IDFILIERE`),
  KEY `FK_DIRIGER` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `moyenne_ec`
--

DROP TABLE IF EXISTS `moyenne_ec`;
CREATE TABLE IF NOT EXISTS `moyenne_ec` (
  `IDMEC` int(11) NOT NULL AUTO_INCREMENT,
  `IDETUDIANTP` int(11) NOT NULL,
  `IDEC` int(11) NOT NULL,
  `VALEUR` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`IDMEC`),
  KEY `FK_ASSOCIATION_16` (`IDEC`),
  KEY `FK_OBTENIR` (`IDETUDIANTP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `moyenne_se`
--

DROP TABLE IF EXISTS `moyenne_se`;
CREATE TABLE IF NOT EXISTS `moyenne_se` (
  `IDMSE` int(11) NOT NULL AUTO_INCREMENT,
  `IDETUDIANTP` int(11) NOT NULL,
  `IDSEMESTRE` int(11) NOT NULL,
  `VALEUR` int(11) DEFAULT NULL,
  `ATTRIBUT_42` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDMSE`),
  KEY `FK_APPARTENIR` (`IDETUDIANTP`),
  KEY `FK_ASSOCIATION_18` (`IDSEMESTRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `moyenne_ue`
--

DROP TABLE IF EXISTS `moyenne_ue`;
CREATE TABLE IF NOT EXISTS `moyenne_ue` (
  `IDMUE` int(11) NOT NULL AUTO_INCREMENT,
  `IDETUDIANTP` int(11) NOT NULL,
  `IDUE` int(11) NOT NULL,
  `VALEUR` decimal(20,0) DEFAULT NULL,
  `CREDIT` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDMUE`),
  KEY `FK_ASSOCIATION_17` (`IDETUDIANTP`),
  KEY `FK_CAPITALISER` (`IDUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `IDNIVEAU` int(11) NOT NULL AUTO_INCREMENT,
  `IDFILIERE` int(11) NOT NULL,
  `NOM` char(10) DEFAULT NULL,
  PRIMARY KEY (`IDNIVEAU`),
  KEY `FK_CONTENIR` (`IDFILIERE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `IDNOTE` int(11) NOT NULL AUTO_INCREMENT,
  `IDETUDIANTP` int(11) NOT NULL,
  `IDEVALUATION` int(11) NOT NULL,
  `VALEUR` float DEFAULT NULL,
  PRIMARY KEY (`IDNOTE`),
  KEY `FK_AVOIR` (`IDETUDIANTP`),
  KEY `FK_COMPOSER` (`IDEVALUATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `ID_PROFIL` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` char(10) DEFAULT NULL,
  PRIMARY KEY (`ID_PROFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `promo`
--

DROP TABLE IF EXISTS `promo`;
CREATE TABLE IF NOT EXISTS `promo` (
  `IDPROMO` int(11) NOT NULL AUTO_INCREMENT,
  `IDNIVEAU` int(11) NOT NULL,
  `ANNEE_SCOLAIRE` char(10) DEFAULT NULL,
  PRIMARY KEY (`IDPROMO`),
  KEY `FK_ENGLOPER` (`IDNIVEAU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `semestre`
--

DROP TABLE IF EXISTS `semestre`;
CREATE TABLE IF NOT EXISTS `semestre` (
  `IDSEMESTRE` int(11) NOT NULL AUTO_INCREMENT,
  `VALEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDSEMESTRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ue`
--

DROP TABLE IF EXISTS `ue`;
CREATE TABLE IF NOT EXISTS `ue` (
  `IDUE` int(11) NOT NULL AUTO_INCREMENT,
  `IDPROMO` int(11) NOT NULL,
  `IDSEMESTRE` int(11) NOT NULL,
  `CODE` int(11) DEFAULT NULL,
  `NOM` char(30) DEFAULT NULL,
  `CREDIT` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDUE`),
  KEY `FK_FAIRE` (`IDPROMO`),
  KEY `FK_VALIDER` (`IDSEMESTRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PROFIL` int(11) NOT NULL,
  `NOM` char(30) DEFAULT NULL,
  `PRENOM` char(30) DEFAULT NULL,
  `TEL` decimal(11,0) DEFAULT NULL,
  `EMAIL` char(30) DEFAULT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REPRESENTER` (`ID_PROFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ec`
--
ALTER TABLE `ec`
  ADD CONSTRAINT `FK_DEPENDRE` FOREIGN KEY (`IDUE`) REFERENCES `ue` (`IDUE`);

--
-- Contraintes pour la table `etudiant_promo`
--
ALTER TABLE `etudiant_promo`
  ADD CONSTRAINT `FK_FAIRE_PARTIR` FOREIGN KEY (`IDETUDIANT`) REFERENCES `etudiant` (`IDETUDIANT`),
  ADD CONSTRAINT `FK_INSCRIRE` FOREIGN KEY (`IDPROMO`) REFERENCES `promo` (`IDPROMO`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FK_ENRICHIR` FOREIGN KEY (`IDEC`) REFERENCES `ec` (`IDEC`);

--
-- Contraintes pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD CONSTRAINT `FK_DIRIGER` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `moyenne_ec`
--
ALTER TABLE `moyenne_ec`
  ADD CONSTRAINT `FK_ASSOCIATION_16` FOREIGN KEY (`IDEC`) REFERENCES `ec` (`IDEC`),
  ADD CONSTRAINT `FK_OBTENIR` FOREIGN KEY (`IDETUDIANTP`) REFERENCES `etudiant_promo` (`IDETUDIANTP`);

--
-- Contraintes pour la table `moyenne_se`
--
ALTER TABLE `moyenne_se`
  ADD CONSTRAINT `FK_APPARTENIR` FOREIGN KEY (`IDETUDIANTP`) REFERENCES `etudiant_promo` (`IDETUDIANTP`),
  ADD CONSTRAINT `FK_ASSOCIATION_18` FOREIGN KEY (`IDSEMESTRE`) REFERENCES `semestre` (`IDSEMESTRE`);

--
-- Contraintes pour la table `moyenne_ue`
--
ALTER TABLE `moyenne_ue`
  ADD CONSTRAINT `FK_ASSOCIATION_17` FOREIGN KEY (`IDETUDIANTP`) REFERENCES `etudiant_promo` (`IDETUDIANTP`),
  ADD CONSTRAINT `FK_CAPITALISER` FOREIGN KEY (`IDUE`) REFERENCES `ue` (`IDUE`);

--
-- Contraintes pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD CONSTRAINT `FK_CONTENIR` FOREIGN KEY (`IDFILIERE`) REFERENCES `filiere` (`IDFILIERE`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `FK_AVOIR` FOREIGN KEY (`IDETUDIANTP`) REFERENCES `etudiant_promo` (`IDETUDIANTP`),
  ADD CONSTRAINT `FK_COMPOSER` FOREIGN KEY (`IDEVALUATION`) REFERENCES `evaluation` (`IDEVALUATION`);

--
-- Contraintes pour la table `promo`
--
ALTER TABLE `promo`
  ADD CONSTRAINT `FK_ENGLOPER` FOREIGN KEY (`IDNIVEAU`) REFERENCES `niveau` (`IDNIVEAU`);

--
-- Contraintes pour la table `ue`
--
ALTER TABLE `ue`
  ADD CONSTRAINT `FK_FAIRE` FOREIGN KEY (`IDPROMO`) REFERENCES `promo` (`IDPROMO`),
  ADD CONSTRAINT `FK_VALIDER` FOREIGN KEY (`IDSEMESTRE`) REFERENCES `semestre` (`IDSEMESTRE`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_REPRESENTER` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
