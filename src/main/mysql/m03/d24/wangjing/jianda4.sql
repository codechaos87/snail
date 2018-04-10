USE library;
SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
SELECT rid FROM borrow 

#编码实现读者刘冰冰缴纳罚金归还图书的手续，要求一次完成以下功能
/*
在罚款记录中增加一条记录，记录刘冰冰因延期归还《西游记》一书而缴纳滞纳金的4.6元
在图书借阅表中修改归还日期为当前日期
将读者信息表中已借书数量减少1
将图书信息表中现存数量加1
*/
UPDATE reader SET lennum=1 WHERE rid=0008;
BEGIN;
UPDATE borrow SET returndate=NOW() WHERE rid=0008;
UPDATE reader SET lennum=lennum-1 WHERE rid=0008;
UPDATE book SET bcount=bcount+1 WHERE bid=0007;
COMMIT;