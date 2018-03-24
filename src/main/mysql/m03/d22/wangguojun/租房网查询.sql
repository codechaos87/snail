#查询输出第6条~第10条租房网信息，
SELECT * FROM hos_house WHERE (HMID>=6 AND HMID<=10);
#查询张三发布的所有出租房信息，显示房屋分布的街道和区县
SELECT a.`price`,a.`TOPIC`,
(SELECT sname FROM hos_street WHERE a.`SID`=sid) AS 街道,
(SELECT dname FROM hos_district WHERE did IN(
	SELECT sdid FROM hos_street WHERE a.`SID`=sid
)) AS 区县 FROM hos_house a
WHERE a.`UID` =(
	SELECT uid FROM sys_user WHERE uname='张三'
)
#根据房型和房屋所在的区县和街道，为至少有2个街道的出租屋的区县制作出租房屋的区县
SELECT a.topic AS 街道,
(SELECT htname FROM hos_type WHERE a.`HTID`=htid) AS 户型,
(SELECT uname FROM sys_user WHERE a.`UID`=uid) AS 姓名,
(SELECT dname FROM hos_district WHERE did IN(
 SELECT sdid FROM hos_street WHERE a.`SID`=sid
))AS 区县 FROM hos_house a WHERE a.`SID`>1

#按季度算出本年各县各街道各种户型房屋的出租数量





