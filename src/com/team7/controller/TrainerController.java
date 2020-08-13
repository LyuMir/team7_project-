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
		
		HttpSession session = request.getSession(true);
		int logined =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logined=(Integer) session.getAttribute("LOG_STATUS");
		}
		
		if(command.startsWith("/id_") && logined !=1) {
			request.getSession().setAttribute("fail", "�α����� �ʿ��� �����Դϴ�, �α������ּ���.");
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
			return;
		}
		else if(command.equals("/id_Introtrainerapply.trainer")){
			System.out.println("������� ������ ���ô�. ");
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/introtrainer.jsp");
		}
		else if(command.equals("/id_coachapply.trainer")){	
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");

		}
		else if(command.equals("/id_coachapply.trainer")){	
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");
		}
		else if(command.equals("/id_trainerapply.trainer")) {
			action  = new com.team7.trainer.action.TrainerCreateAction();
			try {
				forward=action.execute(request, response); //�޼��������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Search.trainer")){	
			action  = new com.team7.trainer.action.TrainerShowAllAction();
			try {
				forward=action.execute(request, response); //�޼��������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/trainerUserpage.trainer")){	
				action  = new com.team7.trainer.action.TrainerUserpageAction();
				try {
					forward=action.execute(request, response); //�޼��������
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		else if(command.equals("/id_mypage.trainer")) {
				action  = new com.team7.trainer.action.TrainerMypageAction();
				System.out.print("d");
				try {
					forward=action.execute(request, response); //�޼��������
				} catch (Exception e) {
					e.printStackTrace();
				}
		} 

		System.out.println(command+"...������ ������ in trainer");
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