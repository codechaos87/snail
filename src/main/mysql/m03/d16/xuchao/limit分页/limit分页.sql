DESC student ;

INSERT INTO student (sname, address) 
VALUES
  ('老王', '隔壁'),
  ('老王', '隔壁'),
  ('老王', '隔壁') ;

#第一页数据
SELECT *
FROM student
LIMIT 3;

#第二页数据
SELECT *
FROM student
LIMIT 3,3;

#第三页数据
SELECT *
FROM student
LIMIT 6,3;

#第四页数据
SELECT *
FROM student
LIMIT 9,3;