SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
SELECT * FROM penalty;

SELECT * FROM borrow WHERE returndate IS NULL;

SELECT * FROM reader WHERE raddress IS NULL;

SELECT * FROM reader WHERE rid IN(

SELECT  reader FROM borrow WHERE raddress IS NULL

)
#先查当前没有被借阅的图书

SELECT  bname, bid,author,pubcomp, price FROM book WHERE bid  IN 
(
	SELECT nif FROM borrow WHERE returndate IS NULL
) ;
#查出今年所有缴纳罚款的读者清单
SELECT r.rname,b.bname,p.pdate,p.amount FROM penalty p
 INNER JOIN reader r ON p.rid=r.rid 
 INNER JOIN book b ON  p.bid=b.`bid`
WHERE p.bid IN 
(SELECT bid FROM penalty WHERE pdate>'2018');

#地址为空的所有为空的所有读者未归还 的书
/*SELECT r.rid,r.rname ab.bname,b.lenddate,b.willdate  FROM borrow b
inner join reader r on b.`rid`=r.`rid`
inner join book ab on b.`nif`=ab.`bid`
where r.rid in
(SELECT rid FROM reader WHERE raddress IS NULL)and b.`rid`in
(SELECT rid FROM borrow WHERE returndate IS NULL)order by r.`rid` desc,
b.`lenddate` ASC;*/	

SELECT r.rid,r.rname,bb.bname,b.lenddate,b.willdate FROM borrow b 
  INNER JOIN book bb ON b.`nif` = bb.`bid` 
  INNER JOIN reader r ON b.`rid` = r.`rid` 
WHERE r.`rid` IN 
(SELECT rid FROM reader WHERE raddress IS NULL) AND b.`rid` IN 
(SELECT rid FROM borrow WHERE returndate IS NULL) ORDER BY r.`rid` ASC,
b.`lenddate` ASC;