-- SELECT DATABASE
USE `untitled_rrss`;

-- USER TABLE
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `birthdate` DATE,
  `password` VARCHAR(50),
  `user_type` VARCHAR(50),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- PRODUCT TABLE
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
    `id` INT AUTO_INCREMENT,
    `product_name` VARCHAR(100) NOT NULL,
    `category` VARCHAR(50) NOT NULL,
    `rating` DECIMAL(2, 1),
    `seller` VARCHAR(100) NOT NULL,
    `price` DECIMAL(10, 2),
    `image_url` TEXT,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- REVIEW TABLE
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `merchant_id` INT NOT NULL,
  `reviewer_name` VARCHAR(50) NOT NULL,
  `reviewer_surname` VARCHAR(50) NOT NULL,
  `review` TEXT,
  `rating` FLOAT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- QUESTION TABLE
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question` TEXT NOT NULL,
  `product_id` VARCHAR(50) NOT NULL,
  `merchant_id` VARCHAR(15) NOT NULL,
  `user_name` VARCHAR(100) NOT NULL,
  `user_lastname` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- ANSWER TABLE
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question_id` VARCHAR(50) NOT NULL,
  `answer` TEXT NOT NULL,
  `product_id` VARCHAR(50) NOT NULL,
  `merchant_id` VARCHAR(15) NOT NULL,
  `merchant_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Populate user table
INSERT INTO `user` (`first_name`, `last_name`, `phone_number`, `email`, `birthdate`, `password`, `user_type`) VALUES
('John', 'Doe', '123-456-7890', 'john.doe@example.com', '1985-01-15', 'password', 'USER'),
('Jane', 'Smith', '234-567-8901', 'jane.smith@example.com', '1990-02-20', 'password123', 'MERCHANT'),
('Alice', 'Johnson', '345-678-9012', 'alice.johnson@example.com', '1975-03-25', 'password123', 'USER'),
('Bob', 'Williams', '456-789-0123', 'bob.williams@example.com', '1980-04-30', 'password123', 'USER'),
('Carol', 'Brown', '567-890-1234', 'carol.brown@example.com', '1995-05-10', 'password123', 'ADMIN');

-- Populate product table
INSERT INTO `product` (`product_name`, `category`, `rating`, `seller`, `price`, `image_url`) VALUES
('Smartphone XYZ', 'Electronics', 4.5, 'Tech Store', 299.99, 'https://i.ebayimg.com/images/g/aCEAAOSw5S5kBYOD/s-l1600.jpg'),
('Laptop ABC', 'Electronics', 4.0, 'Gadgets Hub', 799.99, 'https://cdn.mos.cms.futurecdn.net/emwNZPM6MmEcwL9FwYHBMT.jpg'),
('Coffee Maker', 'Home Appliances', 4.2, 'Home Essentials', 49.99, 'https://cdn.shopify.com/s/files/1/0409/4666/3577/t/19/assets/machine-lifestyle-6.jpg?v=12388335021102514241599518425'),
('Bluetooth Headphones', 'Accessories', 3.8, 'Audio World', 99.99, 'https://cdn.vox-cdn.com/thumbor/y-nKReoGpy6IYe1frZoq5SABQmo=/0x0:2040x1360/2040x1360/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/24043027/DSCF9466.jpg'),
('Running Shoes', 'Sports', 4.3, 'Sporty', 69.99, 'https://ir.ozone.ru/s3/multimedia-i/c750/6384466050.jpg');

-- Populate review table
INSERT INTO `review` (`product_id`, `merchant_id`, `reviewer_name`, `reviewer_surname`, `review`, `rating`) VALUES
(1, 1, 'John', 'Doe', 'Great phone, really satisfied!', 4.5),
(2, 2, 'Jane', 'Smith', 'Good laptop but a bit expensive.', 4.0),
(3, 3, 'Alice', 'Johnson', 'Makes excellent coffee!', 4.2),
(4, 4, 'Bob', 'Williams', 'Average sound quality.', 3.8),
(5, 5, 'Carol', 'Brown', 'Very comfortable for running.', 4.3);

-- Populate question table
INSERT INTO `question` (`question`, `product_id`, `merchant_id`, `user_name`, `user_lastname`) VALUES
('Does this smartphone support 5G?', 1, 1, 'John', 'Doe'),
('Is the laptop battery removable?', 2, 2, 'Jane', 'Smith'),
('What is the warranty period for this coffee maker?', 3, 3, 'Alice', 'Johnson'),
('Do these headphones come with a carrying case?', 4, 4, 'Bob', 'Williams'),
('Are these shoes suitable for trail running?', 5, 5, 'Carol', 'Brown');

-- Populate answer table
INSERT INTO `answer` (`question_id`, `answer`, `product_id`, `merchant_id`, `merchant_name`) VALUES
('1', 'Yes, this smartphone supports 5G connectivity.', '1', '1', 'Tech Store'),
('2', 'No, the laptop battery is not removable.', '2', '2', 'Gadgets Hub'),
('3', 'The coffee maker comes with a 2-year warranty.', '3', '3', 'Home Essentials'),
('4', 'Yes, these headphones come with a carrying case.', '4', '4', 'Audio World'),
('5', 'Yes, these shoes are suitable for trail running.', '5', '5', 'Sporty');

