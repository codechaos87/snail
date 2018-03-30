USE library;


SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM borrow;
/*图书管理员：最新的到期图书清单 包括 图书名称，到期日期，和读者姓名等信息
  读者： 图书名称，馆存量 可借阅数量
*/

SELECT 
SELECT bname,
(SELECT willdate FROM borrow s WHERE m.bid=s.nif)
 FROM book a WHERE a.`bid`IN(
	SELECT nif FROM borrow
	WHERE willdate<NOW()
	ORDER BY willdate DESC m
	
)


