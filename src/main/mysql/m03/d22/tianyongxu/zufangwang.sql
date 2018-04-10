

CREATE DATABASE House;
	
    USE House
    
	CREATE TABLE sys_user
	(
	 UID INT  PRIMARY KEY AUTO_INCREMENT,
	 UName VARCHAR(20) NOT NULL,
	 UPASSWORD VARCHAR(20)
	)

	#创建区县信息表hos_district
	IF EXISTS (SELECT * FROM sysobjects WHERE NAME='hos_district')
	DROP TABLE hos_district
	
	CREATE TABLE hos_district
	(
		DID INT PRIMARY KEY identity(1,1),
		DName VARCHAR(20) NOT NULL
	)
	
	#创建街道信息表
	IF EXISTS(SELECT * FROM sysobjects WHERE NAME='hos_street')
	DROP TABLE hos_street
	
	CREATE TABLE hos_street
	(
	SID INT identity(1,1) PRIMARY KEY,
	SName VARCHAR(20) NOT NULL,
	SDID INT NOT NULL
	)
	
	#给街道表添加约束
	ALTER TABLE hos_street ADD CONSTRAINT FK_SDID FOREIGN KEY(SDID) REFERENCES hos_district(DID)
	
	/*创建房屋类型表*/
	CREATE TABLE hos_type
	(
	HTID INT identity(1,1) PRIMARY KEY,#房屋类型的Id
	HTName VARCHAR(20) NOT NULL #房屋类型名称
	)
	
	/*创建房屋信息表*/
	CREATE TABLE hos_house
	(
	HMID INT identity(1,1) PRIMARY KEY,#出租房屋编号
	UID INT NOT NULL #客户的编号
	SID INT NOT NULL,#街道的编号
	HTID INT NOT NULL,#房屋类型编号
	price DECIMAL NOT NULL,#每月的租金 
	TOPIC VARCHAR(20) NOT NULL,#标题
	contents VARCHAR(50) NOT NULL,#描述
	HTIME DATETIME NOT NULL,#发布时间
	COPY VARCHAR(20) #备注
	)

	#给hos_house表添加约束
	ALTER TABLE hos_house ADD CONSTRAINT FK_UID  FOREIGN KEY(UID) REFERENCES sys_user(UID)
	ALTER TABLE hos_house ADD CONSTRAINT FK_SID FOREIGN KEY(SID) REFERENCES hos_street(SID)
	ALTER TABLE hos_house ADD CONSTRAINT FK_HTID FOREIGN KEY(HTID) REFERENCES hos_type(HTID)
   	ALTER TABLE hos_house ADD CONSTRAINT CK_PRICE CHECK(PRICE>=0)
    	ALTER TABLE hos_house ADD CONSTRAINT DF_PRICE DEFAULT 0 FOR PRICE
	ALTER TABLE hos_house ADD CONSTRAINT CK_HTIME CHECK(HTIME<=GETDATE())
	ALTER TABLE hos_house ADD CONSTRAINT DF_HTIME DEFAULT GETDATE() FOR HTIME
	
	
#-----------------------添加测试数据------------------------------
/*向sys_user表中添加数据*/
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('张三','s217701')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('李四','s217702')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('王鑫','s217703')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('张建','s217704')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('李剑','s217705')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('蒋以然','s217706')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('王晓超','s217707')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('张冬雪','s217708')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('孙鹏','s217709')
INSERT INTO sys_user(UNAME,UPASSWORD) VALUES('蒋连昌','s217710')

#----------------向 区县信息表hos_district中添加数据----------------------
INSERT INTO hos_district (DNAME) VALUES('海淀区')
INSERT INTO hos_district (DNAME) VALUES('西城区')
INSERT INTO hos_district (DNAME) VALUES('东城区')
INSERT INTO hos_district (DNAME) VALUES('朝阳区')
INSERT INTO hos_district (DNAME) VALUES('景山区')
INSERT INTO hos_district (DNAME) VALUES('宣武区')
INSERT INTO hos_district (DNAME) VALUES('大兴')
INSERT INTO hos_district (DNAME) VALUES('丰台')
#go
#----------------向街道信息表hos_street中添加数据-------------------------
INSERT INTO hos_street (SNAME,SDID) VALUES('中关村',1)
INSERT INTO hos_street (SNAME,SDID) VALUES('苏州街',1)
INSERT INTO hos_street (SNAME,SDID) VALUES('万泉庄',1)
INSERT INTO hos_street (SNAME,SDID) VALUES('东四',3)
INSERT INTO hos_street (SNAME,SDID) VALUES('东单',3)
INSERT INTO hos_street (SNAME,SDID) VALUES('西四',2)
INSERT INTO hos_street (SNAME,SDID) VALUES('西单',2)
INSERT INTO hos_street (SNAME,SDID) VALUES('东湖',4)
INSERT INTO hos_street (SNAME,SDID) VALUES('八里庄',4)
INSERT INTO hos_street (SNAME,SDID) VALUES('双井',5)
INSERT INTO hos_street (SNAME,SDID) VALUES('陶然亭',5)
INSERT INTO hos_street (SNAME,SDID) VALUES('南菜园',6)
INSERT INTO hos_street (SNAME,SDID) VALUES('兴丰街',7)
INSERT INTO hos_street (SNAME,SDID) VALUES('黄村',7)
INSERT INTO hos_street (SNAME,SDID) VALUES('南苑街',8)
INSERT INTO hos_street (SNAME,SDID) VALUES('东铁营',8)
#go
#------------------表hos_type插入数据----------------------
INSERT INTO hos_type (HTNAME) VALUES('一室一卫')
INSERT INTO hos_type (HTNAME) VALUES('一室一厅')
INSERT INTO hos_type (HTNAME) VALUES('两室一卫')
INSERT INTO hos_type (HTNAME) VALUES('两室一厅')
INSERT INTO hos_type (HTNAME) VALUES('三室一厅')
INSERT INTO hos_type (HTNAME) VALUES('三室两厅')
#GO

#-------------------表hos_house插入数据--------------------------
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(1,1,2,2600,'中关村','中关村一条街','2009-1-2','中关村')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(2,2,3,3600,'苏州街','苏州街一条街','2009-1-3','苏州街')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(3,3,4,4600,'万泉庄','万泉庄一条街','2009-1-4','万泉庄')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(1,3,2,1500,'万泉庄附近','万泉庄附近一条街','2009-7-2','万泉庄附近')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(1,5,2,2700,'东单','东单很多美食','2009-9-2','东单')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(3,1,2,2600,'中关村','中关村电脑城','2009-4-1','中关村')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(4,4,1,2000,'东四','东四一条街','2009-4-2','东四')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(5,6,3,3600,'西四','西四一条街','2009-1-2','西四')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(5,7,2,3600,'西单','西单购物城','2009-4-2','西单')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(6,2,2,2600,'苏州街','苏州街美食','2009-2-2','苏州街')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(7,8,3,2900,'朝阳','朝阳东湖一景','2009-3-2','朝阳')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(8,3,1,700,'万泉庄','万泉庄一条街','2009-5-2','万泉庄')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(3,2,3,4200,'苏州街','苏州街二条街','2009-1-3','苏州街')
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(4,2,3,4100,'苏州街','苏州街西街','2009-1-3','苏州街')
#GO
