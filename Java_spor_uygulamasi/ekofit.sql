-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2025 at 09:53 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ekofit`
--

-- --------------------------------------------------------

--
-- Table structure for table `egzersiz_kayitlari`
--

CREATE TABLE `egzersiz_kayitlari` (
  `uye_id` int(11) NOT NULL,
  `dakika` int(11) NOT NULL,
  `kalori` int(11) NOT NULL,
  `tarih` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `egzersiz_kayitlari`
--

INSERT INTO `egzersiz_kayitlari` (`uye_id`, `dakika`, `kalori`, `tarih`) VALUES
(1, 30, 150, '2025-05-16 07:37:36'),
(2, 34, 170, '2025-05-16 07:38:34');

-- --------------------------------------------------------

--
-- Table structure for table `uyeler`
--

CREATE TABLE `uyeler` (
  `uye_id` int(11) NOT NULL,
  `isim` text NOT NULL,
  `ogrenci_no` text NOT NULL,
  `sifre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `uyeler`
--

INSERT INTO `uyeler` (`uye_id`, `isim`, `ogrenci_no`, `sifre`) VALUES
(1, 'Özlem', '2022', '123'),
(2, 'ayça', '20232425044', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `egzersiz_kayitlari`
--
ALTER TABLE `egzersiz_kayitlari`
  ADD KEY `uye_FK` (`uye_id`);

--
-- Indexes for table `uyeler`
--
ALTER TABLE `uyeler`
  ADD PRIMARY KEY (`uye_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `uyeler`
--
ALTER TABLE `uyeler`
  MODIFY `uye_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `egzersiz_kayitlari`
--
ALTER TABLE `egzersiz_kayitlari`
  ADD CONSTRAINT `uye_FK` FOREIGN KEY (`uye_id`) REFERENCES `uyeler` (`uye_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
