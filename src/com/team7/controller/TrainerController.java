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
		
		request.setCharacterEncoding("UTF-8");	//���� �߰���
		String RequestURI=request.getRequestURI();	//req ������ :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�տ� ���� ���� : boardList.bo
		//�� '/'���� �� ��������. 
		
		
		ActionForward forward=null;	//forward : �� �� ���� 
		Action action=null;	
		
		//action : �� �� ����  ��Ȯ���� action.execute()��. (�������̽��� ������)
		
		
//		HttpSession session = request.getSession(true);
//		int logined =0;
//		if(session.getAttribute("LOG_STATUS") ==null) {}
//		else {
//			logined=(Integer) session.getAttribute("LOG_STATUS");
//		}
//		
		
		HttpSession session = request.getSession(true);
		int logined= (Integer)session.getAttribute("LOG_STATUS"); //������Ʈ���������ִ�
		System.out.print("�α�������Ȯ��");
		
		
		if(command.startsWith("/id_") && logined !=1) {
			response.sendRedirect("Join_and_LogIn.jsp?fail=�α����� �ʿ��� �����Դϴ�. �α������ּ���. ");
			return;
		}
		System.out.print("�α���üũ");
		if(command.equals("/Mng.trainer")){	
			forward = new ActionForward(); // �� �� ��û���� �Ÿ� ������ �ض�.
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/introtrainer.jsp");
		   
		}
		if(command.equals("/id_coachapply.trainer")){	
			String id = (String)session.getAttribute("LOGIN");
			System.out.println("Ʈ���̳ʵ�Ϲ�ư����");
			forward = new ActionForward(); // �� �� ��û���� �Ÿ� ������ �ض�.
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");
		  
		}
		 if(command.equals("/id_trainerapply.trainer")) {
			 System.out.print("��ư���˾ƺ��ϳ��Ӥ���������");
			action  = new com.team7.trainer.action.TrainerCreateAction();
			System.out.print("d");
			try {
				forward=action.execute(request, response); //�޼��������
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}  //�Ұ� ���
		 if(command.equals("/id_trainermypage.trainer")) {
			 String id = (String)session.getAttribute("LOGIN");
			 
			 System.out.println("Ʈ���̳� ����������������");
			 action  = new com.team7.trainer.action.TrainerMypageAction();
				try {
					forward=action.execute(request, response); //�޼��������
				} catch (Exception e) {
					e.printStackTrace();
				}
//				forward = new ActionForward(); // �� �� ��û���� �Ÿ� ������ �ض�.
//				forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");
				
				
			}
		
		 if(command.equals("/Search.trainer")){	
			System.out.print("Ʈ���̳� ��ġ Ŭ���˴ϱ�");
			action  = new com.team7.trainer.action.TrainerShowAllAction();
			try {
				forward=action.execute(request, response); //�޼��������
			} catch (Exception e) {
				e.printStackTrace();
			}
//		  
		}
		
		 if(command.equals("/trainerUserpage.trainer")){	
				System.out.println("Ʈ���̳� ���������� Ŭ���˴ϱ�");
				action  = new com.team7.trainer.action.TrainerUserpageAction();
				try {
					forward=action.execute(request, response); //�޼��������
				} catch (Exception e) {
					e.printStackTrace();
				}
//			  
			}System.out.print("dddddd");

		System.out.println(command+"...dla..��");
		
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}//���� ������ ������
		

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