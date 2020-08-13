package com.team7.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.action.Action;
import com.team7.vo.ActionForward;


@WebServlet("*.health")
public class HealthController extends javax.servlet.http.HttpServlet  {
	
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
//		
		
//		HttpSession session = request.getSession(true);
//		int logined= (Integer)session.getAttribute("LOG_STATUS"); //������Ʈ���������ִ�
		
		
		
		
		if(command.startsWith("/id_") && logined !=1) {
			String referer = request.getHeader("Referer");
			if(referer.contains("/id_")) {
				referer = "index.jsp";
			}
			else {
				request.getSession().setAttribute("fail", "�α����� �ʿ��� �����Դϴ�, �α������ּ���.");
			}
			response.sendRedirect(referer);
			return;
		}
		else if(command.equals("/Mng.health")){	
			forward = new ActionForward(); 
			forward.setPath("_FORWHERE.jsp?forwhere=4health/introhealth.jsp");
		}
		else if(command.equals("/id_gymapply.health")){
			forward = new ActionForward(); 
			forward.setPath("_FORWHERE.jsp?forwhere=4health/gym_Apply.jsp");
		}
		else if(command.equals("/id_gymcreate.health")) {
			action  = new com.team7.gym.action.GymCreateAction();
			System.out.print("d");
			try {
				forward=action.execute(request, response); //�޼��������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Search.health")){	
			System.out.print("�� ��ġ Ŭ���˴ϱ�");
			action  = new com.team7.gym.action.GymShowAllAction();
			try {
				forward=action.execute(request, response); //�޼��������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/GymUserpage.health")){	
				System.out.println("�ｺ�� ���������� Ŭ���˴ϱ�");
				action  = new com.team7.gym.action.GymUserpageAction();
				try {
					forward=action.execute(request, response); //�޼��������
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		System.out.println(command+"...������ / gym.");
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