package com.team7.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.notice.action.Action;
import com.team7.vo.ActionForward;


@WebServlet("*.notice")
public class NoticeController extends javax.servlet.http.HttpServlet 
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
		
		if(command.equals("/noticeshow.notice")){	// �� �� ��û���� �Ÿ� ������ �ض�.
			action  = new com.team7.notice.action.NoticeListShowAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/showme.notice")) {
			action  = new com.team7.notice.action.NoticeSelectedAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/write.notice")) {
			action  = new com.team7.notice.action.NoticeWriteAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/edit.notice")) {
			action  = new com.team7.notice.action.NoticeEditAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete.notice")) {
			action  = new com.team7.notice.action.NoticeDeleteAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/qna.notice")) {
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=8others/QnAs.jsp");
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