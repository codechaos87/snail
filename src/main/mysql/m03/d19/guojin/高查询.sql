SELECT * FROM reader;
SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM penalty;
#查询所欲到今天为止应还数但未还数的读者姓名、所借书的书名、应归还日期
#要求：用select子查询、from子查询
SELECT (SELECT rname FROM reader WHERE a.`rid`=rid) AS 读者姓名,
(SELECT bname FROM book WHERE a.`nif`=bid) AS 图书名称,
willdate AS 应归还日期 FROM borrow a  INNER JOIN reader b ON a.`rid`=b.`rid`
INNER JOIN book c ON a.`nif`=c.`bid` WHERE returndate IS NULL

SELECT 
  a.`bname` AS 书名,
  a.`bcount` - COUNT(b.`nif`) AS 本书 
FROM
  book a 
  LEFT OUTER JOIN borrow b 
    ON a.`bid` = b.`nif` 
GROUP BY b.`nif` ;

#从已完成借阅的记录（日期不为空）中，统计每位读者的借书次数，显示读者姓名和借书次数
SELECT 
  COUNT(b.`nif`) AS 借书次数,
  r.`rname` AS 读者姓名 
FROM
  borrow b 
  INNER JOIN reader r 
    ON b.`rid` = r.`rid` 
WHERE returndate IS NOT NULL 
GROUP BY b.`nif` ;

#查询总罚款金额大于5元的读者姓名和总罚款金额
SELECT 
  SUM(a.`amount`) AS 罚款金额,
  b.`rname` AS 读者姓名 
FROM
  penalty a 
  LEFT JOIN reader b 
    ON a.`rid` = b.`rid` 
GROUP BY b.`rname` 
HAVING 罚款金额 > 5 

#统计已完成借阅的记录（归还日期不为空）中每本书的借阅记录次数，
#显示借阅次数排名在前5位的书名和借阅次数
SELECT 
  COUNT(a.nif) AS 借阅次数,
  b.`bname` AS 书名 
FROM
  borrow a 
  INNER JOIN book b 
    ON a.`nif` = b.`bid` 
WHERE a.returndate IS NOT NULL 
GROUP BY a.nif 
ORDER BY COUNT(a.nif) DESC 
LIMIT 5 