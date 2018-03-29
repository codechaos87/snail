/**
 * Project Name:DT59Team5
 * File Name:QuestionInfoDao.java
 * Package Name:m03.d28.xuchao.dao
 * Date:2018年3月28日下午2:14:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.xuchao.dao;

import java.util.List;

import m03.d29.xuchao.entity.QuestionInfo;

/**
 * Description:   接口 降低藕合性<br/>
 * Date:     2018年3月28日 下午2:14:45 <br/>
 * @author   chaos
 * @version
 * @see
 */
public interface QuestionInfoDao {
    List<QuestionInfo> getAllInfo();
    List<QuestionInfo> getSubjectInfo(int qsubject);
    List<QuestionInfo> getMohuInfo(String question);
    int update(Object[] obj);
    int delete(int questionId);
}

