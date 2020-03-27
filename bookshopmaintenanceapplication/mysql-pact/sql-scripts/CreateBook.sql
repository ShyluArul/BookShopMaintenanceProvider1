CREATE TABLE bookdetails (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  book_name varchar(255) DEFAULT NULL,
  book_price double NOT NULL,
  publishing_year int(11) NOT NULL,
  publisher_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;