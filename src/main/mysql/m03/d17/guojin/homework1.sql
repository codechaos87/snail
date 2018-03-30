#使用子查询获得地址为空的所有读者尚未归还的图书清单，要求：按读者编号从高到底、借书日期由近到远的顺序输出读者编号、
#读者姓名、图书名称、借书日期和应归还日期
SELECT a.`rid`,a.`rname`,b.`willdate`,b.`lenddate` FROM reader a INNER JOIN borrow b ON a.`rid`=b.`rid`   WHERE raddress IS NULL ORDER BY rid DESC  

SELECT YEAR(b.`pdate`),a.`rname`,b.`amount`,c.`bname` FROM reader a INNER JOIN penalty b ON a.`rid`=b.`rid` INNER JOIN book c ON b.`bid`=c.`bid` WHERE pdate > '2018.0.0' ORDER BY pdate DESC



SELECT * FROM book
SELECT * FROM borrow
SELECT * FROM book WHERE bid IN(
  SELECT nif FROM borrow WHERE returndate IS NULL
);