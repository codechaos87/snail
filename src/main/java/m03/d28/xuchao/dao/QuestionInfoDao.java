/**
 * Project Name:DT59Team5
 * File Name:QuestionInfoDao.java
 * Package Name:m03.d28.xuchao.dao
 * Date:2018年3月28日下午2:14:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.xuchao.dao;

import java.util.Scanner;

/**
 * Description:   接口 降低藕合性<br/>
 * Date:     2018年3月28日 下午2:14:45 <br/>
 * @author   chaos
 * @version
 * @see
 */
public interface QuestionInfoDao {
    void getAllInfo();
    void getSubjectInfo(Scanner input);
    void getMohuInfo(Scanner input);
    void update(Scanner input);
    int delete(int questionId);
}

