-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2023 a las 16:25:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

drop database if exists budgeting;
create database budgeting character set utf8 collate utf8_general_ci;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
use budgeting;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `budgeting`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acciones`
--

CREATE TABLE `acciones` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
insert into acciones values 
(1, "VIVIENDA"),
(2, "ALIMENTOS_Y_BEBIDAS"),
(3, "COMPRAS"),
(4, "TRANSPORTE"),
(5, "ENTRETENIMIENTO_Y_VIDA_SOCIAL"),
(6, "COMUNICACIÓN"),
(7, "GASTOS_FINANCIEROS"),
(8, "SALARIO"),
(9, "SUELDO"),
(10, "COMISIÓN"),
(11, "INTERESES"),
(12, "DIVIDENDOS"),
( 13, "VENTA"),
( 14, "INGRESOS_POR_ALQUILER"),
(15, "REGALOS"),
(16, "CUOTAS"),
( 17, "SUBVENCIONES"),
(18, "PRÉSTAMOS"),
(19, "ALQUILER"),
( 20, "JUEGOS_DE_AZAR"),
(21, "DINERO_DE_BOLSILLO"),
( 22, "ASIGNACIÓN"),
( 23, "APOYO_GOBERNAMENTAL"),
( 24, "REEMBOLSOS"),
(25, "REGALÍAS"),
( 26, "AHORROS"),
( 27, "OTROS");
--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `id` int(11) NOT NULL,
  `idaccion` int(11) NOT NULL,
  `nombre` char(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `id` int(11) NOT NULL,
  nombreCuenta varchar(50) not null,
  pais varchar(50) not null,
  `idUsuario` int(11) NOT NULL,
  `tipoCuenta` int(11) NOT NULL,
  `dinero` decimal(10,2) NOT NULL,
  `idmoneda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`id`, nombreCuenta, pais, `idUsuario`, `tipoCuenta`, `dinero`, `idmoneda`) VALUES
