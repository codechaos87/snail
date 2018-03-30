/**
 * Project Name:jdbc_01
 * File Name:info2.java
 * Package Name:com.class1.dao.entity
 * Date:2018年3月28日下午4:15:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.class1.dao.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:15:10 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class Info2 {
        private int id;
        private String name;
        private Date  birthday;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Date getBirthday() {
            return birthday;
        }
        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
        
}

