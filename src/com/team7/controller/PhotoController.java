package com.team7.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.action.Action;
import com.team7.photo.action.GymPhotoAction;
import com.team7.photo.action.TrainerPhotoAction;
import com.team7.photo.service.PhotoClubService;
import com.team7.post.action.PostActions;
import com.team7.vo.ActionForward;

@WebServlet("*.photo")
public class PhotoController extends javax.servlet.http.HttpServlet 
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
		System.out.println("여기다 여기ㅣㅣ");

		if(command.equals("/trainerUpload.photo")){
			new TrainerPhotoAction().photoUpload(request, response);
		}
		else if(command.equals("/gymUpload.photo")) {
			new GymPhotoAction().photoUpload(request, response);
		}
		else if(command.equals("/trainerSelect.photo")) {
			new TrainerPhotoAction().photoget(request, response);
		}
		else if(command.equals("/gymSelect.photo")) {
			new TrainerPhotoAction().photoget(request, response);
		}
		

//		//가야할 곳은 바로 거기임.. 
//		if(gobackRefresh) {	//새로고침
//			String referer = request.getHeader("Referer");
//			response.sendRedirect(referer);	// 자! 다시 새로고침!
//			
//		}
//		else {		//그냥 뒤로만. 
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("history.back();");
//			out.println("</script>");
//		}
		//ajax라서 안 쓸걸...?
		
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