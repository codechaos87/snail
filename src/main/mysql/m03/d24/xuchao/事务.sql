#1.为读者“张无忌”(没有张无忌 换个人)办理借阅《红楼梦》书籍的手续，book中书的当前数量减1，reader已借书数量加1。
BEGIN;
UPDATE book SET bcount = bcount - 1 WHERE bid='0006';
UPDATE reader SET lennum = lennum+1 WHERE rid='0006';
COMMIT;

SELECT * FROM book;
SELECT * FROM reader;

/*
  2.编码实现读者“刘冰冰”缴纳罚金归还图书的手续，要求一次完成以下功能
  在penalty中增加刘冰冰因延期归还《西游记》而缴纳滞纳金4.6元。
  在borrow中修改归还日期为当前日期。
  将reader中已借书数量减1。
  将book中的现存数量加1.
*/
BEGIN;
INSERT INTO penalty(rid,bid,pdate,ptype,amount)
VALUES('0008','0007',NOW(),'1','4.6');
UPDATE borrow SET returndate=NOW() WHERE rid='0008' AND nif='0007';
UPDATE reader SET lennum=lennum-1 WHERE rid='0008';
UPDATE book SET bcount=bcount+1 WHERE nif='0007';
COMMIT;

/*
  为book中的bname字段创建索引
  为图书管理员和读者分别创建不同的查询视图
*/
BEGIN;
#创建索引
CREATE INDEX index_book_bname ON book(bname);
#创建图书管理员视图
DROP VIEW IF EXISTS vw_library_admin;
CREATE VIEW vw_library_admin
AS
SELECT 
(SELECT bname FROM book WHERE bo.nif=bid) AS 图书名称,
willdate AS 到期日期,
(SELECT rname FROM reader WHERE bo.rid=rid) AS 读者姓名
FROM borrow bo WHERE returndate IS NULL AND willdate - NOW()<0;
#创建读者视图
DROP VIEW IF EXISTS vw_library_reader;
CREATE VIEW vw_library_reader
AS
SELECT
bname AS 图书名称,
bcount AS 馆存量,
bcount - COUNT(bo.nif) AS 可借阅数量
FROM
book b
LEFT JOIN borrow bo ON bo.nif=b.bid
GROUP BY b.bname;