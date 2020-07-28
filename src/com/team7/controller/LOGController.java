package com.team7.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.member.action.Action;
import com.team7.vo.ActionForward;

@WebServlet("*.log")
public class LOGController extends javax.servlet.http.HttpServlet 
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//���� �߰���
		String RequestURI=request.getRequestURI();	//req ������ :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�տ� ���� ���� : boardList.bo
		//�� '/'���� �� ��������. 
		ActionForward forward=null;	//forward : �� �� ���� 
		Action action=null;			//action : �� �� ����  ��Ȯ���� action.execute()��. (�������̽��� ������)
		
		if(command.equals("/join.log")){	// �� �� ��û���� �Ÿ� ������ �ض�.
			action  = new com.team7.member.action.JoinAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/login.log")){
			
			if(request.getParameter("log_id2").equals("")) {
				System.out.println("�ț��� �Ѥ�");
				forward=new ActionForward();
				forward.setPath("Join_and_LogIn.jsp");
				return;	//���� 
			}
			System.out.println("�������?");
			System.out.println(request.getParameter("log_id2"));
			
			action  = new com.team7.member.action.LoginAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.log")){
			action  = new com.team7.member.action.LogoutAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null){	//������ ���� �ִٸ� ����. 
			
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
		response.setContentType("text/html; charset=utf-8"); //���� �߰���
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //���� �߰���
		doProcess(request,response);
	}   
	
}