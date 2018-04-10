#3.为读者“张无忌”办理借阅“红楼梦”书籍的手续，要求编码实现。
BEGIN;
SELECT * FROM reader;
INSERT INTO reader(rid,rname,lennum,raddress) VALUES('0009','张无忌',1,'null');
SELECT * FROM book;
UPDATE book SET bcount=bcount-1 WHERE bname='红楼梦';
SELECT * FROM borrow;
INSERT INTO borrow(rid,nif,lenddate,willdate,returndate) VALUES('0009','0006',NOW(),NULL,NULL);
COMMIT;

#4.编码实现读者“刘冰冰”缴纳罚金归还图书的手续。
BEGIN;
INSERT INTO penalty VALUES('0008','0007',NOW(),1,4.6);
UPDATE reader SET lennum=lennum-1 WHERE rid='0008';
UPDATE book SET bcount=bcount+1 WHERE bid='0007';
COMMIT;

#5.为图书管理员和读者分别创建不同的查询视图，并利用所创建的索引和视图获得相关数据。
BEGIN;
CREATE INDEX index_book_bname ON book(bname);
CREATE VIEW librarian
AS
SELECT 
willdate AS 到期日期,
(SELECT bname FROM book WHERE br.`nif`=bid) AS 图书名称,
(SELECT rname FROM reader WHERE br.`rid`=rid) AS 读者姓名
FROM borrow br
WHERE willdate<NOW()
AND returndate IS NULL;
SELECT * FROM librarian;
CREATE INDEX 图书 ON librarian(图书名称);


CREATE VIEW view_reader
AS 
SELECT
bname AS 图书名称,
bcount AS 馆存量,
bcount - COUNT(bo.nif) AS 可借阅数量
FROM
book b
LEFT JOIN borrow bo ON bo.nif=b.bid
GROUP BY b.bname;

SELECT
bname AS 图书名称,
bcount AS 馆存量,
bcount-(SELECT COUNT(*) AS 已借出数量 FROM
(SELECT * FROM borrow WHERE returndate IS NULL) Nb
GROUP BY Nb.nif) AS 可借阅数量
FROM book b
LEFT JOIN borrow br 
ON br.nif=b.bid;

