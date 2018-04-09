SELECT * FROM borrow
SELECT * FROM book
SELECT * FROM reader
SELECT * FROM borrow WHERE returndate IS NULL 

#查询到今天为止应还书但没还还书的读者姓名，所借书书名，应归还日期
SELECT rd.rname AS 读者姓名,bk.bname AS 所借书书名,bw.willdate AS 应归还日期 FROM borrow bw 
INNER JOIN reader rd ON bw.rid=rd.rid 
INNER JOIN book bk ON bk.bid=bw.nif
WHERE bw.returndate IS NULL

#查询各种书未借出的本数，书名，本数
SELECT bk.bname AS 书名, bk.`bcount` - COUNT(bw.`nif`)AS 未借出的书本数 
FROM book bk 
LEFT OUTER JOIN borrow bw ON bw.nif=bk.bid
GROUP BY bw.nif;

#从已经完成借阅的记录（即图书归还中不为空），统计每位读者的借书次数，显示读者的姓名和借书次数
SELECT rd.`rname` AS 读者姓名,COUNT(bk.`bid`) AS 借书次数 FROM borrow bw
INNER JOIN reader rd ON rd.`rid`=bw.`rid` 
INNER JOIN book bk ON bk.`bid`=bw.`nif`
WHERE bw.returndate IS  NOT NULL
GROUP BY bw.`rid`
#总罚款大于5元的读者姓名和总罚款金额
SELECT * FROM penalty
SELECT
(SELECT r.rname FROM reader r WHERE p.`rid`=rid)AS 读者姓名,
SUM(amount) AS 总罚款金额
FROM penalty p 
GROUP BY rid HAVING 总罚款金额>5;
#从已经完成借阅的记录（即图书归还中不为空），中的每本书的借阅次数，显示借阅次数排名和和前5位
SELECT bk.`bname` AS 图书名称, COUNT(bw.`nif`) AS 借阅次数 FROM borrow bw
INNER JOIN book bk ON bk.`bid`=bw.`nif`
WHERE bw.returndate IS  NOT NULL
GROUP BY bw.`nif`
ORDER BY 借阅次数 DESC LIMIT 5







 