INSERT INTO tt(sid,sname) SELECT sid,sname FROM stu;

SELECT * FROM book;

SELECT * FROM borrow;

SELECT * FROM penalty;

SELECT * FROM reader;

/*
   需求：获得当前没有被读者借阅的图书信息。
   显示：图书名称，图书编号，作者姓名，出版社和单价
   分析：1.borrow(nif)与book(bid)有关系
   book当成主表(主表数据需要全部显示)
   left join 看哪张表是主表
*/
SELECT 
  a.`bid`,
  a.`bname`,
  COUNT(b.`nif`) 数量,
  a.`bcount` - COUNT(b.`nif`) AS 数量2,
  a.author,
  a.pubcomp,
  a.price 
FROM
  book a 
  LEFT OUTER JOIN borrow b 
    ON a.`bid` = b.`nif` 
GROUP BY b.`nif` ;

#只显示共同部份  用inner join是有问题
SELECT 
  a.`bid`,
  a.`bname`,
  COUNT(b.`nif`) 数量,
  a.`bcount` - COUNT(b.`nif`) AS 数量2,
  a.author,
  a.pubcomp,
  a.price 
FROM
  book a 
  INNER JOIN borrow b 
    ON a.`bid` = b.`nif` 
GROUP BY b.`nif` ;


#group by ?
#1：分组  2：统计
SELECT * FROM borrow;

SELECT a.`nif`,COUNT(*) AS 数量 FROM borrow a GROUP BY a.`nif`;

SELECT * FROM(
	SELECT 
	  a.`bid`,
	  a.`bname`,
	  COUNT(b.`nif`) 数量,
	  a.`bcount` - COUNT(b.`nif`) AS 数量2,
	  a.author,
	  a.pubcomp,
	  a.price 
	FROM
	  book a 
	  LEFT OUTER JOIN borrow b 
	    ON a.`bid` = b.`nif` 
	GROUP BY b.`nif` ) m;

SELECT * FROM penalty;
SELECT * FROM reader;
SELECT * FROM book;

#获取今年的所有缴纳罚款的读者清单  子查询
#显示：读者姓名，图书名称，罚款日期和缴纳罚金
#子查询写在select
SELECT  
(SELECT rname FROM reader WHERE a.`rid`=rid) AS 读者姓名,
(SELECT bname FROM book WHERE a.`bid`=bid) AS 图书名称,
a.`pdate` AS 罚款日期,
a.`amount` AS 缴纳罚金
FROM penalty a WHERE YEAR(a.`pdate`)=YEAR(NOW());
#date_format
SELECT  
(SELECT rname FROM reader WHERE a.`rid`=rid) AS 读者姓名,
(SELECT bname FROM book WHERE a.`bid`=bid) AS 图书名称,
DATE_FORMAT(a.`pdate`,'%Y年%m月%d日') AS 罚款日期,
a.`amount` AS 缴纳罚金
FROM penalty a WHERE YEAR(a.`pdate`)=YEAR(NOW());



/*
 子查询获得地址为空的所有读者尚未归还的图书清单
 按读者编号从高到低，借书日期由近至远的顺序输出：
 读者编号，读者姓名，图书名称，借书日期和应归还日期
*/
SELECT * FROM reader;
SELECT * FROM borrow;

SELECT rid AS 编号,
(SELECT rname FROM reader WHERE a.`rid`=rid) AS 读者姓名,
(SELECT bname FROM book WHERE a.`nif`=bid) AS 图书名称,
a.`lenddate` AS 借书日期,
a.`willdate` AS 应归还日期 FROM borrow a 
WHERE rid IN(
	SELECT rid FROM reader WHERE  raddress IS NULL
)
ORDER BY a.`rid` DESC,a.`lenddate` DESC;


/*
需求：检查“Logic Java”课程最近一次考试成绩 
如果有 80分以上的成绩，显示分数排在前5名的学员学号和分数
*/
SELECT * FROM score a
WHERE a.`sdate`=(
	SELECT MAX(sdate) FROM score WHERE subjectno =(
		SELECT subjectno FROM SUBJECT WHERE subjectname='Logic Java')
) AND a.`subjectno`=(SELECT subjectno FROM SUBJECT WHERE subjectname='Logic Java')
AND sexam>80;

