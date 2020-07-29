package com.team7.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.action.Action;
import com.team7.vo.ActionForward;

@WebServlet("*.club")
public class ClubController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
		
		
		ActionForward forward=null;	//forward : 갈 곳 지정 
		Action action=null;			//action : 할 일 지정  정확히는 action.execute()로. (인터페이스로 구성함)
		
		if(command.equals("/MainInfo.club")){	// 그 일 요청받은 거면 다음을 해라.
//			action  = new com.team7.club.action.MainAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("");
		}
		else if(command.equals("/Search.club")){	// 그 일 요청받은 거면 다음을 해라.
			//action  = new com.team7.club.action.ClubSearchAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
//			forward = new ActionForward();
//			forward.setPath("_FORWHERE.jsp?forwhere=club_createNedit.jsp");
		}
		else if(command.equals("/Mng.club")){	// 그 일 요청받은 거면 다음을 해라.
//			action  = new com.team7.club.action.ManageAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=club_myClubs.jsp");
		}
		else if(command.equals("/my.club")){	// 그 일 요청받은 거면 다음을 해라.
//			action  = new com.team7.club.action.MypageAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=club_myClubs.jsp");
		}
		else if(command.equals("/toMain.club")){	// 그 일 요청받은 거면 다음을 해라.
//			action  = new com.team7.club.action.MypageAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=club_main.jsp");
		}
		

		if(forward != null){	//가야할 곳이 있다면 보냄. \
			if(forward.getPath()==null) {
				forward.setPath("/index.jsp");
			}
			if(forward.getPath().equals("")) {
				forward.setPath("/index.jsp");
			}
			if(forward.getPath().startsWith("\\")) {
				forward.setPath(forward.getPath().substring(1));
				System.out.println(forward.getPath()+"필요 할까?");
			}

			System.out.println(forward.getPath()+"으로 갑니다...");
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
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