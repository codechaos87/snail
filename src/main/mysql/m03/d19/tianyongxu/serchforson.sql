SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM penalty;
SELECT * FROM reader;
#第三题，题目
SELECT 
  (SELECT r.rname FROM reader r WHERE r.rid = bw.rid),
  (SELECT bk.bname FROM book bk WHERE bk.bid=bw.`nif`),
   bw.`willdate` 
FROM borrow bw WHERE DATE(bw.`willdate`)>NOW();

#第四题，题目
 SELECT b.`bname`,
	COUNT(p.`amount`) AS 借出数量,
	b.`bcount`-COUNT(p.`amount`) AS 剩余数量
 FROM  book b 
 LEFT JOIN penalty p 
 ON b.`bid`=p.`bid` 
 GROUP BY p.`bid`;
 #第五题，
 SELECT COUNT(*),r.`rname`
 FROM borrow bw 
 INNER JOIN reader r
 ON bw.`rid`=r.`rid`
 WHERE r.`raddress` IS NOT NULL
 GROUP BY bw.`rid`;
 
 #第六题  对于count的使用还不是很好，理解不清晰；
 SELECT COUNT(*)*p.`amount`AS 罚款金额,
	r.`rname`
 FROM penalty p
 INNER JOIN reader r
 ON p.`rid`=r.`rid`
 GROUP BY p.`rid`
 HAVING COUNT(*)>2;
 
 #第七题
 SELECT COUNT(bw.`nif`) 
	
 FROM borrow bw
 GROUP BY bw.`nif`
 ORDER BY COUNT(bw.nif) DESC
 LIMIT 0,5;
 