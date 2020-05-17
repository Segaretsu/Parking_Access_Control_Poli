-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2020 a las 01:30:40
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parking_access`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE `registros` (
  `idRegistro` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `FechaEntrada` date NOT NULL,
  `FechaSalida` date NOT NULL,
  `idEstado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas`
--

CREATE TABLE `tarjetas` (
  `idTarjeta` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `numeroTarjeta` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_colores`
--

CREATE TABLE `tipo_colores` (
  `idColor` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documentos`
--

CREATE TABLE `tipo_documentos` (
  `idTipoDocumento` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_documentos`
--

INSERT INTO `tipo_documentos` (`idTipoDocumento`, `descripcion`) VALUES
(1, 'Cédula de Ciudadanía');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_estados`
--

CREATE TABLE `tipo_estados` (
  `idEstado` int(11) NOT NULL,
  `descripcion` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_marcas`
--

CREATE TABLE `tipo_marcas` (
  `idMarca` int(11) NOT NULL,
  `descripcion` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_perfiles`
--

CREATE TABLE `tipo_perfiles` (
  `idTipoPerfil` int(11) NOT NULL,
  `descripcion` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_perfiles`
--

INSERT INTO `tipo_perfiles` (`idTipoPerfil`, `descripcion`) VALUES
(1, 'Profesor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculos`
--

CREATE TABLE `tipo_vehiculos` (
  `idTipoVehiculo` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `nombreicono` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `numeroDocumento` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `correo` varchar(70) NOT NULL,
  `idTipoPerfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `idTipoDocumento`, `numeroDocumento`, `nombre`, `apellidos`, `telefono`, `correo`, `idTipoPerfil`) VALUES
(12, 1, '123456', 'Armando Esteban2', 'Quito', '112233', 'prueba@prueba.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `idvehiculo` int(11) NOT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `idtarjeta` int(11) DEFAULT NULL,
  `idtipovehiculo` int(11) DEFAULT NULL,
  `placa` varchar(70) DEFAULT NULL,
  `modelo` varchar(70) DEFAULT NULL,
  `numeropuertas` varchar(70) DEFAULT NULL,
  `numerochasis` varchar(70) DEFAULT NULL,
  `idMarca` int(11) NOT NULL,
  `idColor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`idRegistro`),
  ADD KEY `testado` (`idEstado`),
  ADD KEY `tvehiculo` (`idVehiculo`);

--
-- Indices de la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD PRIMARY KEY (`idTarjeta`),
  ADD KEY `estado` (`idEstado`);

--
-- Indices de la tabla `tipo_colores`
--
ALTER TABLE `tipo_colores`
  ADD PRIMARY KEY (`idColor`);

--
-- Indices de la tabla `tipo_documentos`
--
ALTER TABLE `tipo_documentos`
  ADD PRIMARY KEY (`idTipoDocumento`);

--
-- Indices de la tabla `tipo_estados`
--
ALTER TABLE `tipo_estados`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `tipo_marcas`
--
ALTER TABLE `tipo_marcas`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indices de la tabla `tipo_perfiles`
--
ALTER TABLE `tipo_perfiles`
  ADD PRIMARY KEY (`idTipoPerfil`);

--
-- Indices de la tabla `tipo_vehiculos`
--
ALTER TABLE `tipo_vehiculos`
  ADD PRIMARY KEY (`idTipoVehiculo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `documento` (`idTipoDocumento`),
  ADD KEY `perfil` (`idTipoPerfil`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`idvehiculo`),
  ADD KEY `usuario` (`idusuario`),
  ADD KEY `tarjeta` (`idtarjeta`),
  ADD KEY `marca` (`idMarca`),
  ADD KEY `color` (`idColor`),
  ADD KEY `vehiculo` (`idtipovehiculo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registros`
--
ALTER TABLE `registros`
  MODIFY `idRegistro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  MODIFY `idTarjeta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_colores`
--
ALTER TABLE `tipo_colores`
  MODIFY `idColor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_documentos`
--
ALTER TABLE `tipo_documentos`
  MODIFY `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_estados`
--
ALTER TABLE `tipo_estados`
  MODIFY `idEstado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_marcas`
--
ALTER TABLE `tipo_marcas`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_perfiles`
--
ALTER TABLE `tipo_perfiles`
  MODIFY `idTipoPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_vehiculos`
--
ALTER TABLE `tipo_vehiculos`
  MODIFY `idTipoVehiculo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `idvehiculo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `registros`
--
ALTER TABLE `registros`
  ADD CONSTRAINT `testado` FOREIGN KEY (`idEstado`) REFERENCES `tipo_estados` (`idEstado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tvehiculo` FOREIGN KEY (`idVehiculo`) REFERENCES `vehiculos` (`idvehiculo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD CONSTRAINT `estado` FOREIGN KEY (`idEstado`) REFERENCES `tipo_estados` (`idEstado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `documento` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipo_documentos` (`idTipoDocumento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `perfil` FOREIGN KEY (`idTipoPerfil`) REFERENCES `tipo_perfiles` (`idTipoPerfil`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `color` FOREIGN KEY (`idColor`) REFERENCES `tipo_colores` (`idColor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `marca` FOREIGN KEY (`idMarca`) REFERENCES `tipo_marcas` (`idMarca`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tarjeta` FOREIGN KEY (`idtarjeta`) REFERENCES `tarjetas` (`idTarjeta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculo` FOREIGN KEY (`idtipovehiculo`) REFERENCES `tipo_vehiculos` (`idTipoVehiculo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
