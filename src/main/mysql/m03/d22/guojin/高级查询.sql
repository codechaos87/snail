SELECT 
  t.htname AS 户型,
  u.uname AS 姓名,
  d.dname AS 区县,
  s.sname AS 街道 
FROM
  hos_type t,
  sys_user u,
  hos_district d,
  hos_street s,
  hos_house h 
WHERE t.`HTID` = h.`HTID` 
  AND u.`UID` = h.`UID` = s.sdid 
  AND s.`SID`= h.`SID` 
  AND h.`SID` IN 
  (SELECT 
    sid 
  FROM
    hos_street 
  WHERE sdid IN 
    (SELECT 
      sdid 
    FROM
      hos_street street,
      (SELECT DISTINCT 
        (sid) 
      FROM
        hos_house) AS temp 
    WHERE street.`SDID` = temp.sid 
    GROUP BY sdid 
    HAVING COUNT(street.`SID`) > 1)) ;

