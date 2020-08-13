package com.team7.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.action.Action;
import com.team7.vo.ActionForward;


@WebServlet("*.health")
public class HealthController extends javax.servlet.http.HttpServlet  {
	
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
//		
		
//		HttpSession session = request.getSession(true);
//		int logined= (Integer)session.getAttribute("LOG_STATUS"); //오브젝트형식으로있다
		
		
		
		
		if(command.startsWith("/id_") && logined !=1) {
			String referer = request.getHeader("Referer");
			if(referer.contains("/id_")) {
				referer = "index.jsp";
			}
			else {
				request.getSession().setAttribute("fail", "로그인이 필요한 서비스입니다, 로그인해주세요.");
			}
			response.sendRedirect(referer);
			return;
		}
		else if(command.equals("/Mng.health")){	
			forward = new ActionForward(); 
			forward.setPath("_FORWHERE.jsp?forwhere=4health/introhealth.jsp");
		}
		else if(command.equals("/id_gymapply.health")){
			forward = new ActionForward(); 
			forward.setPath("_FORWHERE.jsp?forwhere=4health/gym_Apply.jsp");
		}
		else if(command.equals("/id_gymcreate.health")) {
			action  = new com.team7.gym.action.GymCreateAction();
			System.out.print("d");
			try {
				forward=action.execute(request, response); //메서드실행함
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Search.health")){	
			System.out.print("짐 서치 클릭됩니까");
			action  = new com.team7.gym.action.GymShowAllAction();
			try {
				forward=action.execute(request, response); //메서드실행함
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/GymUserpage.health")){	
				System.out.println("헬스장 개인페이지 클릭됩니까");
				action  = new com.team7.gym.action.GymUserpageAction();
				try {
					forward=action.execute(request, response); //메서드실행함
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		System.out.println(command+"...갑닏아 / gym.");
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