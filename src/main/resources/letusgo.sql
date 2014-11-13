CREATE DATABASE IF NOT EXISTS letusgo DEFAULT CHARACTER SET utf8;
USE letusgo;

DROP TABLE IF EXISTS categories;

CREATE TABLE categories(
  id int auto_increment primary key,
  name varchar(20)
);

DROP TABLE IF EXISTS items;

CREATE TABLE items(
  id int auto_increment primary key,
  barcode varchar(14),
  name varchar(20),
  unit varchar(8),
  price double,
  category int,
  FOREIGN KEY(category) REFERENCES categories(id)
);

DROP TABLE IF EXISTS promotions;

CREATE TABLE promotions(
  id int auto_increment primary key,
  prodesc varchar(50),
  type int
);

DROP TABLE IF EXISTS items_promotions;

CREATE TABLE items_promotions(
  itemId int not null,
  FOREIGN KEY(itemId)REFERENCES items(id),
  promotionId int not null,
  FOREIGN KEY(promotionId) REFERENCES promotions(id),
  discount int,
  primary key(itemId, promotionId)
);

insert into categories values (null,'饮料');
insert into categories values (null,'水果');
insert into categories values (null,'食品');
insert into categories values (null,'生活用品');

insert into items values(null,'ITEM000000','可口可乐','瓶',3.0,1);
insert into items values(null,'ITEM000001','雪碧','瓶',3.0,1);
insert into items values(null,'ITEM000002','苹果','千克',8.0,2);
insert into items values(null,'ITEM000003','荔枝','千克',12.0,2);
insert into items values(null,'ITEM000004','方便面','袋',2.5,3);
insert into items values(null,'ITEM000005','电池','节',2.0,4);

insert into promotions values(null,'buy_two_get_one_free_promotion',1);
insert into promotions values(null,'second_half_price_promotion',2);
insert into promotions values(null,'discount_promotion',3);

insert into items_promotions values(2,1,100);
insert into items_promotions values(2,2,100);
insert into items_promotions values(2,3,75);
insert into items_promotions values(4,1,100);
insert into items_promotions values(4,2,100);
insert into items_promotions values(4,3,85);
insert into items_promotions values(6,1,100);
insert into items_promotions values(6,2,100);
insert into items_promotions values(6,3,90);
