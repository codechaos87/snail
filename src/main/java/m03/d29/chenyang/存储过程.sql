/*
 按月统计销售表中货物的销售量数
查询结果如下：
  No， No2 ，   九月， 　十月，十一月，十二月
 1234，567890， 　66.5 ，　 0 ， 　0  ，  33.5
 1234，598701，   0   ，　45.2，　44.8，　　0
 3456，789065，　　0  ，　100， 　0   ，　0
 3456，678901，　　0　，    0，   0  ， 48.5
*/
SELECT empid,proid,
     SUM(CASE MONTH(saDate) WHEN '9' THEN num ELSE 0 END) 九月,
     SUM(CASE MONTH(saDate) WHEN '10' THEN num ELSE 0 END) 十月,
     SUM(CASE MONTH(saDate) WHEN '11' THEN num ELSE 0 END) 十一月,
     SUM(CASE MONTH(saDate) WHEN '12' THEN num ELSE 0 END) 十二月
   FROM sales
   GROUP BY empid,proid;
   
/*
汇总时按字段D 和A分组,汇总字段B,C可以不显示,
如果C为'负'则对应的B为负数.

结果如下:

A           B        D
-------------------------
王小       5         二班
李大       20        一班
张五       -15       一班
赵三       -40       二班
*/
SELECT A,SUM(CASE C WHEN '正' THEN b ELSE -b END)AS B,D FROM abc GROUP BY A,D;

#用存储过程的方式做p128第4题
DELIMITER ;;
CREATE PROCEDURE ups_p128_4(IN lbb VARCHAR(100))
BEGIN
	INSERT INTO penalty(rid,bid,pdate,ptype,amount)
	VALUES((SELECT rid FROM reader WHERE rname=lbb),
	       (SELECT bid FROM book WHERE bname='西游记'),
	       NOW(),1,4.6);
	UPDATE borrow SET returndate=NOW() WHERE rid =
		(SELECT rid FROM reader WHERE rname=lbb) AND nif =
		(SELECT bid FROM book WHERE bname='西游记');
	UPDATE reader SET lennum=lennum-1 WHERE rname=lbb;
	UPDATE book SET bcount=bcount+1 WHERE bname='西游记';
END;;
DELIMITER ;

CALL ups_p128_4('刘冰冰');