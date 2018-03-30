/**
 * Project Name:snail
 * File Name:QuestionInfoDao.java
 * Package Name:m03.d28.chenyang
 * Date:2018年3月28日下午4:41:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.chenyang;

import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:41:55 <br/>
 * @author   chenyang
 * @version
 * @see
 */
public interface QuestionInfoDao {
    List<QuestionInfo> getALLInfo();
     
    List<QuestionInfo> selectS(int subject);
    
    QuestionInfo selectQ(int questionId);
    
    int delectQ(int questionId);
    
    int saveQ(QuestionInfo question);
    
    List<QuestionInfo> mohu(String str);
}

