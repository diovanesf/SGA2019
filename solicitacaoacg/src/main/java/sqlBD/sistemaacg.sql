-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30-Set-2019 às 01:41
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistemaacg`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividade`
--

CREATE TABLE `atividade` (
  `descricao` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `documento` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `observacao` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cargaHoraria` int(255) NOT NULL,
  `detalhamento` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idAtividade` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitacao`
--

CREATE TABLE `solicitacao` (
  `solicitante` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `local` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dataCriacao` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dataAceite` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `anexo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cargaHoraria` int(255) NOT NULL,
  `idSolicitacao` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `atividade`
--
ALTER TABLE `atividade`
  ADD PRIMARY KEY (`idAtividade`);

--
-- Indexes for table `solicitacao`
--
ALTER TABLE `solicitacao`
  ADD PRIMARY KEY (`idSolicitacao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `atividade`
--
ALTER TABLE `atividade`
  MODIFY `idAtividade` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `solicitacao`
--
ALTER TABLE `solicitacao`
  MODIFY `idSolicitacao` int(255) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
