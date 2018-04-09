package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

	public boolean validateUser(UserInfo user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM user_info a WHERE a.`username`=? AND a.`password`=?";
			pst=getCon().prepareStatement(sql);
			//¸³Öµ
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			//Ö´ÐÐ
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

	public List<NewsInfo> getNews() {
		// TODO Auto-generated method stub
		List<NewsInfo> listnews=new ArrayList<NewsInfo>();
		try {
			String sql="SELECT * FROM news_info";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				NewsInfo info=new NewsInfo();
				info.setNewsid(rs.getInt(1));
				info.setTypeid(rs.getInt(2));
				info.setNewstitle(rs.getString(3));
				info.setNewsauthor(rs.getString(4));
				info.setNewssummary(rs.getString(5));
				info.setNewscontent(rs.getString(6));
				info.setNewspic(rs.getString(7));
				listnews.add(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listnews;
	}

	public int delNewsInfoById(int id) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="DELETE FROM news_info WHERE news_id=?";
			pst=getCon().prepareStatement(sql);
			pst.setInt(1, id);
			flag= pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

	public int updateNewsInfo(NewsInfo info) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="UPDATE news_info SET type_id=?,news_title=?,news_author=?,news_summary=?,news_content=? WHERE news_id=?";
			pst=getCon().prepareStatement(sql);
			pst.setInt(1, info.getTypeid());
			pst.setString(2, info.getNewstitle());
			pst.setString(3, info.getNewsauthor());
			pst.setString(4, info.getNewssummary());
			pst.setString(5, info.getNewscontent());
			pst.setInt(6, info.getNewsid());
			flag=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

	public List<CommentInfo> getAllCommentInfo() {
		// TODO Auto-generated method stub
		List<CommentInfo> listc=new ArrayList<CommentInfo>();
		try {
			String sql="SELECT * FROM comment_info";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				CommentInfo cinfo=new CommentInfo();
				cinfo.setCommentid(rs.getInt(1));
				cinfo.setUsername(rs.getString(2));
				cinfo.setIp(rs.getString(3));
				cinfo.setContent(rs.getString(4));
				cinfo.setNewsid(rs.getInt(5));
				cinfo.setFbtime(rs.getDate(6));
				listc.add(cinfo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listc;
	}

	
}
