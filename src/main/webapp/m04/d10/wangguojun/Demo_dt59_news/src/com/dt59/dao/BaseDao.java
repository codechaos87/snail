package com.dt59.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class BaseDao {
	protected Connection con=null;//����ͨ��
	protected PreparedStatement pst=null;//Ԥ����
	protected ResultSet rs=null;//���
	protected CallableStatement cstate=null;//���ô洢��̵Ľӿ�

    protected DataSource ds = null;

	/**
	 * 	@see ��ʼ����ݿ����ӵ�
	 * */

	//���ӷ���
	public Connection getCon(){
		try {
            // Class.forName(driver);
            // con= DriverManager.getConnection(url, username, userpwd);
            Context ctx = (Context) new InitialContext();
            ds = (DataSource) ((InitialContext) ctx).lookup("java:/comp/env/second");
            con = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	//�رյķ���
	public void close(Connection con,PreparedStatement pst,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pst!=null){
				pst.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
