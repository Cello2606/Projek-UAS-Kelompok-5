-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2025 at 03:53 PM
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
-- Database: `ekspedisi`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `berat` float NOT NULL,
  `harga_barang` double NOT NULL,
  `jenis_barang` varchar(255) DEFAULT NULL,
  `nama_barang` varchar(255) DEFAULT NULL,
  `waktu_persiapan` datetime(6) DEFAULT NULL,
  `waktu_sekarang` datetime(6) DEFAULT NULL,
  `pesananid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`berat`, `harga_barang`, `jenis_barang`, `nama_barang`, `waktu_persiapan`, `waktu_sekarang`, `pesananid`) VALUES
(2, 199000, 'Elektronik', 'Handphone', '2025-11-23 14:16:20.000000', '2025-11-30 14:16:20.000000', 3);

-- --------------------------------------------------------

--
-- Table structure for table `detail_pemesanan`
--

CREATE TABLE `detail_pemesanan` (
  `pesananid` int(11) NOT NULL,
  `catatan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_pemesanan`
--

INSERT INTO `detail_pemesanan` (`pesananid`, `catatan`) VALUES
(1, 'Taruh saja di depan'),
(3, NULL),
(4, NULL),
(7, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `kuririd` varchar(255) DEFAULT NULL,
  `perusahaan_kurir` varchar(50) NOT NULL,
  `accountid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kurir`
--

INSERT INTO `kurir` (`kuririd`, `perusahaan_kurir`, `accountid`) VALUES
('KU-1', 'JNE', 1),
('KU-14567', 'J&T', 18);

-- --------------------------------------------------------

--
-- Table structure for table `orang`
--

CREATE TABLE `orang` (
  `accountid` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orang`
--

INSERT INTO `orang` (`accountid`, `nama`) VALUES
(1, 'Nama1'),
(14, 'Orang 14'),
(16, 'asdasd2323'),
(17, 'Nama2'),
(18, 'Nama2'),
(22, 'Nama3');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `no_telp` varchar(255) DEFAULT NULL,
  `accountid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`no_telp`, `accountid`) VALUES
('08818153389', 1),
('08818153353', 17),
('13123123', 22);

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman`
--

CREATE TABLE `pengiriman` (
  `alamat_tujuan` varchar(255) DEFAULT NULL,
  `jenis_kendaraan` varchar(255) DEFAULT NULL,
  `no_pemesanan` varchar(255) DEFAULT NULL,
  `waktu_sampai` datetime(6) DEFAULT NULL,
  `pesananid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengiriman`
--

INSERT INTO `pengiriman` (`alamat_tujuan`, `jenis_kendaraan`, `no_pemesanan`, `waktu_sampai`, `pesananid`) VALUES
('Jl. Asdas blok c12/123', 'Mobil', 'P-1001', '2025-11-30 13:43:37.000000', 1),
('Jalan. Asdas Blok c3/10', 'Truk', 'P-1002', '2025-12-01 22:18:51.000000', 4),
('Jalan. Asdas Blok c3/10', 'Motor', 'P-1003', '2025-12-03 10:48:36.000000', 7);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `metode_pembayaran` varchar(255) DEFAULT NULL,
  `total_ongkos` double NOT NULL,
  `pelangganid` int(11) DEFAULT NULL,
  `pengirimanid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `metode_pembayaran`, `total_ongkos`, `pelangganid`, `pengirimanid`) VALUES
(1, 'Debit', 19900, 1, 1),
(2, 'Debit', 10000, 1, 1),
(3, 'Cash', 32132, 22, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`pesananid`);

--
-- Indexes for table `detail_pemesanan`
--
ALTER TABLE `detail_pemesanan`
  ADD PRIMARY KEY (`pesananid`);

--
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`accountid`);

--
-- Indexes for table `orang`
--
ALTER TABLE `orang`
  ADD PRIMARY KEY (`accountid`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`accountid`);

--
-- Indexes for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD PRIMARY KEY (`pesananid`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `FKeg0fo1lci4sk2o9l3fvckvkck` (`pelangganid`),
  ADD KEY `FKnakjwatk3luy603btvvydhh0s` (`pengirimanid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_pemesanan`
--
ALTER TABLE `detail_pemesanan`
  MODIFY `pesananid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `orang`
--
ALTER TABLE `orang`
  MODIFY `accountid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `FKrhwtybrm523d6ylh69gjlpg6f` FOREIGN KEY (`pesananid`) REFERENCES `detail_pemesanan` (`pesananid`);

--
-- Constraints for table `kurir`
--
ALTER TABLE `kurir`
  ADD CONSTRAINT `FKteeqdf8r9malsnevq5kmn885p` FOREIGN KEY (`accountid`) REFERENCES `orang` (`accountid`);

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `FK60ldxq60rpteowrw4f51ne6a0` FOREIGN KEY (`accountid`) REFERENCES `orang` (`accountid`);

--
-- Constraints for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD CONSTRAINT `FKncqst6sjdne30bnb9iiiqcekk` FOREIGN KEY (`pesananid`) REFERENCES `detail_pemesanan` (`pesananid`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FKeg0fo1lci4sk2o9l3fvckvkck` FOREIGN KEY (`pelangganid`) REFERENCES `pelanggan` (`accountid`),
  ADD CONSTRAINT `FKnakjwatk3luy603btvvydhh0s` FOREIGN KEY (`pengirimanid`) REFERENCES `pengiriman` (`pesananid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
