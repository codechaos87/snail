package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;

public class BizDaoImpl extends BaseDao implements BizDao{

	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		List<News> listnews=new ArrayList<News>();
		try {
			String sql="SELECT * FROM news";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				News ns=new News();
				ns.setNid(rs.getInt(1));
				ns.setNtitle(rs.getString(2));
				ns.setNcontent(rs.getString(3));
				ns.setNdate(rs.getDate(4));
				listnews.add(ns);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listnews;
	}

	public List<Product> getAllProduct() {
		List<Product> listpro=new ArrayList<Product>();
		try {
			String sql="SELECT * FROM product";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setPid(rs.getInt(1));
				pro.setPname(rs.getString(2));
				pro.setPbrand(rs.getString(3));
				pro.setPmodel(rs.getString(4));
				pro.setPprice(rs.getDouble(5));
				pro.setPpicture(rs.getString(6));
				pro.setPdesc(rs.getString(7));
				listpro.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listpro;
	}

	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
			pst= getCon().prepareStatement(sql);
			pst.setString(1, user.getUname());
			pst.setString(2, user.getUpwd());
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

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> listUser=new ArrayList<User>();
		try {
			String sql="SELECT * FROM USER";
			pst= getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				user.setUstatus(rs.getString(4));
				user.setUpic(rs.getString(5));
				listUser.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listUser;
	}

	public String getUserRoleByName(String name, String pwd) {
		// TODO Auto-generated method stub
		String role="";
		try {
			String sql="SELECT t.`ustatus` FROM USER t WHERE t.`uname`=? AND t.`upwd`=?";
			pst=getCon().prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pwd);
			rs=pst.executeQuery();
			while(rs.next()){
				role=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return role;
	}

	public List<Product> getAllProductByPage(Page page) {
		// TODO Auto-generated method stub
		List<Product> listpro=new ArrayList<Product>();
		try {
			String sql="SELECT * FROM product LIMIT ?,?";
			pst=getCon().prepareStatement(sql);
			pst.setInt(1, (page.getCurrentpage()-1)*page.getPagesize());
			pst.setInt(2, page.getPagesize());
			rs=pst.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setPid(rs.getInt(1));
				pro.setPname(rs.getString(2));
				pro.setPbrand(rs.getString(3));
				pro.setPmodel(rs.getString(4));
				pro.setPprice(rs.getDouble(5));
				pro.setPpicture(rs.getString(6));
				pro.setPdesc(rs.getString(7));
				listpro.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listpro;
	}

	public int getProductNumber() {
		// TODO Auto-generated method stub
		int count=0;
		try {
			String sql="SELECT COUNT(1) FROM product";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return count;
	}

    @Override
    public List<Message> getAllMessages() {

        // Auto-generated method stub
        List<Message> listmessage = new ArrayList<Message>();
        try {
            String sql = "SELECT * FROM message";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Message me = new Message();
                me.setMid(rs.getInt(1));
                me.setMtitle(rs.getString(2));
                me.setMcontent(rs.getString(3));
                me.setMname(rs.getString(4));
                me.setMdate(rs.getDate(5));
                me.setRcount(rs.getInt(6));
                listmessage.add(me);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listmessage;
    }

}
