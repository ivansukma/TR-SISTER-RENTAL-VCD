-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2021 at 02:08 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sister`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_transaksi`
--

CREATE TABLE `tb_detail_transaksi` (
  `id_transaksi` varchar(10) NOT NULL,
  `user_pgw` varchar(10) NOT NULL,
  `user_plg` varchar(10) NOT NULL,
  `id_vcd` varchar(10) NOT NULL,
  `jumlah` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `user_pgw` varchar(10) NOT NULL,
  `pas_pgw` varchar(10) NOT NULL,
  `nama_pgw` varchar(20) NOT NULL,
  `nohp_pgw` varchar(13) NOT NULL,
  `alamat_pgw` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`user_pgw`, `pas_pgw`, `nama_pgw`, `nohp_pgw`, `alamat_pgw`) VALUES
('admin', 'admin', 'ADMIN1', '087830164296', 'Jl Ahmad Yani No 23 Salatiga');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `user_plg` varchar(10) NOT NULL,
  `pass_plg` varchar(10) NOT NULL,
  `jenis_langganan` enum('Reguler','VIP') NOT NULL,
  `nama_plg` varchar(20) NOT NULL,
  `noktp_plg` varchar(16) NOT NULL,
  `nohp_plg` varchar(13) NOT NULL,
  `alamat_plg` varchar(50) NOT NULL,
  `email_plg` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`user_plg`, `pass_plg`, `jenis_langganan`, `nama_plg`, `noktp_plg`, `nohp_plg`, `alamat_plg`, `email_plg`) VALUES
('Devi', '1234', 'Reguler', 'Devi Ariella susanto', '3309025804000012', '08562745123', 'Jl. Permai no. 9, Kudus', 'deviariella@gmail.com'),
('Ivan', '1234', 'Reguler', 'Ivan Sukma Hanindria', '3311092410990004', '081328915920', 'Jl. Podang BG 03 Solo Baru', 'ivanrzr12@gmail.com'),
('Leon', '1234', 'Reguler', 'Leonardo Wahyu', '331907060800001', '081327594455', 'Perum. Muria Indah C 296 Kudus', 'leonardowahyu01@gmail.com'),
('Vika', '1234', 'Reguler', 'Sera Vika Eviana', '3325084302000002', '082227798966', 'Jl Cokronegoro no 10 RT 2 RW 2 Limpung', 'seravikaeviana9@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi_peminjaman`
--

CREATE TABLE `tb_transaksi_peminjaman` (
  `id_transaksi` varchar(10) NOT NULL,
  `user_plg` varchar(10) NOT NULL,
  `id_vcd` varchar(10) NOT NULL,
  `tanggal_peminjaman` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_transaksi_peminjaman`
--

INSERT INTO `tb_transaksi_peminjaman` (`id_transaksi`, `user_plg`, `id_vcd`, `tanggal_peminjaman`, `tanggal_pengembalian`) VALUES
('T0001', 'Vika', 'VIL0000001', '2021-03-01', '2021-03-03'),
('T0002', 'Ivan', 'VIL0000001', '2021-03-02', '2021-03-03');

-- --------------------------------------------------------

--
-- Table structure for table `tb_vcd`
--

CREATE TABLE `tb_vcd` (
  `id_vcd` varchar(10) NOT NULL,
  `stock` varchar(2) NOT NULL,
  `judul` varchar(25) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `nama_pencipta` varchar(20) NOT NULL,
  `nama_penerbit` varchar(20) NOT NULL,
  `tahun_rilis` varchar(4) NOT NULL,
  `sinopsis` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_vcd`
--

INSERT INTO `tb_vcd` (`id_vcd`, `stock`, `judul`, `kategori`, `nama_pencipta`, `nama_penerbit`, `tahun_rilis`, `sinopsis`) VALUES
('V000000001', '1', 'Oh', 'Unknown', 'Zuizui', 'Zipeco', '2020', 'Dummy buku yang berisi ke waw an si penulis			'),
('VFI0000001', '1', 'Muah 1', 'Fiksi', 'Anda Hebat', 'Anda Production', '2005', ''),
('VFI0000002', '1', 'Muah 2', 'Fiksi', 'Anda Hebat', 'Anda Production', '2013', ''),
('VIL0000001', '1', 'Proyektor Masa Depan', 'Ilmiah', 'Pantu Tunpa', 'Pannap Write', '2009', ''),
('VNF0000001', '1', 'Seberang Jalan Warung Aya', 'Non-Fiksi', 'Hebata Nda', 'Bathe Product', '2003', ''),
('VSC0000001', '1', 'Jenazah dikala malam', 'Sci-fi', 'Fauzi', 'Zipeco', '2020', 'Fuzui-kun yang sedang berkelana di tengah malam yang gelap dan sunyi, dia bertemu seseorang wanita yang totemo kawaii. selesai.'),
('VSF0000001', '1', 'Malam pertama', 'SF', 'Zuizui', 'Zipeco', '2020', 'Oh indahnya');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`user_pgw`);

--
-- Indexes for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`user_plg`);

--
-- Indexes for table `tb_transaksi_peminjaman`
--
ALTER TABLE `tb_transaksi_peminjaman`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `tb_vcd`
--
ALTER TABLE `tb_vcd`
  ADD PRIMARY KEY (`id_vcd`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
