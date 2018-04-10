/**
 * Project Name:snail
 * File Name:QuestionInfoDao.java
 * Package Name:m03.d28.guojin
 * Date:2018年3月28日下午4:31:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.guojin;

import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:31:50 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    List<QuestionInfo> getAllInfo();

    int updateInfo(T t);

    int deleteInfo(int id);

    List<QuestionInfo> getSubject1();

    List<QuestionInfo> getSubject2();

    List<QuestionInfo> getSubject3();

    List<QuestionInfo> getAllInfo1();
}
