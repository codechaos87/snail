


SELECT * FROM reader
INSERT INTO reader VALUES(9,'张无忌',0,'null');
UPDATE book SET bcount=bcount-1 WHERE bname='红楼梦';
UPDATE reader SET lennum=lennum+1 WHERE rname='张无忌';

UPDATE reader SET lennum=lennum+1 WHERE rname='刘冰冰'

INSERT INTO borrow(rid,nif,lenddate,willdate) VALUES('0009','0007','2017-09-23 09:20:00','2017-10-01 09:20:00');

SELECT * FROM borrow

UPDATE  borrow SET returndate=NOW() WHERE rid=0008;
UPDATE reader SET  lennum=lennum-1 WHERE rid=0008;
UPDATE book SET bcount=bcount+1 WHERE  bid=0007;

SHOW INDEX FROM book
SELECT a.willdate AS 到期日期, b.bname AS 书名, c.rname AS 读者信息 FROM borrow a 
INNER JOIN book b ON a.nif=b.bid INNER JOIN reader c ON a.rid=c.rid 
WHERE willdate<NOW()&&returndate IS NULL 

SELECT 
  a.`bid`,
  a.`bname`,
  COUNT(b.`nif`) 数量,
  a.`bcount` - COUNT(b.`nif`) AS 数量2,
  a.author,
  a.pubcomp,
  a.price 
FROM
  book a 
  LEFT OUTER JOIN borrow b 
    ON a.`bid` = b.`nif` 
GROUP BY b.`nif` ;


CREATE VIEW vw_librarian AS SELECT a.willdate AS 到期日期, b.bname AS 书名, c.rname AS 读者信息 FROM borrow a 
INNER JOIN book b ON a.nif=b.bid INNER JOIN reader c ON a.rid=c.rid 
WHERE willdate<NOW()&&returndate IS NULL 

CREATE INDEX vw_librarian ON book (bname)

CREATE VIEW vw_booknum AS SELECT 
  a.`bid`,
  a.`bname`,
  COUNT(b.`nif`) 数量,
  a.`bcount` - COUNT(b.`nif`) AS 数量2,
  a.author,
  a.pubcomp,
  a.price 
FROM
  book a 
  LEFT OUTER JOIN borrow b 
    ON a.`bid` = b.`nif` 
GROUP BY b.`nif` ;

CREATE INDEX vw_booknum ON book (bname)

 
