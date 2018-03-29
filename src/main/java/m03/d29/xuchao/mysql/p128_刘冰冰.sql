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