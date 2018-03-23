#一、查询第6条~第10条出租房屋信息 用临时表存储
CREATE TEMPORARY TABLE temp (
	SELECT * FROM hos_house LIMIT 5,5
);
DROP TABLE temp;
SELECT * FROM temp;

#二、查询张三发布的所有房屋信息
#1、子查询
SELECT
(SELECT dname FROM hos_district WHERE did IN(
SELECT sdid FROM hos_street WHERE sid=hh.sid
))AS 区县,
(SELECT sname FROM hos_street WHERE sid=hh.`SID`)AS 街道,
htid AS 户型,
price AS 价格,
topic AS 标题,
contents AS 描述,
htime AS 时间,
copy AS 备注
FROM hos_house hh
WHERE uid IN(
	SELECT uid FROM sys_user WHERE uname ='张三'
);

#2、表连接
SELECT
hd.`DName` AS 区县,
hs.`SName` AS 街道,
hh.htid AS 户型,
hh.price AS 价格,
hh.topic AS 标题,
hh.contents AS 描述,
hh.htime AS 时间,
hh.copy AS 备注
FROM hos_house hh
INNER JOIN hos_street hs ON hs.`SID`=hh.`SID`
INNER JOIN hos_district hd ON hd.`DID`=hs.`SDID`
INNER JOIN sys_user su ON su.`UID`=hh.`UID`
WHERE su.`UName`='张三';

#三、根据户型和房屋所在的区县和街道，为至少有两个街道有出租屋的区县制作租房屋清单
SELECT 
ht.`HTName` AS 户型,su.`UName` AS 姓名,hd.`DName` AS 区县,hs.`SName` AS 街道
FROM hos_district hd
INNER JOIN hos_street hs ON hs.`SDID`=hd.`DID`
INNER JOIN hos_house hh ON hh.`SID`=hs.`SID`
INNER JOIN hos_type ht ON ht.`HTID`=hh.`HTID`
INNER JOIN sys_user su ON su.`UID`=hh.`UID` 
WHERE did IN(
	SELECT sdid FROM hos_street WHERE sid IN(SELECT sid FROM hos_house) GROUP BY sdid HAVING COUNT(sid)>1
);

SELECT
sid AS 街道编号,COUNT(*)AS 个数
FROM hos_house
GROUP BY sid;

SELECT
sdid AS 区县编号,COUNT(sid) AS 街道数
FROM hos_street
WHERE sid IN(
	SELECT sid FROM hos_house 
)
GROUP BY sdid
HAVING 街道数>1;

#按季度统计本年发布的房屋数量
SELECT FLOOR((DATE_FORMAT(htime,'%m')+2)/3) AS 季度,COUNT(*)AS 合计 FROM hos_house
WHERE FLOOR((DATE_FORMAT(htime,'%m')+2)/3)=1;











