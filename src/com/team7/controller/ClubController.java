package com.team7.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.action.Action;
import com.team7.vo.ActionForward;

@WebServlet("*.club")
public class ClubController extends javax.servlet.http.HttpServlet 
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
		
		if(command.equals("/MainInfo.club")){	// �� �� ��û���� �Ÿ� ������ �ض�.
//			action  = new com.team7.club.action.MainAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("");
		}
		else if(command.equals("/Search.club")){	// �� �� ��û���� �Ÿ� ������ �ض�.
			//action  = new com.team7.club.action.ClubSearchAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
//			forward = new ActionForward();
//			forward.setPath("_FORWHERE.jsp?forwhere=club_createNedit.jsp");
		}
		else if(command.equals("/Mng.club")){	// �� �� ��û���� �Ÿ� ������ �ض�.
//			action  = new com.team7.club.action.ManageAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=club_myClubs.jsp");
		}
		else if(command.equals("/my.club")){	// �� �� ��û���� �Ÿ� ������ �ض�.
//			action  = new com.team7.club.action.MypageAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=club_myClubs.jsp");
		}
		else if(command.equals("/toMain.club")){	// �� �� ��û���� �Ÿ� ������ �ض�.
//			action  = new com.team7.club.action.MypageAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=club_main.jsp");
		}
		

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