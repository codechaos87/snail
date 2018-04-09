
#3、查询所有到今天为止应还书但还未还书的读者姓名、所借书名、应归还日期
SELECT 
(SELECT rname FROM reader WHERE br.`rid`=rid)AS 读者姓名,
(SELECT bname FROM book WHERE br.`nif`=bid)AS 所借书的书名,
br.`willdate` AS 应归还日期
FROM borrow br WHERE 
returndate IS NULL 
AND DATE(br.`willdate`)<DATE(NOW());

#4、查询各种图书未借出的本数，显示查询书名和本数
SELECT 
(SELECT bname FROM book WHERE br.`nif`=bid) AS 书名,
(SELECT bcount FROM book WHERE br.`nif`=bid)-(SELECT lennum FROM reader 
WHERE br.rid=rid) AS 剩余本数
FROM borrow br;

#5、从已完成的借阅记录（图书归还日期不为空），统计每位读者的借书次数，显示读者姓名和借书次数
SELECT 
(SELECT rname FROM reader WHERE br.`rid`=rid) AS 读者姓名,
COUNT(br.`rid`) AS 借书次数
FROM borrow br
WHERE returndate IS NOT NULL
GROUP BY br.`rid`;

#6、查询总罚款金额大于5元的读者姓名和总罚金金额
SELECT 
(SELECT rname FROM reader WHERE p.`rid`=rid) AS 读者姓名,
SUM(p.`amount`) AS 总罚款金额
FROM penalty p 
GROUP BY p.`rid`
HAVING SUM(p.`amount`)>5;

#7、统计已完成借阅的记录（即归还日期不为空）中每本书的借阅次数、显示借阅次数排名在前5位的图书名称和借阅次数
SELECT
(SELECT bname FROM book WHERE br.`nif`=bid) 图书名称,
COUNT(br.`nif`) AS 借阅次数
FROM borrow br
WHERE returndate IS NOT NULL
GROUP BY br.`nif`
LIMIT 5;

