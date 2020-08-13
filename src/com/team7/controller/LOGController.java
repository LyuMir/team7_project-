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
import com.team7.member.action.MyInfoAction;
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
		HttpSession session = request.getSession();
		int logyn =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logyn=(Integer) session.getAttribute("LOG_STATUS");
		}
		
		if(command.contains("myinfo") && logyn !=1) {

			request.getSession().setAttribute("fail", "�α����� �ʿ��� �����Դϴ�!");
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
			
			return;
		}
		
		
		if(command.equals("/join.log")){	// �� �� ��û���� �Ÿ� ������ �ض�.
			action  = new com.team7.member.action.JoinAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/login.log")){
			
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
		else if(command.equals("/forgot.log")) {
			new com.team7.member.action.PWFindAction().pwfinder(request, response);
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		else if(command.equals("/myinfo.log")) {
			new MyInfoAction().toMyInfoPage(request, response);
		}
		
		else if(command.equals("/editmyinfo.log")) {
			new MyInfoAction().infoEdit(request, response);
		}


		if(forward != null){	//������ ���� �ִٸ� ����. \
			//�Ⱥ���. ���ΰ�ħ ��ų����. 

//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
////			out.println("alert('�߸��� ��� : �̹� ���ԵǾ��ִ� �Ҹ����Դϴ�. ')");
////			out.println("location.reload(true);");
//			out.println("history.back();");
//			
//			out.println("</script>");
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
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