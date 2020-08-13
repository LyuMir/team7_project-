package com.team7.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.trainer.action.Action;
import com.team7.vo.ActionForward;


@WebServlet("*.trainer")
public class TrainerController extends javax.servlet.http.HttpServlet  {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
		
		
		ActionForward forward=null;	//forward : 갈 곳 지정 
		Action action=null;	
		
		//action : 할 일 지정  정확히는 action.execute()로. (인터페이스로 구성함)
		
		HttpSession session = request.getSession(true);
		int logined =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logined=(Integer) session.getAttribute("LOG_STATUS");
		}
		
		if(command.startsWith("/id_") && logined !=1) {
			request.getSession().setAttribute("fail", "로그인이 필요한 서비스입니다, 로그인해주세요.");
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
			return;
		}
		else if(command.equals("/id_Introtrainerapply.trainer")){
			System.out.println("여기까지 오는지 봅시다. ");
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/introtrainer.jsp");
		}
		else if(command.equals("/id_coachapply.trainer")){	
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");

		}
		else if(command.equals("/id_coachapply.trainer")){	
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");
		}
		else if(command.equals("/id_trainerapply.trainer")) {
			action  = new com.team7.trainer.action.TrainerCreateAction();
			try {
				forward=action.execute(request, response); //메서드실행함
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Search.trainer")){	
			action  = new com.team7.trainer.action.TrainerShowAllAction();
			try {
				forward=action.execute(request, response); //메서드실행함
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/trainerUserpage.trainer")){	
				action  = new com.team7.trainer.action.TrainerUserpageAction();
				try {
					forward=action.execute(request, response); //메서드실행함
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		else if(command.equals("/id_mypage.trainer")) {
				action  = new com.team7.trainer.action.TrainerMypageAction();
				System.out.print("d");
				try {
					forward=action.execute(request, response); //메서드실행함
				} catch (Exception e) {
					e.printStackTrace();
				}
		} 

		System.out.println(command+"...보내는 페이지 in trainer");
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}//가서 페이지 보내기
		

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