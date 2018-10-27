-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2018 at 03:34 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `exam`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stu_id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `fat_name` varchar(255) NOT NULL,
  `dob` varchar(250) NOT NULL,
  `adhar` varchar(100) NOT NULL,
  `com` varchar(255) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dep` varchar(255) NOT NULL,
  `course` varchar(100) NOT NULL,
  `ses` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `dist` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `pin` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stu_id`, `name`, `fat_name`, `dob`, `adhar`, `com`, `gender`, `dep`, `course`, `ses`, `address`, `dist`, `state`, `pin`, `phone`, `email`) VALUES
(1, 'Chandan Kumar Jaiswal', 'Anirudh prasad', '1994-02-06', '456554652344', 'OBC', 'MALE', 'Computer Science', 'Mca', '2016-19', 'Vill+po-Mathiya Lauriya , West Champaran\nBihar', 'Bettiah', 'Bihar', '845438', '9487810674', 'ckj40856@gmail.com'),
(2, 'Dhiraj  Kumar', 'Kamaldev Prasad', '1995-12-06', '466337347633', 'OBC', 'MALE', 'Computer Sciecne', 'MCA', '2016-19', 'Patna, Bihar		', 'Patna', 'Bihar', '54054', '9876545654', 'dk123@gmail.com'),
(3, 'Anil  Kumar', 'Akash  sharma', '1990-10-12', '2343212123232', 'OBC', 'MALE', 'Science', 'Maths', '2010-14', 'bihar', 'patna', 'Bihar', '607045', '98675445454', 'ak123@gmail.com'),
(4, 'Birju  Kumar Mehta', 'Ajay Mehta', '1995-11-20', '23434312323', 'OBC', 'MALE', 'Computer Science', 'Mca', '2016-19', 'kanke', 'Ranchi', 'Jharkhand', '658034', '8797435434', 'bkm123@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `stu_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
