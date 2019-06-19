-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2019 at 04:22 PM
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
  `chef` bigint(20) DEFAULT NULL,
  `sous_projet` bigint(20) DEFAULT NULL,
  `type_entite_administratif` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK37tkd8d79p09lr0pwhwmdgj85` (`chef`),
  KEY `FKo30r6x9q7ymi4ig49lb15b4ba` (`sous_projet`),
  KEY `FKcqaxl2c0mosbwyrgpp8c3qr2g` (`type_entite_administratif`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entite_administratif`
--

INSERT INTO `entite_administratif` (`id`, `reference_entite_administratif`, `chef`, `sous_projet`, `type_entite_administratif`) VALUES
(1, 'Departement physique', 5, 4, 1),
(2, 'Departement informatique', 3, 4, 1),
(86, 'Decanat', 1, 2, 1);

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
(93),
(93),
(93),
(93),
(93),
(93),
(93),
(93);

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

--
-- Dumping data for table `mandat`
--

INSERT INTO `mandat` (`id`, `date_debut_mandat`, `date_fin_mandat`, `entite_administratif`, `personnel`, `responsabilite`) VALUES
(87, '2019-06-05', '2019-06-27', 86, 3, 1),
(92, '2019-06-08', '2019-07-03', 86, 6, 4);

-- --------------------------------------------------------

--
-- Table structure for table `personnel`
--

CREATE TABLE IF NOT EXISTS `personnel` (
  `id` bigint(20) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
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
  `reference_echelle` varchar(255) DEFAULT NULL,
  `reference_echelon` varchar(255) DEFAULT NULL,
  `type_personnel` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbdxvp0ijgej332o33m89w5lp` (`type_personnel`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personnel`
--

INSERT INTO `personnel` (`id`, `cin`, `date_acces_fonction_publique`, `date_activation`, `date_debut_type_personnel`, `date_exercice_echelle`, `date_naissance`, `etat_social`, `grade`, `lieu_affectation`, `lieu_naissance`, `nom`, `nombre_enfants`, `numero_location`, `prenom`, `reference_echelle`, `reference_echelon`, `type_personnel`) VALUES
(1, 'EE1', '2010-01-01', '2010-01-01', '2015-09-01', '2015-01-01', '1977-01-01', 'Etat1', 'G1', 'Marrakech', 'Rabat', 'Moha', 2, 'N.loc1', 'Taourirt', 'Echelle1', 'echelon1', 1),
(2, 'EE2', '2009-01-01', '2010-01-01', '2019-06-13', '2015-01-01', '1974-11-07', 'Etat1', 'G5', 'Marrakech', 'Marrakech', 'Berrada', 1, 'N.loc2', 'Amine', 'Echelle1', 'echelon2', 2),
(3, 'EE3', '2008-01-01', '2008-01-01', '2008-09-01', '2018-09-01', '1970-01-01', 'Etat2', 'G3', 'Marrakech', 'Marrakech', 'Amjahdi', 1, 'N.loc3', 'Ahmed', 'Echelle2', 'echelon2', 3),
(4, 'EE4', '2008-01-01', '2008-01-01', '2008-01-01', '2018-09-01', '1971-01-01', 'Etat2', 'G4', 'Marrakech', 'Fes', 'El karimi', 3, 'N.loc4', 'Zakaria', 'Echelle3', 'echelon1', 4),
(5, 'EE5', '2008-01-01', '2008-01-01', '2008-01-01', '2018-09-01', '1980-01-01', 'Etat1', 'G5', 'Marrakech', 'Tanger', 'Khalaayoun', 1, 'N.loc5', 'Ilham', 'Echelle3', 'echelon1', 5),
(6, 'EE6', '2008-01-01', '2008-01-01', '2008-01-01', '2018-09-01', '1980-01-01', 'Etat1', 'G5', 'Marrakech', 'Casablanca', 'Chami', 1, 'N.loc6', 'Hamza', 'Echelle3', 'echelon1', 6),
(7, 'EE7', '2010-01-01', '0012-11-08', '2010-01-01', '2019-06-11', '1977-01-01', 'Etat1', 'G7', 'Marrakech', 'Marrakech', 'Hafidi', 1, 'N.loc7', 'Ayman', 'Echelle3', 'echelon1', 10);

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
(1, 'Dépenses de l''administrationnn'),
(2, 'Travaux de recherche et préstations de services'),
(88, 'projet1');

-- --------------------------------------------------------

--
-- Table structure for table `responsabilite`
--

CREATE TABLE IF NOT EXISTS `responsabilite` (
  `id` bigint(20) NOT NULL,
  `reference_responsabilite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `responsabilite`
--

INSERT INTO `responsabilite` (`id`, `reference_responsabilite`) VALUES
(1, 'Doyen'),
(2, ' Chef departement Phy'),
(3, 'Responsable filiere SIR'),
(4, 'Secretaire generale	');

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
(1, 'Personnel', 1),
(2, 'Administration', 1),
(4, 'Enseignement', 2),
(5, 'Recherche', 2),
(6, 'dépenses afférentes aux étudiants', 2),
(89, 'sp1', 88),
(90, 'sp2', 88),
(91, 'sp3', 88);

-- --------------------------------------------------------

--
-- Table structure for table `type_entite_administratif`
--

CREATE TABLE IF NOT EXISTS `type_entite_administratif` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `reference` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_entite_administratif`
--

INSERT INTO `type_entite_administratif` (`id`, `libelle`, `reference`) VALUES
(1, 'Departement', 1),
(2, 'Laboratoir', 2);

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
(1, 'Doyen'),
(2, 'Vice-doyen'),
(3, 'Professeur-Info'),
(4, 'Secretaire generale'),
(5, 'Professeur-Phy'),
(6, 'Professeur-Math'),
(7, 'Professeur-Chi'),
(8, 'Professeur-Geo'),
(9, 'Professeur-Bio'),
(10, 'Technicien');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
