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
		int logined= (Integer)session.getAttribute("LOG_STATUS"); //오브젝트형식으로있다
		System.out.print("로그인최초확인");
		if(command.startsWith("/id_") && logined !=1) {
			response.sendRedirect("Join_and_LogIn.jsp?fail=로그인이 필요한 서비스입니다. 로그인해주세요. ");
			return;
		}
		System.out.print("로그인체크");
		if(command.equals("/id_MainToApply.trainer")){	
			String id = (String)session.getAttribute("LOGIN");
				
			
			forward = new ActionForward(); // 그 일 요청받은 거면 다음을 해라.
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");
		  
		}
		else if(command.equals("/id_trainerapply.trainer")) {
			action  = new com.team7.trainer.action.TrainerCreateAction();
			try {
				forward=action.execute(request, response); //메서드실행함
			} catch (Exception e) {
				e.printStackTrace();
			}
		}  //할거 담기
		
		if(command.equals("/Search.trainer")){	
			action  = new com.team7.trainer.action.TrainerCreateAction();
			forward = new ActionForward(); // 그 일 요청받은 거면 다음을 해라.
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/TrainerShowAll.jsp");
		  
		}

		
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}//가서 페이지 보내기

}
}