#用exists要注意整个结构，一个结构返回的为true是不够（只看结果），多个去限制
SELECT * FROM score
WHERE  EXISTS(
	SELECT * FROM score a
		WHERE a.`sdate`=(
		SELECT MAX(sdate) FROM score WHERE subjectno =(
			SELECT subjectno FROM SUBJECT WHERE subjectname='Logic Java')
		) AND a.`subjectno`=(SELECT subjectno FROM SUBJECT WHERE subjectname='Logic Java')
	AND sexam>80
) AND sdate=(
     SELECT MAX(sdate) FROM score WHERE subjectno =(
		SELECT subjectno FROM SUBJECT WHERE subjectname='Logic Java')
) AND subjectno=(SELECT subjectno FROM SUBJECT WHERE subjectname='Logic Java')
AND  sexam>80;

#not exists与exists是相反

#group by 与聚合函数一起使用！
#根据课程编号获取每一个课程的平均分
SELECT * FROM score;

SELECT subjectno AS 课程编号, AVG(sexam) AS 平均分 FROM score GROUP BY subjectno;
#按什么字段（业务）分组 
#分组注意事项：select能写什么，不能写什么字段，由group by 决定
SELECT subjectno AS 课程编号,studentno AS 学生编号, 
AVG(sexam) AS 平均分 FROM score GROUP BY subjectno,studentno;

SELECT * FROM student;

#需求统计gradeid和sex字段统计人员，排序，
#统计之后过滤(having 分完组后过滤)每个年级只有一个人的情况（男女不限），
#不显示？
SELECT 
  a.`GradeId`,
  a.`Sex`,
  COUNT(*) AS 人数 
FROM
  student a 
GROUP BY a.`GradeId`,
  a.`Sex` 
HAVING COUNT(*)>1
ORDER BY 人数 DESC;





#对象概念
SELECT 
  * 
FROM
  score 
WHERE EXISTS 
  (SELECT 
    * 
  FROM
    score a 
  WHERE a.`sdate` = 
    (SELECT 
      MAX(sdate) 
    FROM
      score 
    WHERE subjectno = 
      (SELECT 
        subjectno 
      FROM
        SUBJECT 
      WHERE subjectname = 'Logic Java')) 
    AND a.`subjectno` = 
    (SELECT 
      subjectno 
    FROM
      SUBJECT 
    WHERE subjectname = 'Logic Java'))
    
    
 SELECT * FROM score WHERE 1=1;
 
  SELECT * FROM score WHERE EXISTS TRUE;
  
CREATE DATABASE mydata2;
  
USE mydata2;
 #创建省份表
 CREATE TABLE province
 (
	pid INT PRIMARY KEY,
	pname VARCHAR(200)
 )
 INSERT INTO province VALUES(1,'湖北');
 INSERT INTO province VALUES(2,'湖南');
 INSERT INTO province VALUES(3,'广东');
 
#创建城市表
CREATE TABLE city
(
	cid INT PRIMARY KEY,
	cname VARCHAR(200),
	pid INT
)
INSERT INTO city VALUES(1,'武汉',1);
INSERT INTO city VALUES(2,'黄梅',1);
INSERT INTO city VALUES(3,'长沙',2);
INSERT INTO city VALUES(4,'常德',2);

#内联方式
SELECT a.cid,a.cname,b.pname FROM city a
INNER JOIN province b ON a.pid=b.pid;


#left [outer] join 主表 city 
SELECT a.cid,a.cname,b.pname FROM city a
LEFT OUTER JOIN province b ON a.pid=b.pid;
#主表province
SELECT a.pid,a.pname,b.cname FROM province a
LEFT JOIN city b ON a.pid=b.pid;

#right
SELECT a.cid,a.cname,b.pname FROM city a
RIGHT OUTER JOIN province b ON a.pid=b.pid;


  SELECT a.bid,
  a.bName,
  a.author,
  a.pubcomp,
  a.price
FROM
  book a 
  LEFT OUTER JOIN borrow b 
    ON a.`bid` = b.`nif` 
GROUP BY b.`nif` 









