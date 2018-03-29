#按月统计销售表中货物的销售数量 没有的用0表示。
SELECT no1,no2,
	SUM(CASE MONTH(sadate) WHEN '9' THEN FORMAT(num,1) ELSE 0 END) AS 九月,
	SUM(CASE MONTH(sadate) WHEN '10' THEN FORMAT(num,1) ELSE 0 END) AS 十月,
	SUM(CASE MONTH(sadate) WHEN '11' THEN FORMAT(num,1) ELSE 0 END) AS 十一月,
	SUM(CASE MONTH(sadate) WHEN '12' THEN FORMAT(num,1) ELSE 0 END) AS 十二月
FROM sales GROUP BY no1,no2;

#按a、d分组 b、c不显示 如果c为负 name对应的b显示负数
SELECT a AS A,
SUM(CASE c WHEN '负' THEN 0-b ELSE b END) AS B,
d AS D
FROM abc 
GROUP BY d,a;