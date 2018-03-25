#为读者张无忌办理借阅《红楼梦》书籍的手续，要求编码实现
USE library;
SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
DELETE FROM reader WHERE rid=0009;
DELETE FROM borrow WHERE rid=0009;
INSERT INTO reader VALUE(0009,'张无忌',2,'京大大');

SELECT bid FROM book WHERE bname='红楼梦';

SELECT rid FROM reader WHERE 


#添加张无忌的信息
#添加一条借阅记录
#图书信息表减1
#读者信息表已借书数量加1
BEGIN;
INSERT INTO reader VALUE(0009,'张无忌',2,'京大大');

INSERT INTO borrow VALUE(0008,0003,DATE(),NULL,NULL);

UPDATE reader SET bcount=bcount-1  WHERE bid=(
bid FROM book WHERE bname='红楼梦';)

UPDATE book SET lennum=lennum+1  WHERE rid=0009;
COMMIT;