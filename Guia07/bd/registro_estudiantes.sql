-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 26-08-2022 a las 00:28:52
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registro_estudiantes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE IF NOT EXISTS `estudiantes` (
  `carnet` varchar(8) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `edad` int(11) NOT NULL,
  `cum` decimal(10,2) NOT NULL,
  `genero` char(1) NOT NULL,
  `carrera` varchar(40) NOT NULL,
  PRIMARY KEY (`carnet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`carnet`, `nombres`, `apellidos`, `edad`, `cum`, `genero`, `carrera`) VALUES
('CS150769', 'Carlos', 'Castillo', 23, '7.60', 'm', 'Técnico en computación'),
('RV064898', 'Manuel', 'Gomez', 23, '8.60', 'm', 'Licenciatura en filosofia'),
('RV064899', 'Sarai', 'Argueta', 28, '8.90', 'F', 'Ingeniería aeronáutica'),
('VC050679', 'Melvyn', 'Valdez', 35, '8.00', 'M', 'Técnico en electrónica');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
