#用存储过程获取全部信息
DELIMITER ;;
CREATE PROCEDURE ups_getAllInfo()
BEGIN
	SELECT * FROM question_info;
END;;
DELIMITER ;

CALL ups_getAllInfo;

SELECT * FROM question_info WHERE qsubject = 2;

#用存储过程进行模糊查询
DELIMITER ;;
CREATE PROCEDURE ups_getMohuInfo(IN mohu VARCHAR(200))
BEGIN
	SELECT * FROM question_info WHERE question LIKE mohu;
END;;
DELIMITER ;

CALL ups_getMohuInfo('%Java%');





