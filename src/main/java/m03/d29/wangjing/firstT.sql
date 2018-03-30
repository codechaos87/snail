CREATE TABLE sales
(
	empid  INT,
	proid  INT,
	num FLOAT,
	saDate  DATETIME
)
INSERT INTO sales VALUES(1234,567890,33.5,'2004-12-21');
INSERT INTO sales VALUES(1234,598701,44.8,'2004-11-21');
INSERT INTO sales VALUES(1234,598701,45.2,'2004-10-01');
INSERT INTO sales VALUES(1234,567890,66.5,'2004-9-21');
INSERT INTO sales VALUES(3456,789065,22.5,'2004-10-01');
INSERT INTO sales VALUES(3456,789065,77.5,'2004-10-27');
INSERT INTO sales VALUES(3456,678901,48.5,'2004-12-21');

SELECT * FROM sales;

DROP TABLE sales;

SELECT empid,proid,
	SUM(CASE MONTH(sadate) WHEN '9' THEN num ELSE 0 END) 九月,
	SUM(CASE MONTH(sadate) WHEN '10' THEN num ELSE 0 END) 十月,
	SUM(CASE MONTH(sadate) WHEN '11' THEN num ELSE 0 END) 十一月,
	SUM(CASE MONTH(sadate) WHEN '12' THEN num ELSE 0 END) 十二月
	FROM sales
	GROUP BY empid,proid;
	
	
	DROP TABLE abc;
	
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

SELECT * FROM ABC;


SELECT A,B,D,
	CASE C WHEN '负' THEN -B ELSE B END,
	
	FROM ABC
	GROUP BY A,D;
	