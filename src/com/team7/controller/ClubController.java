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

@WebServlet("*.club")
public class ClubController extends javax.servlet.http.HttpServlet 
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
		if(command.startsWith("/id_") && logined !=1) {
			//id�� �ʿ��ϸ� login�� �� �Ǿ�������
			response.setCharacterEncoding("utf-8");
			//response.sendRedirect("Join_and_LogIn.jsp?fail=�α����� �ʿ��� �����Դϴ�. �α������ּ���. ");
			// sendRe �� �ѱ۱�������. 
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("Join_and_LogIn.jsp?fail=�α����� �ʿ��� �����Դϴ�. �α������ּ���. ");
			dispatcher.forward(request, response);
			return;	//���⿡ �ɸ��� �ؿ� �������� �������� �ʽ��ϴ�... sendRedirect�� ������ ���� �ȵǰ�����, Ȥ�� �𸣴ϱ�. 
		}
		
		
		if(command.equals("/MainInfo.club")){
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=3club/club_intro.jsp");
		}
		else if(command.equals("/Search.club")){	
			action  = new com.team7.club.action.ClubShowAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/id_Mng.club")){	// �� �� ��û���� �Ÿ� ������ �ض�.
			action  = new com.team7.club.action.ClubManageAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/id_my.club")){
			action  = new com.team7.club.action.MypageAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/create.club")){
			action  = new com.team7.club.action.ClubCreateAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/edit.club")){
			action  = new com.team7.club.action.ClubEditAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Delete.club")){
			action  = new com.team7.club.action.ClubDeleteAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/manage.club")){
			action  = new com.team7.club.action.ClubEnrollAction();	//clubid
			//System.out.println("sdfsd");
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/toClubMain.club")){
			action  = new com.team7.club.action.ClubPageAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		else if(command.equals("/clubName.club")){
//			action  = new com.team7.club.action.ClubNameAction();
//			System.out.println("�����?");
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

		if(forward != null){	//������ ���� �ִٸ� ����. \
			if(forward.getPath()==null) {
				forward.setPath("/index.jsp");
			}
			if(forward.getPath().equals("")) {
				forward.setPath("/index.jsp");
			}
			if(forward.getPath().startsWith("\\")) {
				forward.setPath(forward.getPath().substring(1));
				System.out.println(forward.getPath()+"�ʿ� �ұ�?");
			}

			System.out.println(forward.getPath()+"���� ���ϴ�...");
			
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