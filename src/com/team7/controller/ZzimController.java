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
		
		request.setCharacterEncoding("UTF-8");	//���� �߰���
		String RequestURI=request.getRequestURI();	//req ������ :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�տ� ���� ���� : boardList.bo
		//�� '/'���� �� ��������. 
		
		// ajax�� �̿��� �Ŵϱ� �̰� ���⿡�� �� ���� ���� ���̴�...
//		HttpSession session = request.getSession(true);
//		int logined =0;
//		if(session.getAttribute("LOG_STATUS") ==null) {}
//		else {
//			logined=(Integer) session.getAttribute("LOG_STATUS");
//		}
		//�ݵ�� �α��� �ʿ� 
//System.out.println("�α��� �϶�� �ϳ�?"+logined);
//		if(logined !=1) {
//			response.setCharacterEncoding("utf-8");
//			RequestDispatcher dispatcher=
//					request.getRequestDispatcher("Join_and_LogIn.jsp?fail=�α����� �ʿ��� �����Դϴ�. �α������ּ���. ");
//			dispatcher.forward(request, response);
//			return;	
//		}
		
		if(command.equals("/club.zzim")) {
			System.out.println("Ŭ�� ���մϴ�. ");
			new Zzim_Club_Actions().clubZ(request, response);
		}
		else if(command.equals("/club_drop.zzim")) {
			System.out.println("Ŭ�� �� ���");
			new Zzim_Club_Actions().clubZ_cancle(request, response);
		}
		else if(command.equals("/clubPost.zzim")) {
			System.out.println("�Ҹ��� �Խñ� ��");
			//
		}
		else if(command.equals("/clubPost_cancle.zzim")) {
			System.out.println("�Ҹ��� �Խñ� �� ���");
			
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

			//�ش� ������������ �����. 

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