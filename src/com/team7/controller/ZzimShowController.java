package com.team7.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.action.Action;
import com.team7.vo.ActionForward;
import com.team7.zzim.action.Zzim_Club_Actions;
import com.team7.zzim.action.Zzim_Show_Actions;

@WebServlet("*.zzimshow")
public class ZzimShowController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
//		System.out.println(RequestURI);
//		System.out.println(contextPath);

		HttpSession session = request.getSession(true);

//		System.out.println("여기까지 오나??");
		
		
		if(command.equals("/club.zzimshow")) {
			System.out.println("클럽 찜 보여줘."+request.getParameter("clubid"));
			new Zzim_Show_Actions().club_show(request, response);;
		}
//		else if(command.equals("/club_drop.zzimshow")) {
//			System.out.println("클럽 찜 취소");
//			new Zzim_Club_Actions().clubZ_cancle(request, response);
//		}

			//해당 페이지에서만 놀거임. 

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}   
	
}