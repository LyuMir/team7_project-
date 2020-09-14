package com.team7.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.member.action.MyInfoAction;
import com.team7.notice.action.Action;
import com.team7.vo.ActionForward;


@WebServlet("*.mypage")
public class MypageController extends javax.servlet.http.HttpServlet 
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
		int logyn =0;
		HttpSession session = request.getSession();
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logyn=(Integer) session.getAttribute("LOG_STATUS");
		}
		
		if(command.contains("id_") && logyn !=1) {

			String referer = request.getHeader("Referer");
			if(referer.contains("/id_")) {
				referer = "index.jsp";
			}
			else {
				request.getSession().setAttribute("fail", "로그인이 필요한 서비스입니다. 로그인해주세요!");
			}
			response.sendRedirect(referer);
			
			return;
		}
//		if(command.equals("/noticeshow.notice")){	// 그 일 요청받은 거면 다음을 해라.
//			action  = new com.team7.notice.action.NoticeListShowAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		if(command.equals("/id_myinfo.mypage")) {
			new MyInfoAction().toMyInfoPage(request, response);
		}
		
		
		else if(command.equals("/myhealthzzim.mypage")) {
			new MyInfoAction().toMyHealthZzimPage(request, response);
		}
		else if(command.equals("/mytrainerzzim.mypage")) {
			new MyInfoAction().toMyHealthZzimPage(request, response);
		}
		
		else if(command.equals("/edit.notice")) {
			action  = new com.team7.notice.action.NoticeEditAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete.notice")) {
			action  = new com.team7.notice.action.NoticeDeleteAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
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