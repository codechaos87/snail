#为读者"曹雪芹"，办理借阅《红楼梦》书籍
INSERT INTO reader  SET rid='0009',rname='张无忌',lennum=0;
SET autocommit=0;
UPDATE book SET bcount=bcount-1  WHERE bname='红楼梦';
UPDATE reader SET  lennum=lennum+1 WHERE rname='张无忌';
COMMIT;
ROLLBACK;
SET autocommit=1;
#实现读者"刘冰冰"，缴纳罚金归还图书的手续
INSERT INTO penalty SET  rid='0008',bid='0007',pdate='2018-10-06',amount='4.6';
UPDATE borrow SET willdate='2018-03-24' WHERE rid='0009';
BEGIN;
UPDATE reader SET lennum=lennum-1 WHERE rname='刘冰冰';
ROLLBACK;
UPDATE book SET bcount=bcount+1 WHERE bid='0007';
COMMIT;
#向图书名称创建索引
CREATE INDEX ix_bname
ON book(bname);
#管理员使用表
CREATE VIEW vm_book
AS SELECT bk.bname AS 到期图书清单 ,bw.willdate AS 到期日期, bk.bname AS 图书名称, re.rname AS 读者姓名 FROM book bk
INNER JOIN borrow bw ON bk.bid=bw.nif 
INNER JOIN reader re ON bk.bid=re.rid
ORDER BY 到期日期 LIMIT 6
#读者表
CREATE VIEW vm_reader
AS SELECT bk.bname AS 图书名称, bk.bcount AS 馆存量, (bcount-bk.bid)AS 可借书数量 FROM book bk
INNER JOIN reader re ON bk.bid=re.rid
INNER JOIN borrow bw ON bk.bid=bw.nif
GROUP BY bk.bid;









