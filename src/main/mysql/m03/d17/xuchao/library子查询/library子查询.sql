#1、查询当前没有被读者借阅的的图书信息
SELECT 
  bname,
  bid,
  author,
  pubcomp,
  price 
FROM
  book 
WHERE bid NOT IN 
  (SELECT 
    nif 
  FROM
    borrow 
  WHERE returndate IS NULL) ;

#2、查询今年所有缴纳罚款的读者清单

SELECT 
  r.rname,
  b.bname,
  p.pdate,
  p.amount 
FROM
  penalty p 
  INNER JOIN reader r 
    ON p.`rid` = r.`rid` 
  INNER JOIN book b 
    ON p.`bid` = b.`bid` 
WHERE p.bid IN 
  (SELECT 
    bid 
  FROM
    penalty 
  WHERE pdate > '2018') ;
  
#3、查询地址为空的读者尚未归还的清单
SELECT 
  r.rid,
  r.rname,
  bb.bname,
  b.lenddate,
  b.willdate 
FROM
  borrow b 
  INNER JOIN book bb 
    ON b.`nif` = bb.`bid` 
  INNER JOIN reader r 
    ON b.`rid` = r.`rid` 
WHERE r.`rid` IN 
  (SELECT 
    rid 
  FROM
    reader 
  WHERE raddress IS NULL) 
  AND b.`rid` IN 
  (SELECT 
    rid 
  FROM
    borrow 
  WHERE returndate IS NULL) 
ORDER BY r.`rid` DESC,
  b.`lenddate` ASC;