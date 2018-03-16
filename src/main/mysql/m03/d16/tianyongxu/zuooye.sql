#创建图书馆数据库
 CREATE DATABASE Library;
#创建一个表
 CREATE TABLE book
(
  bid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bName VARCHAR(200) NOT NULL ,
  info VARCHAR(200)
  
)
 INSERT INTO book(bName,info) VALUES('围城','感情书籍');
 INSERT INTO book(bName,info) VALUES('平凡的世界','励志书籍');
 SELECT bid AS 编号,bName AS 书名,info AS 说明,auther AS 作者,pubComp AS 出版社,pubDate AS 出版日期,bCount AS 计数,price AS 价格 FROM book WHERE bid>=1;
 ALTER TABLE book ADD auther VARCHAR(20) NOT NULL;
 ALTER TABLE book ADD pubComp VARCHAR(20) NOT NULL;
 ALTER TABLE book ADD pubDate DATETIME  NOT NULL;
 ALTER TABLE book ADD bCount INT;
 ALTER TABLE book ADD price  FLOAT;
 UPDATE book SET auther='钱钟书',pubComp='人民出版社',pubDate='1992-01-12',bCount='2',price='24.5' WHERE bid=1;
 UPDATE book SET auther='路遥',pubComp='清华大学出版社',pubDate='2018-03-16',bCount='2',price='30' WHERE bid>1;
 SELECT * FROM book;

CREATE TABLE reader
(
 rid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 rName VARCHAR(200) NOT NULL,
 lendNum INT,
 rAddress VARCHAR(200)
)
 INSERT INTO reader(rName,lendNum,rAddress) VALUES('田永旭',1,'华中地区最大城市-武汉');
 UPDATE reader SET rName='田永旭',lendNum='1',rAddress='我家住在黄土高坡' WHERE rid=1;
 SELECT rid AS 编号, rName AS 读者名, lendNum AS 借阅数,rAddress AS 住址 FROM reader WHERE rid>=1;
 SELECT * FROM reader;
 
 CREATE TABLE borrow
 (
  rid VARCHAR(200) NOT NULL,
  nif VARCHAR(200)NOT NULL,
  lendDate DATETIME DEFAULT'2018-03-16',
  willDate DATE,
  returndate DATE,
  PRIMARY KEY(rid,nif,lendDate)  
  
   )
   #通过外部链接，通过固定语法链接起来的！！！！！
   SELECT b.rid FROM borrow b INNER JOIN reader r ON b.rid=r.rid;
   
   INSERT INTO borrow(rid,nif,lendDate,willDate,returndate) VALUES('110','110','2018-03-16','2018-03-17','2018-03-28');
   DELETE FROM borrow WHERE rid='b.rid';
   SELECT * FROM borrow;

   
 CREATE TABLE penalty
 (
  rid VARCHAR(200) NOT NULL,
  bid VARCHAR(200) NOT NULL,
  pDate DATE NOT NULL,
  pType INT(3) COMMENT'1-延期 2-损坏 3-丢失',
  amount FLOAT,
  PRIMARY KEY(rid,bid,pDate)
 )
 INSERT INTO penalty(rid,bid,pDate,pType,amount) VALUES('110','110','2018-03-05','2','32.5');
 SELECT * FROM penalty;
 
 CREATE TABLE student
 (
   sid INT PRIMARY KEY NOT NULL ,
   sname VARCHAR(200),
   phone VARCHAR(13) 
 )
 INSERT INTO student VALUES(1001,'梨花','1234567890123');
 INSERT INTO student VALUES(1002,'桃花','1234567890123');
 INSERT INTO student VALUES(1003,'杏花','1234567890123');
 INSERT INTO student VALUES(1004,'玫瑰花','1234567890123');
 INSERT INTO student VALUES(1005,'菊花','1234567890123');
 INSERT INTO student VALUES(1006,'梅花','1234567890123');
 INSERT INTO student VALUES(1007,'小花','1234567890123');
 SELECT * FROM student;
 SELECT 'sid','sname','phone' FROM student WHERE sid=1001 ORDER BY sid LIMIT 4,4;