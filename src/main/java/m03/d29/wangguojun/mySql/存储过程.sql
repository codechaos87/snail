#建表
CREATE TABLE sales
(
	empid INT,
	proid INT,
	num   FLOAT,
	saDate DATETIME 
);
#插入数据
INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');
#查询
SELECT s.`empid`AS'NO',s.proid AS'NO2',s.num AS'数量', s.saDate AS'日期' FROM sales s;
 
#按月统计销售表中货物的销售量数
SELECT s.`empid`,s.`proid`,
	SUM(CASE MONTH(saDate) WHEN '9' THEN num ELSE 0 END) 九月,
	SUM(CASE MONTH(saDate) WHEN '10' THEN num ELSE 0 END) 十月,
	SUM(CASE MONTH(saDate) WHEN '11' THEN num ELSE 0 END) 十一月,
	SUM(CASE MONTH(saDate) WHEN '12' THEN num ELSE 0 END) 十二月
FROM sales s
GROUP BY s.`empid`,s.`proid`;
#建表
CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)
INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班');

#汇总时按字段D 和A分组,汇总字段B,C可以不显示,如果C为'负'则对应的B为负数.
SELECT a.`A` AS'A',SUM(CASE WHEN '正' THEN b ELSE -b END)AS B,a.`D`AS 'D'
FROM abc a 
GROUP BY a.`A`,a,d;
#刘冰冰
DELIMITER ;;
CREATE PROCEDURE ups_test_penalty(IN liubingbing VARCHAR(200))
BEGIN
	#添加
	INSERT INTO penalty(rid,bid,pdate,ptype,amount)
	VALUE((SELECT rid FROM reader WHERE rname=liubingbing),
	 (SELECT bid FROM book WHERE bname='西游记'), NOW(),1,4.6);
	#修改日期
	UPDATE borrow SET returndate=NOW() 
	WHERE rid =(SELECT rid FROM reader WHERE rname=liubingbing) 
	AND nif =(SELECT bid FROM book WHERE bname='西游记');
	#修改数量
	UPDATE reader SET lennum=lennum-1 WHERE rname=liubingbing;
	UPDATE book SET bcount=bcount+1 WHERE bname='西游记';
END;;
DELIMITER;

#用存储过程封装select * from 表名;
DELIMITER ;;
CREATE PROCEDURE ups_question_info()
BEGIN
	SELECT * FROM question_info;
END;;
DELIMITER;
CALL ups_question_info;
#用存储过程模糊查询
DELIMITER ;;
CREATE PROCEDURE ups_question_infomohu(IN xx VARCHAR(200))
BEGIN
	SELECT * FROM question_info WHERE question LIKE mohu;
END;;
DELIMITER;