(3, 'Cuenta1', 'Estados Unidos' , 1, 1, 222.00, 2),
(4, 'Cuenta2' , 'Alemania', 1, 2, 1000.00, 1),
(5, 'Cuenta3' , 'España' , 1, 3, 50.00, 1),
(6, 'Cuenta4' ,'Luxemburgo' , 12, 1, 0.00, 1),
(7, 'Cuenta5' ,'Italia' , 13, 1, 0.00, 1),
(8, 'Cuenta6', 'España', 14, 1, 0.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL,
  `idaccion` int(11) NOT NULL,
  `idcuenta` int(11) NOT NULL,
  `dinero` decimal(10,2) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------


--
-- Estructura de tabla para la tabla `tipocuenta`
--

CREATE TABLE `tipocuenta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipocuenta`
--

INSERT INTO `tipocuenta` (`id`, `nombre`) VALUES
(1, 'Corriente'),
(2, 'Ahorro'),
(3, 'Facturas'),
(4, 'Prestamo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomoneda`
--

CREATE TABLE `tipomoneda` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipomoneda`
--

INSERT INTO `tipomoneda` (`id`, `nombre`) VALUES
(1, 'EUR'),
(2, 'USD'),
(3, 'COP'),
(4, 'CHF'),
(5, 'CNY');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contrasena` char(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellidos` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `correo`, `contrasena`, `nombre`, `apellidos`) VALUES
(1, 'prueba@gmail.com', 'prueba', 'prueba', 'prueba1'),
(2, 'debustos.dbp@gm.com', '934d.54A,.-´ç+', '', ''),
(4, 'debustos.d@gmail.co', '940d.54A1,.-´ç`+', '', ''),
(5, 'debeadsfs@gm.co', '940d.54A,.-´ç`+', '', ''),
(6, 'preuba2323@gm.co', '2323Aa,.-´ç+', '', ''),
(7, 'dfe@asdf.co', '1234Aa,.-´ç+', 'nombre', 'apellido'),
(8, 'debustos.dbp@sdaf.coo', '233A123a,.-´ç+', 'prueba1', 'p'),
(9, 'debu.daf@gcr.co', '12234Aa,.-´ç+', 'prueba3', 'adf'),
(10, 'prueba@gm.co', 'Prueba1.', 'p', 'p'),
(11, 'prueba2@prueba2.com', 'Prueba7.', 'asdf', 'asdf'),
(12, 'busi@busi.busi', 'Busi012.', 'prueba', 'pr'),
(13, 'asdf@fasdf.co', 'Prueba1.@', 'adsf', 'asdf'),
(14, 'prueba@prue.co', 'David2002.', 'david', 'de bustos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acciones`
--
ALTER TABLE `acciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idaccion` (`idaccion`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`id`,`idUsuario`),
  ADD KEY `idmoneda` (`idmoneda`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `tipoCuenta` (`tipoCuenta`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idaccion` (`idaccion`),
  ADD KEY `idcuenta` (`idcuenta`);
#  ADD KEY `idactividad` (`idactividad`);

--
-- Indices de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipomoneda`
--
ALTER TABLE `tipomoneda`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acciones`
--
ALTER TABLE `acciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipomoneda`
--
ALTER TABLE `tipomoneda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`idaccion`) REFERENCES `acciones` (`id`);

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`idmoneda`) REFERENCES `tipomoneda` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cuentas_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cuentas_ibfk_3` FOREIGN KEY (`tipoCuenta`) REFERENCES `tipocuenta` (`id`);

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`idcuenta`) REFERENCES `cuentas` (`id`),
  ADD CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`idaccion`) REFERENCES `acciones` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (1, 3, 100.00, '2023-12-09');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (2, 3, 20.00, '2023-12-10');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (1, 4, 50.00, '2023-12-11');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (3, 5, 30.00, '2023-12-12');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (4, 5, 80.00, '2023-12-13');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (1, 3, 150.00, '2023-12-14');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (2, 4, 200.00, '2023-12-15');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (3, 4, 30.00, '2023-12-16');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (4, 5, 50.00, '2023-12-17');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (1, 5, 120.00, '2023-12-18');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (1, 3, 300.00, '2023-12-19');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (2, 3, -50.00, '2023-12-20');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (4, 4, 150.00, '2023-12-21');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (3, 5, -80.00, '2023-12-22');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`)
VALUES (2, 5, -30.00, '2023-12-23');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 3, 200.00, '2012-05-15');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 3, -40.00, '2013-02-20');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 4, 120.00, '2014-08-10');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 4, -60.00, '2016-11-25');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 4, -25.00, '2018-04-03');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 4, 300.00, '2019-09-12');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 4, -75.00, '2020-02-28');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 4, 50.00, '2021-05-07');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 5, 180.00, '2022-08-15');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 5, -90.00, '2023-01-22');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 5, 200.00, '2023-06-30');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 5, 120.00, '2003-07-18');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 5, -30.00, '2004-02-25');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 5, 80.00, '2005-10-14');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 5, -50.00, '2007-03-21');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 5, -15.00, '2009-01-05');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 3, 240.00, '2010-04-30');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 3, -60.00, '2011-09-09');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 3, 40.00, '2012-12-16');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 3, 150.00, '2014-06-03');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 3, -75.00, '2016-02-17');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 3, 160.00, '2017-08-24');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 3, 110.00, '2018-11-11');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 3, -45.00, '2019-05-29');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 4, 90.00, '2020-10-06');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 5, 200.00, '2021-12-23');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (2, 5, -80.00, '2004-03-03');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 4, -20.00, '2005-09-19');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (4, 4, 130.00, '2007-11-27');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (1, 4, 75.00, '2009-07-14');
INSERT INTO `movimientos` (`idaccion`, `idcuenta`, `dinero`, `fecha`) VALUES (3, 5, -35.00, '2011-01-30');

SELECT 
    usuarios.nombre, 
    usuarios.apellidos,
    usuarios.correo,
    cuentas.id AS idCuenta, 
    cuentas.nombreCuenta as NombreCuenta,
    cuentas.tipoCuenta, 
    tipomoneda.nombre as divisa,
    tipocuenta.nombre as TipoCuenta,
    cuentas.dinero AS saldoCuenta,
    movimientos.id AS idMovimiento, 
    movimientos.dinero AS montoMovimiento,
    acciones.id AS idAccion,
    acciones.nombre AS nombreAccion,
    movimientos.fecha
    
FROM usuarios
JOIN cuentas ON usuarios.id = cuentas.idUsuario
JOIN tipocuenta on tipocuenta.id = cuentas.tipoCuenta
JOIN movimientos ON cuentas.id = movimientos.idcuenta
JOIN acciones ON movimientos.idaccion = acciones.id
join tipomoneda on cuentas.idmoneda = tipomoneda.id
WHERE usuarios.id = 1
order by movimientos.fecha;



select * from usuarios where correo = 'prueba@gmail.com' and contrasena = 'prueba';

SELECT cuentas.id, cuentas.nombreCuenta, cuentas.pais ,cuentas.dinero,tipocuenta.nombre AS tipoCuenta, tipomoneda.nombre as divisa 
FROM cuentas,tipocuenta,tipomoneda 
WHERE cuentas.idUsuario=1 and tipocuenta.id = cuentas.tipoCuenta and tipomoneda.id = cuentas.idmoneda;