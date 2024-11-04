CREATE DATABASE loja_online;

CREATE TABLE Product (
id INT primary key auto_increment,
image_path varchar(50),
name varchar(100) NOT NULL,
description varchar(500),
price decimal(10, 2) NOT NULL 
);
CREATE TABLE User (
id INT PRIMARY KEY auto_increment,
name varchar(50) NOT NULL,
email varchar(50) NOT NULL,
password varchar(50) NOT NULL
);

CREATE TABLE Cart (
id_cart INT PRIMARY KEY auto_increment,
id_product int NOT NULL,
id_user int NOT NULL,
constraint foreign key fk_product(id_product) REFERENCES Product(id),
constraint foreign key fk_user(id_user) REFERENCES User(id)
);