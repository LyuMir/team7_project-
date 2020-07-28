package dbconn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {	//meta inf 에 있는 애들로 사옵니다. (프로젝트 관련 인포

	public static Connection getConnection(){
		Connection con=null;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");	//lookup 찾아라
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQ2");	// context.xml의 name을 일치시켜서 가져옵니다. 
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con){

		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt){

		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs){

		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void commit(Connection con){

		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void rollback(Connection con){

		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
