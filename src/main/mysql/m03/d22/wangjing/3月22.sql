SELECT * FROM hos_district;
SELECT * FROM hos_street;
SELECT * FROM hos_house;
SELECT * FROM hos_type;
SELECT * FROM sys_user;

#根据户型所在的区县和街道，为至少有两个街道有出租屋的区县制作出租屋清单

SELECT s.`SID` AS 街道编号,COUNT(*) AS 所在街道出租房总数
FROM hos_house h
LEFT JOIN hos_street s
ON s.`SID`=h.`SID`
GROUP BY s.`SID`
HAVING COUNT(*)>1;

#先筛选出街道数量大于一的区县

SELECT sid FROM hos_street WHERE sdid IN(
SELECT d.did AS 区县编号
#d.`Dname` as 区县名称,
#count(d.`Did`) as 此区县有出租房的街道数量
FROM hos_street s
LEFT JOIN  hos_district d
ON d.`Did`=s.`sdID`
GROUP BY d.`Did` 
HAVING COUNT(d.`Did`)>1
)

