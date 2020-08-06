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

@WebServlet("*.zzim")
public class ZzimController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
		
		// ajax를 이용할 거니까 이걸 여기에서 할 수는 없는 것이다...
//		HttpSession session = request.getSession(true);
//		int logined =0;
//		if(session.getAttribute("LOG_STATUS") ==null) {}
//		else {
//			logined=(Integer) session.getAttribute("LOG_STATUS");
//		}
		//반드시 로그인 필요 
//System.out.println("로그인 하라고 하나?"+logined);
//		if(logined !=1) {
//			response.setCharacterEncoding("utf-8");
//			RequestDispatcher dispatcher=
//					request.getRequestDispatcher("Join_and_LogIn.jsp?fail=로그인이 필요한 서비스입니다. 로그인해주세요. ");
//			dispatcher.forward(request, response);
//			return;	
//		}
		
		if(command.equals("/club.zzim")) {
			System.out.println("클럽 찜합니다. ");
			new Zzim_Club_Actions().clubZ(request, response);
		}
		else if(command.equals("/club_drop.zzim")) {
			System.out.println("클럽 찜 취소");
			new Zzim_Club_Actions().clubZ_cancle(request, response);
		}
		else if(command.equals("/clubPost.zzim")) {
			System.out.println("소모임 게시글 찜");
			//
		}
		else if(command.equals("/clubPost_cancle.zzim")) {
			System.out.println("소모임 게시글 찜 취소");
			
		}
		else if(command.equals("/")) {
			System.out.println("");
			
		}
//		
//		if(command.equals("/MainInfo.club")){
//			forward = new ActionForward();
//			forward.setPath("_FORWHERE.jsp?forwhere=3club/club_intro.jsp");
//		}
//		else if(command.equals("/Search.club")){	
//			action  = new com.team7.club.action.ClubShowAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
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