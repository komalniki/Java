-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2017 at 09:29 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbmydata1`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `cmpasgbyemp`(IN `ecod` INT)
    NO SQL
select cmpaccno,cmpdat,cmpdsc,cmpsts,(select count(*) from
tbvst where vstcmpcod=a.cmpcod) nov,(select ifnull(avg(vstfed),0) from tbvst where
vstcmpcod=a.cmpcod) fed from tbcmp a where cmpasgempcod=ecod
order by cmpdat desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cmpforcurmon`()
    NO SQL
select cmpaccno,cmpdat,cmpdsc,cmpsts,(select count(*) from
tbvst where vstcmpcod=a.cmpcod) nov,(select ifnull(avg(vstfed),0) from tbvst where
vstcmpcod=a.cmpcod) fed from tbcmp a,tbemp where cmpasgempcod=empcod
and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate())
order by cmpdat desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delacc`(IN `ano` INT)
    NO SQL
delete from tbacc where accno=ano$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delcmp`(IN `ccod` INT)
    NO SQL
delete from tbcmp where cmpcod=ccod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delemp`(IN `eno` INT)
    NO SQL
delete from tbemp where empcod=eno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delvst`(IN `vcod` INT)
    NO SQL
delete from tbvst where vstcod=vcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispcurrmonthrep`()
    NO SQL
select cmpasgempcod,cmpcod,cmpaccno,cmpdat,cmpdsc from tbcmp order by cmpasgempcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspacc`()
    NO SQL
select * from tbacc order by accnam$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspcmp`()
    NO SQL
select * from tbcmp order by cmpaccno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspemp`()
    NO SQL
select * from tbemp order by empnam$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspempbyloc`(IN `loc` VARCHAR(100))
    NO SQL
select * from tbemp where emploc=loc order by empnam$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspvst`()
    NO SQL
select * from tbvst order by vstcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `empprfformon`()
    NO SQL
select empnam,emppic,(select count(*) from tbcmp where cmpasgempcod=
a.empcod and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate()))
noc,(select count(*) from tbcmp where cmpasgempcod=
a.empcod and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate()) and cmpsts='C') nc,(select count(*) from tbcmp where cmpasgempcod=
a.empcod and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate()) and cmpsts='A') na,(select ifnull(avg(vstfed),0) from tbvst where vstcmpcod in
(select cmpcod from tbcmp where cmpasgempcod=a.empcod and month(cmpdat)
=month(curdate()) and year(cmpdat)=year(curdate()))) fed from tbemp a order by empnam$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `fndacc`(IN `ano` INT)
    NO SQL
select * from tbacc where accno=ano$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `fndcmp`(IN `ccod` INT)
    NO SQL
select * from tbcmp where cmpcod=ccod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `fndemp`(IN `eno` INT)
    NO SQL
select * from tbemp where empcod=eno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `fndvst`(IN `vcod` INT)
    NO SQL
select * from tbvst where vstcod=vcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insacc`(IN `anam` VARCHAR(100), IN `aadd` VARCHAR(100), IN `aloc` VARCHAR(100), IN `aphnno` VARCHAR(100), IN `atyp` VARCHAR(100), IN `adat` DATETIME)
    NO SQL
insert into tbacc values(null,anam,aadd,aloc,aphnno,atyp,now())$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inscmp`(IN `cano` INT, IN `cdsc` VARCHAR(1000), IN `casgecod` INT, IN `csts` VARCHAR(1), IN `cdat` DATETIME, OUT `cod` INT)
    NO SQL
begin
insert into tbcmp values (null,cano,cdsc,casgecod,csts,now(),last_insert_id());
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insemp`(IN `enam` VARCHAR(100), IN `epic` VARCHAR(100), IN `eloc` VARCHAR(100), IN `ephnno` VARCHAR(100))
    NO SQL
insert into tbemp values(null,enam,epic,eloc,ephnno)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insvst`(IN `vccod` INT, IN `vdsc` VARCHAR(1000), IN `vfed` INT, IN `vdat` DATETIME)
    NO SQL
insert into tbvst values(null,vccod,vdsc,vfed,NOW())$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `save`(OUT `b` INT)
    NO SQL
select last_insert_id into b from tbcmp$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updacc`(IN `ano` INT, IN `anam` VARCHAR(100), IN `aadd` VARCHAR(100), IN `aloc` VARCHAR(100), IN `aphnno` VARCHAR(100), IN `atyp` VARCHAR(100), IN `adat` DATETIME)
    NO SQL
update tbacc set accnam=anam,accadd=aadd,accloc=aloc,accphnno=aphnno,acctyp=atyp,accdat=adat where accno=ano$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updcmp`(IN `ccod` INT, IN `csts` VARCHAR(1))
    NO SQL
update tbcmp set cmpsts=csts where cmpcod=ccod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updemp`(IN `ecod` INT, IN `enam` VARCHAR(100), IN `epic` VARCHAR(100), IN `eloc` VARCHAR(100), IN `ephnno` VARCHAR(100))
    NO SQL
update tbemp set empnam=enam,emppic=epic,emploc=eloc,empphnno=ephnno where empcod=ecod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updvst`(IN `vcod` INT, IN `vccod` INT, IN `vdsc` VARCHAR(1000), IN `vfed` INT, IN `vdat` DATETIME)
    NO SQL
