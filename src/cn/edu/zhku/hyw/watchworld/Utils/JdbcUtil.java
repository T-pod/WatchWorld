package cn.edu.zhku.hyw.watchworld.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	/**
	 * ��ȡ��ȡ���Ӷ���ķ���
	 */

	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String DBURL = 
			"jdbc:mysql://localhost:3306/watch-world?autoReconnection=true&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static final String DBUSER = "root";
	private static final String DBPWD = "";
	
	public static Connection getConn(){
		try {
			Class.forName(DRIVERNAME);
			Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �ͷ���Դ�ķ���
	 */
	public static void close(Connection conn,Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
