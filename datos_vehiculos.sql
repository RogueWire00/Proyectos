-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2019 a las 05:59:29
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `datos_vehiculos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `Placa` varchar(5) NOT NULL,
  `Modelo` varchar(200) NOT NULL,
  `Marca` varchar(200) NOT NULL,
  `Anio` int(11) NOT NULL,
  `Motor` varchar(5) NOT NULL,
  `Precio` double NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Descripcion` varchar(1000) NOT NULL,
  `Imagen` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`Placa`, `Modelo`, `Marca`, `Anio`, `Motor`, `Precio`, `Nombre`, `Descripcion`, `Imagen`) VALUES
('PDP01', 'BMW01', 'BMW', 2018, '2.0', 200000, 'FAST1', 'vehiculo,Comprado en Agencia poco uso con 90 mil millas\r\n', '/imagen/bmw.PNG'),
('PDZ90', 'Sorento', 'Kia', 2012, '2.0', 300000, 'SOR1', 'Vehiculo en perfectas condiciones, Recien pintado', '/imagen/kia.PNG'),
('PHD02', 'Tacoma', 'Toyota', 2014, '2.0', 400000, 'TOY1', 'Vehiculo en buen estado, mecanicamente en perfectas condiciones.', '/imagen/toyota.PNG');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`Placa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
