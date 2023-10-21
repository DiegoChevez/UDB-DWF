-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2023 a las 09:44:32
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `saraviasbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietario`
--

CREATE TABLE `propietario` (
  `propietario_id` varchar(6) NOT NULL,
  `cuenta_usuario` varchar(5) NOT NULL,
  `nombres_propietario` varchar(100) NOT NULL,
  `apellidos_propietario` varchar(100) NOT NULL,
  `telefono_propietario` varchar(9) NOT NULL,
  `estado_propietario` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `propietario`
--

INSERT INTO `propietario` (`propietario_id`, `cuenta_usuario`, `nombres_propietario`, `apellidos_propietario`, `telefono_propietario`, `estado_propietario`) VALUES
('BC483P', 'BC483', 'Bruno Alejandro', 'Chevez Montes', '7777', 'Activo'),
('EF845P', 'EF845', 'Erick Eduardo', 'Fuentes Garcia', '5847-0000', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario_id` varchar(5) NOT NULL,
  `nombre_usuario` varchar(100) NOT NULL,
  `correo_usuario` varchar(100) NOT NULL,
  `contrasena_usuario` varchar(255) NOT NULL,
  `rol_usuario` enum('Administrador','Empleado','Propietario','Cliente') NOT NULL,
  `estado_usuario` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario_id`, `nombre_usuario`, `correo_usuario`, `contrasena_usuario`, `rol_usuario`, `estado_usuario`) VALUES
('BC483', 'BrunoChevez483', 'brunoale@gmail.com', 'dfgdf', 'Propietario', 'Activo'),
('BC872', 'BryanCornejo', 'bryancornejo@gmail.com', 'passw00rd123', 'Cliente', 'Activo'),
('CR425', 'CesarRodas', 'cesarrodas@gmail.com', 'passw00rd123', 'Empleado', 'Activo'),
('DC857', 'DiegoChevez', 'diegochevez@gmail.com', 'passw00rd', 'Administrador', 'Activo'),
('EF845', 'ErickFuentes', 'erickfuentes@gmail.com', 'passw00rd', 'Propietario', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`propietario_id`),
  ADD KEY `cuenta_usuario` (`cuenta_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD CONSTRAINT `propietario_ibfk_1` FOREIGN KEY (`cuenta_usuario`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
