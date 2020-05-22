CREATE SCHEMA webapp;
set search_path to webapp;
-- \dt;
CREATE TABLE products(id bigserial, title varchar(255), price int, primary key (id));
INSERT INTO products(title,price) VALUES('milk',80),('cheese',320),('coca-cola',90);

CREATE TABLE users(username varchar(50) not null primary key, password varchar(100) not null, enabled boolean not null);

CREATE TABLE authorities (username varchar(50) not null, authority varchar(50) not null);


ALTER TABLE webapp.authorities
    ADD CONSTRAINT users FOREIGN KEY (username)
    REFERENCES webapp.users (username) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;



insert into users(username,password,enabled) values('geek','{noop}brains', true);
insert into authorities(username,authority) values('geek-user','ROLE_ADMIN');
insert into users(username,password,enabled) values('geek-user','{noop}brains', true);
insert into authorities(username,authority) values('geek-user','ROLE_USER');


CREATE TABLE orders(id bigserial, username varchar(50),
                    foreign key (username) references users (username) ON UPDATE CASCADE ON DELETE CASCADE,
                    primary key (id));

CREATE TABLE order_items(id bigserial, order_id bigint, product_id bigint,
                            foreign key (order_id) references orders (id) ON UPDATE CASCADE ON DELETE CASCADE,
                            foreign key (product_id) references products (id) ON UPDATE CASCADE ON DELETE CASCADE,
                            primary key (id))