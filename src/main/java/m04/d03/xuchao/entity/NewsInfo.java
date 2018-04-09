/**
 * Project Name:dt59_jsp_news
 * File Name:NewsInfo.java
 * Package Name:main.java.entity
 * Date:2018年4月7日下午9:25:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m04.d03.xuchao.entity;

/**
 * Description: <br/>
 * Date: 2018年4月7日 下午9:25:11 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class NewsInfo {
    private int newsId;

    private int typeId;

    private String newsTitle;

    private String newsAuthor;

    private String newsSummary;

    private String newsContent;

    private String newsPic;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public String getNewsSummary() {
        return newsSummary;
    }

    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsPic() {
        return newsPic;
    }

    public void setNewsPic(String newsPic) {
        this.newsPic = newsPic;
    }

}
