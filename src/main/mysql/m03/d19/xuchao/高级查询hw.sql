SELECT COUNT(*) AS 人数,sex,gradeid FROM student GROUP BY sex,gradeid
ORDER BY gradeid;

#2、查询没有借阅信息的读者编号和姓名
SELECT r.rid,r.rname FROM reader r WHERE NOT EXISTS(
	SELECT b.rid FROM borrow b WHERE b.rid=r.rid
);

#3、查询所有到今天为止应还书但还未还书的读者姓名、所借书名、应归还日期
SELECT
(SELECT rname FROM reader WHERE b.rid =rid) AS 读者姓名,
(SELECT bname FROM book WHERE b.nif = bid) AS 所借书名,
b.willdate AS 应归还日期
FROM borrow b WHERE b.returndate IS NULL;

#4、查询各种图书未借出的本数，显示查询书名和本数
SELECT
b.bname,
b.bcount-COUNT(bo.nif) AS 未借出的本数
FROM book b
LEFT OUTER JOIN borrow bo
ON b.`bid`=bo.`nif`
GROUP BY bo.`nif`
ORDER BY 未借出的本数;

#5、从已完成的借阅记录（图书归还日期不为空），统计每位读者的借书次数，显示读者姓名和借书次数
SELECT
(SELECT rname FROM reader r WHERE b.`rid`=rid)AS 读者姓名,
COUNT(b.`rid`)AS 借书次数
FROM
borrow b WHERE returndate IS NOT NULL
GROUP BY b.`rid`;

#6、查询总罚款金额大于5元的读者姓名和总罚金金额
SELECT
(SELECT r.rname FROM reader r WHERE p.`rid`=rid)AS 读者姓名,
SUM(amount) AS 总罚金金额
FROM
penalty p GROUP BY rid HAVING 总罚金金额>5;

#7、统计已完成借阅的记录（即归还日期不为空）中每本书的借阅次数、显示借阅次数排名在前5位的图书名称和借阅次数
SELECT
(SELECT bname FROM book b WHERE bo.`nif`=bid)AS 图书名称,
COUNT(nif) 借阅次数
FROM borrow bo WHERE returndate IS NOT NULL GROUP BY nif ORDER BY 借阅次数 DESC LIMIT 5;














