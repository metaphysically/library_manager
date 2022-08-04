SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeid` int(11) NOT NULL,
  `employeename` varchar(50) NOT NULL,
  `employeecontact` varchar(20) NOT NULL,
  `employeemail` varchar(50) NOT NULL,
  `booksissued` int(11) NOT NULL,
  `booksreturned` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8;

INSERT INTO `employees` (`id`,`employeeid`,`employeename`,`employeecontact`,`employeemail`,`booksissued`,`booksreturned`) VALUES
(1, '01', 'employee1', '9891979296', 'employee1@crestdatasys.com', '2','0'),
(2, '02', 'employee2', '9891979295', 'employee2@crestdatasys.com', '1','0'),
(3, '03', 'employee3', '9891979294', 'employee3@crestdatasys.com', '0','0');