update tbvst set vstcmpcod=vccod,vstdsc=vdsc,vstfed=vfed,vstdat=vdat where vstcod=vcod$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbacc`
--

CREATE TABLE IF NOT EXISTS `tbacc` (
  `accno` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Account number',
  `accnam` varchar(100) NOT NULL COMMENT 'Account name',
  `accadd` varchar(100) NOT NULL COMMENT 'Address',
  `accloc` varchar(100) NOT NULL COMMENT 'Location',
  `accphnno` varchar(100) NOT NULL COMMENT 'Contact number',
  `acctyp` varchar(100) NOT NULL COMMENT 'Type',
  `accdat` datetime NOT NULL,
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=125 ;

--
-- Dumping data for table `tbacc`
--

INSERT INTO `tbacc` (`accno`, `accnam`, `accadd`, `accloc`, `accphnno`, `acctyp`, `accdat`) VALUES
(117, 'Rajveer Singh', '4356,sector 37', 'Mohali', '7826937287', 'Desktop Computers', '2017-03-30 08:00:00'),
(118, 'Meher Sharma', '4325,Sector 23', 'Patiala', '9573824483', 'Smart TV', '2017-09-23 07:30:00'),
(120, 'Kabir sen', '2314,sector 32', 'Chandigarh', '9867987453', 'Laptop / Notebook', '2017-04-12 04:25:36'),
(121, 'Ridhi Singhaniya', 'H.no-32A,New friends colony', 'Rajpura', '8938293829', 'Digital Camera', '2017-10-22 21:42:02'),
(122, 'Arav Singla', 'H.no-43', 'Panchkula', '8749302003', 'Mobile & Tablet', '2017-10-22 21:44:22'),
(123, 'Shanaya Oberoi', '3241,sector 21', 'Chandigarh', '9878896547', 'Smart TV', '2017-10-24 21:48:41'),
(124, 'Prashant', '2143,sector 43', 'Mohali', '8976887654', 'Mobile & Tablet', '2017-10-25 12:44:58');

-- --------------------------------------------------------

--
-- Table structure for table `tbcmp`
--

CREATE TABLE IF NOT EXISTS `tbcmp` (
  `cmpcod` int(11) NOT NULL AUTO_INCREMENT,
  `cmpaccno` int(11) NOT NULL,
  `cmpdsc` varchar(1000) NOT NULL,
  `cmpasgempcod` int(11) NOT NULL,
  `cmpsts` varchar(1) NOT NULL,
  `cmpdat` datetime NOT NULL,
  `cod` int(11) NOT NULL,
  PRIMARY KEY (`cmpcod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `tbcmp`
--

INSERT INTO `tbcmp` (`cmpcod`, `cmpaccno`, `cmpdsc`, `cmpasgempcod`, `cmpsts`, `cmpdat`, `cod`) VALUES
(9, 118, 'Tv is not working properely', 24, 'C', '2017-10-24 16:39:36', 0),
(10, 120, 'Laptop is not supporting windows', 11, 'A', '2017-10-24 16:40:49', 0),
(11, 120, 'Hardware problem', 19, 'A', '2017-10-24 20:51:35', 0),
(12, 123, 'Picture is not displaying', 11, 'A', '2017-10-24 21:49:43', 0),
(13, 122, 'Problem in mobile display', 32, 'C', '2017-10-25 12:46:41', 0),
(14, 117, 'regsd', 25, 'A', '2017-10-25 13:42:27', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbemp`
--

CREATE TABLE IF NOT EXISTS `tbemp` (
  `empcod` int(11) NOT NULL AUTO_INCREMENT,
  `empnam` varchar(100) NOT NULL,
  `emppic` varchar(100) NOT NULL,
  `emploc` varchar(100) NOT NULL,
  `empphnno` varchar(100) NOT NULL,
  PRIMARY KEY (`empcod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `tbemp`
--

INSERT INTO `tbemp` (`empcod`, `empnam`, `emppic`, `emploc`, `empphnno`) VALUES
(11, 'Maahi', 'Screenshot_20171024_191223.png', 'Chandigarh', '8947389854'),
(19, 'Meher Singh', 'Screenshot_20171024_191501.png', 'Chandigarh', '8947294839'),
(24, 'Amit Shah', 'Screenshot_20171024_191301.png', 'Patiala', '9857777438'),
(25, 'Narayan Sharma', 'Screenshot_20171024_191417.png', 'Mohali', '8749302220'),
(32, 'Neha Sharma', 'Screenshot_20171024_191049.png', 'Panchkula', '8947837585');

-- --------------------------------------------------------

--
-- Table structure for table `tbvst`
--

CREATE TABLE IF NOT EXISTS `tbvst` (
  `vstcod` int(11) NOT NULL AUTO_INCREMENT,
  `vstcmpcod` int(11) NOT NULL,
  `vstdsc` varchar(1000) NOT NULL,
  `vstfed` int(11) NOT NULL,
  `vstdat` datetime NOT NULL,
  PRIMARY KEY (`vstcod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tbvst`
--

INSERT INTO `tbvst` (`vstcod`, `vstcmpcod`, `vstdsc`, `vstfed`, `vstdat`) VALUES
(2, 5, 'Satisfied', 5, '2017-10-17 22:05:24'),
(3, 6, 'Satisfied', 5, '2017-10-17 22:07:13'),
(4, 5, 'I am satisfied', 5, '2017-10-17 21:41:49'),
(5, 9, 'Work is done efficiently', 5, '2017-10-24 16:42:21'),
(6, 9, 'Work is done efficiently', 5, '2017-10-24 16:42:23'),
(7, 13, 'Work is done according to my convinience', 4, '2017-10-25 12:48:55');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
