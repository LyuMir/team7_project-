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
		
		//request.setCharacterEncoding("UTF-8");	//���� �߰���
		String RequestURI=request.getRequestURI();	//req ������ :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�տ� ���� ���� : boardList.bo
		//�� '/'���� �� ��������. 
		
		
		ActionForward forward=null;	//forward : �� �� ���� 
		Action action=null;			//action : �� �� ����  ��Ȯ���� action.execute()��. (�������̽��� ������)

		HttpSession session = request.getSession(true);
		int logined =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logined=(Integer) session.getAttribute("LOG_STATUS");
		}
		System.out.println("����� ����Ӥ�");

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
		

//		//������ ���� �ٷ� �ű���.. 
//		if(gobackRefresh) {	//���ΰ�ħ
//			String referer = request.getHeader("Referer");
//			response.sendRedirect(referer);	// ��! �ٽ� ���ΰ�ħ!
//			
//		}
//		else {		//�׳� �ڷθ�. 
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("history.back();");
//			out.println("</script>");
//		}
		//ajax�� �� ����...?
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //���� �߰���
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //���� �߰���
		doProcess(request,response);
	}   
	
}