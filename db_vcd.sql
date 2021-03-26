-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 24, 2021 at 11:50 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_vcd`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_uservcd`
--

DROP TABLE IF EXISTS `tb_detail_uservcd`;
CREATE TABLE IF NOT EXISTS `tb_detail_uservcd` (
  `id` varchar(4) NOT NULL,
  `nama_user` varchar(25) CHARACTER SET latin1 NOT NULL,
  `judul` varchar(25) CHARACTER SET latin1 NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_detail_uservcd`
--

INSERT INTO `tb_detail_uservcd` (`id`, `nama_user`, `judul`, `tanggal`) VALUES
('1', 'Kelvin', 'Jenazah dikala malam', '2020-10-05'),
('10', 'Kelvin', 'Seberang Jalan Warung Aya', '2020-10-05'),
('11', 'aa', 'Malam pertama', '2020-10-05'),
('12', 'aa', 'Jenazah dikala malam', '2020-10-05'),
('13', 'aa', 'Seberang Jalan Warung Aya', '2020-10-05'),
('14', 'aa', 'Malam pertama', '2020-10-05'),
('15', 'Kelvin', 'Malam pertama', '2020-10-06'),
('16', 'Kelvin', 'Proyektor Masa Depan', '2020-10-06'),
('17', 'Kelvin', 'Jenazah dikala malam', '2020-10-06'),
('18', 'Kelvin', 'Jenazah dikala malam', '2021-02-24'),
('19', 'Kelvin', 'Seberang Jalan Warung Aya', '2021-02-24'),
('2', 'Kelvin', 'Seberang Jalan Warung Aya', '2020-10-05'),
('3', 'Kelvin', 'Muah 2', '2020-10-05'),
('4', 'Kelvin', 'Muah 4', '2020-10-05'),
('5', 'Kelvin', 'Seberang Jalan Warung Aya', '2020-10-05'),
('6', 'Kelvin', 'Muah 4', '2020-10-05'),
('7', 'user1', 'Jenazah dikala malam', '2020-10-05'),
('8', 'user1', 'Muah 2', '2020-10-05'),
('9', 'user1', 'Proyektor Masa Depan', '2020-10-05');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

DROP TABLE IF EXISTS `tb_pegawai`;
CREATE TABLE IF NOT EXISTS `tb_pegawai` (
  `pegawai` varchar(15) NOT NULL,
  `pas` varchar(10) NOT NULL,
  PRIMARY KEY (`pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`pegawai`, `pas`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE IF NOT EXISTS `tb_user` (
  `user` varchar(15) NOT NULL,
  `pass` varchar(10) NOT NULL,
  `no_handphone` varchar(13) NOT NULL,
  `email` varchar(35) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`user`, `pass`, `no_handphone`, `email`) VALUES
('aa', 'aa', '123123123', 'asdf@gmail.com'),
('Kelvin', '1234', '', ''),
('SimKan', 'black', '', ''),
('user1', '12345', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_vcd`
--

DROP TABLE IF EXISTS `tb_vcd`;
CREATE TABLE IF NOT EXISTS `tb_vcd` (
  `no_vcd` varchar(20) NOT NULL,
  `judul` varchar(25) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `nama_pencipta` varchar(25) NOT NULL,
  `nama_penerbit` varchar(25) NOT NULL,
  `tahun_rilis` varchar(4) NOT NULL,
  `sinopsis` text NOT NULL,
  PRIMARY KEY (`no_vcd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_vcd`
--

INSERT INTO `tb_vcd` (`no_vcd`, `judul`, `kategori`, `nama_pencipta`, `nama_penerbit`, `tahun_rilis`, `sinopsis`) VALUES
('00000000000000000002', 'Muah 2', 'Fiksi', 'Anda Hebat', 'Anda Production', '2005', ''),
('00000000000000000003', 'Seberang Jalan Warung Aya', 'Non-Fiksi', 'Hebata Nda', 'Bathe Product', '2003', ''),
('00000000000000000004', 'Proyektor Masa Depan', 'Ilmiah', 'Pantu Tunpa', 'Pannap Write', '2009', ''),
('00000000000000000009', 'Jenazah dikala malam', 'Sci-fi', 'Fauzi', 'Zipeco', '2020', 'Fuzui-kun yang sedang berkelana di tengah malam yang gelap dan sunyi, dia bertemu seseorang wanita yang totemo kawaii. selesai.'),
('00000000000000000012', 'Muah 4', 'Fiksi', 'Anda Hebat', 'Anda Production', '2013', ''),
('000000000123', 'Malam pertama', 'SF', 'Zuizui', 'Zipeco', '2020', 'Oh indahnya'),
('0000000012345', 'Oh', 'Unknown', 'Zuizui', 'Zipeco', '2020', 'Dummy buku yang berisi ke waw an si penulis			');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
