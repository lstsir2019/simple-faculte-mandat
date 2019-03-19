-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2019 at 10:46 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `simple_faculte_mandat`
--

-- --------------------------------------------------------

--
-- Table structure for table `entite_administratif`
--

CREATE TABLE IF NOT EXISTS `entite_administratif` (
  `id` bigint(20) NOT NULL,
  `reference_entite_administratif` varchar(255) DEFAULT NULL,
  `sous_projet` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo30r6x9q7ymi4ig49lb15b4ba` (`sous_projet`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5),
(5),
(5),
(5),
(5),
(5),
(5);

-- --------------------------------------------------------

--
-- Table structure for table `mandat`
--

CREATE TABLE IF NOT EXISTS `mandat` (
  `id` bigint(20) NOT NULL,
  `date_debut_mandat` date DEFAULT NULL,
  `date_fin_mandat` date DEFAULT NULL,
  `entite_administratif` bigint(20) DEFAULT NULL,
  `personnel` bigint(20) DEFAULT NULL,
  `responsabilite` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK147ifan35yke6qqfnmu6j5r5a` (`entite_administratif`),
  KEY `FKp3nykj5su6og7njs0ws4q29rh` (`personnel`),
  KEY `FKf746xabyw5q5nuvwuuai30k4j` (`responsabilite`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personnel`
--

CREATE TABLE IF NOT EXISTS `personnel` (
  `id` bigint(20) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `code_echelle` varchar(255) DEFAULT NULL,
  `code_echelon` varchar(255) DEFAULT NULL,
  `date_acces_fonction_publique` date DEFAULT NULL,
  `date_activation` date DEFAULT NULL,
  `date_debut_type_personnel` date DEFAULT NULL,
  `date_exercice_echelle` date DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `etat_social` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `lieu_affectation` varchar(255) DEFAULT NULL,
  `lieu_naissance` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nombre_enfants` int(11) NOT NULL,
  `numero_location` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `type_personnel` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbdxvp0ijgej332o33m89w5lp` (`type_personnel`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personnel`
--

INSERT INTO `personnel` (`id`, `cin`, `code_echelle`, `code_echelon`, `date_acces_fonction_publique`, `date_activation`, `date_debut_type_personnel`, `date_exercice_echelle`, `date_naissance`, `etat_social`, `grade`, `lieu_affectation`, `lieu_naissance`, `nom`, `nombre_enfants`, `numero_location`, `prenom`, `type_personnel`) VALUES
(1, 'EE1', 'CC12', 'CB66', '2016-06-06', '2016-09-03', '2018-02-12', '2019-03-20', '1990-03-16', 'EE', 'GG', 'marrakech', 'marrakech', 'Ghouat', 2, 'GH12', 'Abdou', 1);

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id` bigint(20) NOT NULL,
  `libellep` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `libellep`) VALUES
(1, 'PPP');

-- --------------------------------------------------------

--
-- Table structure for table `responsabilite`
--

CREATE TABLE IF NOT EXISTS `responsabilite` (
  `id` bigint(20) NOT NULL,
  `poste` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sous_projet`
--

CREATE TABLE IF NOT EXISTS `sous_projet` (
  `id` bigint(20) NOT NULL,
  `reference_sous_projet` varchar(255) DEFAULT NULL,
  `projet` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKecnorhtu6rnk3w5itqc03u2du` (`projet`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sous_projet`
--

INSERT INTO `sous_projet` (`id`, `reference_sous_projet`, `projet`) VALUES
(2, 'SS', 1),
(3, 'MM', 1),
(4, 'KK', 1);

-- --------------------------------------------------------

--
-- Table structure for table `type_personnel`
--

CREATE TABLE IF NOT EXISTS `type_personnel` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_personnel`
--

INSERT INTO `type_personnel` (`id`, `libelle`) VALUES
(1, 'doyen');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
