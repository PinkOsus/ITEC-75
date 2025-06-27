-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2025 at 09:21 AM
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
-- Database: `books_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books_tbl`
--

CREATE TABLE `books_tbl` (
  `id` int(11) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `pub_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books_tbl`
--

INSERT INTO `books_tbl` (`id`, `book_name`, `author`, `genre`, `pub_date`) VALUES
(1, 'Justyn the Racer', 'Justyn Mercado', 'Romance', '2024-03-03'),
(2, 'Ian the Valiant', 'Ian Crisler Angkico', 'Comedy', '2025-08-08'),
(3, 'Kurt the Great', 'Kurt Russel Caraig', 'History', '2025-08-03'),
(6, 'Janine the Hopeless', 'Janine De Ocampo', 'Romance', '2025-06-06');

-- --------------------------------------------------------

--
-- Table structure for table `borrowers_tbl`
--

CREATE TABLE `borrowers_tbl` (
  `id` int(11) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date_borrowed` date NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowers_tbl`
--

INSERT INTO `borrowers_tbl` (`id`, `book_name`, `name`, `date_borrowed`, `status`) VALUES
(1, 'Justyn the Racer', 'Ian Crisler Angkico', '2025-06-27', 'Returned'),
(2, 'Ian the Valiant', 'Kurt Russel J Caraig', '2025-08-03', 'Borrowed'),
(4, 'Kurt the Great', 'Janine De Ocampo', '2023-08-03', 'Returned'),
(5, 'Janine the Hopeless', 'Kurt Russel Caraig', '2025-08-03', 'Borrowed');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books_tbl`
--
ALTER TABLE `books_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `borrowers_tbl`
--
ALTER TABLE `borrowers_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books_tbl`
--
ALTER TABLE `books_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `borrowers_tbl`
--
ALTER TABLE `borrowers_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
