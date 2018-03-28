/**
 * Project Name:wangguojun
 * File Name:Dao.java
 * Package Name:dao
 * Date:2018年3月28日下午5:22:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.wangguojun.dao;

import java.util.List;

import m03.d28.xuchao.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:22:34 <br/>
 * 
 * @author wangguojun
 * @version
 * @param <QuestionInfo>
 * @param <Questionlnfo>
 * @see
 */
public interface Dao<T> {

    List<QuestionInfo> getAllQuestionInfo();

    int updateQuestionInfo(T t);

    int deleteQuestionInfo(int id);

    int saveInQuestionInfo(T t);

}

