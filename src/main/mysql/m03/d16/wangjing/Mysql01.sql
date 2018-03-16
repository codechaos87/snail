CREATE DATABASE myschool;
SHOW DATABASES;
USE myschool;
DROP DATABASE myschool;
CREATE TABLE student1
(
	sid INT PRIMARY KEY AUTO_INCREMENT ,#主键 自动增长
	sname VARCHAR(200)
)	
#添加
INSERT INTO student1(sname) VALUES('鲁直伸');
INSERT INTO student1(sname) VALUES('宋中鸡');
INSERT INTO student1(sname) VALUES('棒子');
SELECT * FROM student1;
DELETE FROM student1;

DROP DATABASE myschool;

CREATE DATABASE Library;
#图书信息表
CREATE TABLE book(

bid CHAR(10) NOT NULL COMMENT '图书编号' PRIMARY KEY ,
bName VARCHAR(200) NOT NULL COMMENT '图书书名',
author VARCHAR(200) COMMENT '作者姓名',
pubComp VARCHAR(200) COMMENT '出版社',
pubDate DATE COMMENT '出版日期',
bCount INT COMMENT '现存数量',
price FLOAT COMMENT '单价'
)
SELECT *FROM book;
INSERT INTO book(bid,bName,author,pubComp,pubDate,bCount,price) VALUES('001','你是人间的四月天','林徽因','中国人民出版社','1999-9-9','99','35.00');
INSERT INTO book(bid,bName,author,pubComp,pubDate,bCount,price) VALUES('002','你是人间的四月天','林徽因','中国人民出版社','1999-9-9','99','35.00');
INSERT INTO book(bid,bName,author,pubComp,pubDate,bCount,price) VALUES('003','你是人间的四月天','林徽因','中国人民出版社','1999-9-9','99','35.00');

DELETE FROM book;

#改名
SELECT 
bid AS 图书编号,
bName AS 图书书名,
author AS 作者姓名,
pubComp AS 出版社,
pubDate AS 出版日期,
bCount AS 现存数量,
price AS 单价
FROM book;


SELECT *FROM book;
 

#删除字段
ALTER TABLE book DROP price;
#添加字段
ALTER TABLE book ADD price FLOAT;
#修改字段
ALTER TABLE book CHANGE price bPrice DOUBLE;


#读者信息表
CREATE TABLE reader(
rid CHAR(10) NOT NULL COMMENT '读者编号' PRIMARY KEY,
rName CHAR(10) NOT NULL COMMENT'读者姓名' ,
lendNum INT COMMENT '已借书数量',
rAddress VARCHAR(200) COMMENT '联系地址'
)



#图书借阅表
CREATE TABLE borrow(
rid CHAR(10) NOT NULL COMMENT '读者编号',
nif CHAR(10) NOT NULL COMMENT '图书编号',
lenDate DATE NOT NULL COMMENT '借阅日期',
willDate DATE COMMENT '应归还日期',
returnDate DATE COMMENT '实际归还日期',
PRIMARY KEY(rid,nif,lendate)
)
DROP TABLE borrow;

#罚款记录表
CREATE TABLE penalty(
rid CHAR(10) NOT NULL COMMENT '读者编号',
bid CHAR(10) NOT NULL COMMENT '图书编号',
pDate DATE NOT NULL COMMENT '罚款日期',
pType INT COMMENT '罚款类型',
amount FLOAT COMMENT '罚款金额',
PRIMARY KEY (rid,bid,pdate)
)

CREATE DATABASE myschool;

CREATE TABLE student(
studentNo VARCHAR(20),
studentName CHAR(10),
phone VARCHAR(20),
address VARCHAR(20)
)

SELECT *FROM student;

INSERT INTO student(studentNo,studentName,phone,address) VALUE('10000','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10001','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10002','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10003','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10004','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10005','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10006','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10007','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10008','郭靖','134567898','天津市河西区');
INSERT INTO student(studentNo,studentName,phone,address) VALUE('10019','郭靖','134567898','天津市河西区');

DELETE FROM student;

SELECT studentNo,studentName,phone,address
FROM student
WHERE studentName='郭靖'
ORDER BY studentNo
LIMIT 3;

SELECT studentNo,studentName,phone,address
FROM student
WHERE studentName='郭靖'
ORDER BY studentNo
LIMIT 3,3;

SELECT studentNo,studentName,phone,address
FROM student
WHERE studentName='郭靖'
ORDER BY studentNo
LIMIT 6,3;

SELECT studentNo,studentName,phone,address
FROM student
WHERE studentName='郭靖'
ORDER BY studentNo
LIMIT 9,1;
`library``library`