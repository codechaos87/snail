SELECT * FROM book;
SELECT * FROM borrow;
SELECT * FROM reader;
SELECT * FROM penalty;
#第一题，增加一个事件，这样就能。
BEGIN;
INSERT INTO reader(rid,rname,lennum,raddress) VALUES('0009','张无忌',1,'光明顶');
INSERT INTO borrow(rid,nif,lenddate,willdate,returndate) VALUES('00009',007,NOW(),'2019-01-01',NULL);
UPDATE book SET bcount=bcount-1;
COMMIT;
DELETE FROM borrow WHERE rid=00009;
#实现刘冰冰罚款、还书的手续；
#1、增加罚款信息
#2、归还日期改为当前日期
#3、读书信息中已借阅书量减一；
#4、将如数信息表中现存数量加1；
DELETE FROM penalty WHERE rid=0008;
 START TRANSACTION;
 INSERT INTO penalty(rid,bid,pdate,ptype,amount) VALUES('0008','0007',NOW(),1,4.6);
 UPDATE borrow SET returndate= NOW()WHERE rid=0009;
 UPDATE reader SET lennum=lennum-1 WHERE rid=0008;
 UPDATE book SET bcount=bcount+1 WHERE bid=0007;
 COMMIT;
 
 #分别创建读者和图书管理员的视图；
  CREATE VIEW  index_reader
  AS 
     SELECT b.bname AS 书名,
	    b.bcount-COUNT(bw.nif) AS 剩余数量,
	    b.bcount AS 总量
     FROM book b
     INNER JOIN borrow bw ON b.bid=bw.nif
     GROUP BY bw.nif;
     #查询语句
   SELECT * FROM index_reader;
   CREATE INDEX index_01 ON book(bname);  
   SHOW INDEX FROM book;
     
 CREATE VIEW index_librarian
 AS 
    SELECT b.bname AS 书名,
           bw.willdate AS 到期日期,
           r.rname AS 读者姓名 
    FROM book b
    INNER JOIN borrow bw ON b.bid=bw.nif
    INNER JOIN reader r ON r.rid = bw.rid; 
    
    SELECT * FROM index_librarian;
    CREATE INDEX index_02 ON index_librarian(书名);  
 