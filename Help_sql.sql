CREATE SCHEMA webapp;
set search_path to webapp;
-- \dt;
CREATE TABLE products(id bigserial, title varchar(255), price int);
INSERT INTO products(title,price) VALUES('milk',80),('cheese',320),('coca-cola',90);

