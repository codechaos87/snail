SELECT empid,proid,
SUM(CASE MONTH(sadate) WHEN '9' THEN num ELSE 0 END)九月,
SUM(CASE MONTH(sadate) WHEN '10' THEN num ELSE 0 END)十月,
SUM(CASE MONTH(sadate) WHEN '11' THEN num ELSE 0 END)十一月,
SUM(CASE MONTH(sadate) WHEN '12' THEN num ELSE 0 END)十二月
FROM sales
GROUP BY empid ,proid

CREATE TABLE ABC
(
	A VARCHAR(10),
	B INT,
	C CHAR(2),
	D VARCHAR(10)
)
INSERT INTO ABC VALUES('王小',10,'正','二班');
INSERT INTO ABC VALUES('李大',20,'正','一班');
INSERT INTO ABC VALUES('张五',15,'负','一班');
INSERT INTO ABC VALUES('赵三',40,'负','二班');
INSERT INTO ABC VALUES('王小',5 ,'负','二班');
SELECT * FROM ABC

SELECT a,SUM(CASE c WHEN '负' THEN -b ELSE b END)AS b,d FROM abc 
GROUP BY a,d
DELIMITER ;;
CREATE PROCEDURE test_3()
 BEGIN
  
    INSERT INTO penalty (rid,bid,pdate,ptype,amount) VALUES('0009','0007',NOW(),1,4.6);
    INSERT INTO borrow(rid,nif,lenddate,willdate,returndate) VALUES('0008','0007','2017-09-13 09:20:00','2017-10-21 09:40:00',NOW());
     UPDATE book SET bcount=bcount+1 WHERE bid='0007';
     UPDATE reader SET lennum=lennum-1 WHERE rid='0008';
END
;;
DELIMITER ;
 
 CALL test_3();
 

