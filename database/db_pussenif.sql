-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20 Feb 2018 pada 05.09
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pussenif2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE IF NOT EXISTS `anggota` (
`anggota_id` int(11) NOT NULL,
  `nrp` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `golongan_id` int(11) NOT NULL,
  `divisi_id` int(11) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `jns_kelamin` varchar(10) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `status` varchar(10) NOT NULL,
  `tgl_aktif` date NOT NULL,
  `foto` blob NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `divisi`
--

CREATE TABLE IF NOT EXISTS `divisi` (
`divisi_id` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `subdiv_id` int(11) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `golongan`
--

CREATE TABLE IF NOT EXISTS `golongan` (
`golongan_id` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `presensi`
--

CREATE TABLE IF NOT EXISTS `presensi` (
`presensi_id` int(11) NOT NULL,
  `anggota_id` int(11) NOT NULL,
  `nrp` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `jam` time NOT NULL,
  `is_active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `subdivisi`
--

CREATE TABLE IF NOT EXISTS `subdivisi` (
`subdiv_id` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`user_id` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `level` varchar(10) NOT NULL,
  `password` varchar(15) NOT NULL,
  `is_active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
 ADD PRIMARY KEY (`anggota_id`), ADD KEY `golongan_id` (`golongan_id`), ADD KEY `divisi_id` (`divisi_id`);

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
 ADD PRIMARY KEY (`divisi_id`), ADD KEY `subdiv_id` (`subdiv_id`);

--
-- Indexes for table `golongan`
--
ALTER TABLE `golongan`
 ADD PRIMARY KEY (`golongan_id`);

--
-- Indexes for table `presensi`
--
ALTER TABLE `presensi`
 ADD PRIMARY KEY (`presensi_id`), ADD KEY `anggota_id` (`anggota_id`);

--
-- Indexes for table `subdivisi`
--
ALTER TABLE `subdivisi`
 ADD PRIMARY KEY (`subdiv_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
MODIFY `anggota_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `divisi`
--
ALTER TABLE `divisi`
MODIFY `divisi_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `golongan`
--
ALTER TABLE `golongan`
MODIFY `golongan_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `presensi`
--
ALTER TABLE `presensi`
MODIFY `presensi_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subdivisi`
--
ALTER TABLE `subdivisi`
MODIFY `subdiv_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `anggota`
--
ALTER TABLE `anggota`
ADD CONSTRAINT `anggota_ibfk_1` FOREIGN KEY (`golongan_id`) REFERENCES `golongan` (`golongan_id`),
ADD CONSTRAINT `anggota_ibfk_2` FOREIGN KEY (`divisi_id`) REFERENCES `divisi` (`divisi_id`);

--
-- Ketidakleluasaan untuk tabel `divisi`
--
ALTER TABLE `divisi`
ADD CONSTRAINT `divisi_ibfk_1` FOREIGN KEY (`subdiv_id`) REFERENCES `subdivisi` (`subdiv_id`);

--
-- Ketidakleluasaan untuk tabel `presensi`
--
ALTER TABLE `presensi`
ADD CONSTRAINT `presensi_ibfk_1` FOREIGN KEY (`anggota_id`) REFERENCES `anggota` (`anggota_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
