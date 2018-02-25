create table users(
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(100) primary key,
address int
foreign key(address) references address(id));

create table address(
    id int primary key auto_increment,
    `line1` varchar(100) DEFAULT NULL,
  `line2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
)
