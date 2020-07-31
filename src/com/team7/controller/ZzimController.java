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

@WebServlet("*.zzim")
public class ZzimController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
		
		
		ActionForward forward=null;	//forward : 갈 곳 지정 
		Action action=null;			//action : 할 일 지정  정확히는 action.execute()로. (인터페이스로 구성함)

		HttpSession session = request.getSession(true);
		int logined =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logined=(Integer) session.getAttribute("LOG_STATUS");
		}
//		if(command.startsWith("/id_") && logined !=1) {
//			//id가 필요하며 login이 안 되어있을시
//			response.setCharacterEncoding("utf-8");
//			//response.sendRedirect("Join_and_LogIn.jsp?fail=로그인이 필요한 서비스입니다. 로그인해주세요. ");
//			// sendRe 의 한글깨짐문제. 
//			RequestDispatcher dispatcher=
//					request.getRequestDispatcher("Join_and_LogIn.jsp?fail=로그인이 필요한 서비스입니다. 로그인해주세요. ");
//			dispatcher.forward(request, response);
//			return;	//여기에 걸리면 밑에 구문들은 실행하지 않습니다... sendRedirect라서 어차피 실행 안되겠지만, 혹시 모르니까. 
//		}

		if(logined !=1) {
			response.setCharacterEncoding("utf-8");
			
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
//		if(forward != null){	//가야할 곳이 있다면 보냄. \
//			if(forward.getPath()==null) {
//				forward.setPath("/index.jsp");
//			}
//			if(forward.getPath().equals("")) {
//				forward.setPath("/index.jsp");
//			}
//			if(forward.getPath().startsWith("\\")) {
//				forward.setPath(forward.getPath().substring(1));
//				System.out.println(forward.getPath()+"필요 할까?");
//			}
//
//			System.out.println(forward.getPath()+"으로 갑니다...");
//			
//			if(forward.isRedirect()){
//				response.sendRedirect(forward.getPath());
//			}else{
//				RequestDispatcher dispatcher=
//						request.getRequestDispatcher(forward.getPath());
//				dispatcher.forward(request, response);
//			}
//		}
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