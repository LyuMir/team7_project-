<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><%@ page import="java.sql.*"  %><%@ page import="java.util.ArrayList"  %><%
		String input1 =  request.getParameter("input1");
		String okgo ="123";

		Connection cx = null;
		Statement smt = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/team7","root","qwer1234!");
			if( cx ==null)
				throw new Exception("! 데이터베이스 연결 불가!"); 


			smt = cx.createStatement();
			ResultSet rs = smt.executeQuery("select * from team7_member where email = '"+input1+"'");

			if(!rs.next())
				okgo = "okgo";

		}
		finally{
			try{
				smt.close(); //클로즈는 꼭 해줍시다. 
			}
			catch(Exception ignored){}
			try{
				cx.close(); //클로즈!! 둘 다 꼭!! 순서대로!
			}
			catch(Exception ignored){}
		}
%><%= okgo %>