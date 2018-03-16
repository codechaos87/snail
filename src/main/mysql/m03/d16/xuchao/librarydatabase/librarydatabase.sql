#创建图书馆数据库
CREATE DATABASE Library;
#创建图书信息表表单
CREATE TABLE book(
	bid VARCHAR(20) PRIMARY KEY NOT NULL COMMENT '图书编号',
	bName VARCHAR(50) NOT NULL COMMENT '图书书名',
	author VARCHAR(20) COMMENT '作者姓名',
	pubComp VARCHAR(50) COMMENT '出版社',
	pubDate DATE COMMENT '出版日期',
	bCount INT(20) COMMENT '现存数量',
	price DECIMAL(5,2) COMMENT '单价'
)COMMENT='图书信息表';

SELECT * FROM book;
DROP TABLE book;
SHOW TABLES;

#创建读者信息表表单
CREATE TABLE reader(
	rid VARCHAR(10) NOT NULL COMMENT '读者编号' PRIMARY KEY,
	rName VARCHAR(20) NOT NULL COMMENT '读者姓名',
	lendNum INT(20) COMMENT '已借书数量',
	rAddress VARCHAR(50) COMMENT '联系地址'
)COMMENT='读者信息表';

#创建图书借阅表表单
CREATE TABLE borrow(
	rid VARCHAR(10) NOT NULL COMMENT '读者编号',
	nif VARCHAR(20) NOT NULL COMMENT '图书编号',
	lendDate TIMESTAMP NOT NULL COMMENT '借阅日期',
	willDate DATE COMMENT '应归还日期',
	returnDate DATE COMMENT '实际归还日期',
	PRIMARY KEY(rid,nif,lendDate)
)COMMENT='图书借阅表';

DROP TABLE borrow;

#创建罚款记录表表单
CREATE TABLE penalty(
	rid VARCHAR(10) NOT NULL COMMENT '读者编号',
	bid VARCHAR(20) NOT NULL COMMENT '图书编号',
	pDate DATE NOT NULL COMMENT '罚款日期',
	pType INT(1) COMMENT '罚款类型',
	amount DECIMAL(5,2) COMMENT '罚款金额',
	PRIMARY KEY(rid,bid,pDate)
)COMMENT='罚款记录表';

SHOW TABLES;
DESC borrow;
DROP TABLE penalty;
ALTER TABLE borrow CHANGE lendDate lendDate DATE NOT NULL DEFAULT 'NOW()';

