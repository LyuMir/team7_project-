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
import com.team7.zzim.action.Zzim_Show_Actions;

@WebServlet("*.zzimshow")
public class ZzimShowController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//���� �߰���
		String RequestURI=request.getRequestURI();	//req ������ :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�տ� ���� ���� : boardList.bo
		//�� '/'���� �� ��������. 
//		System.out.println(RequestURI);
//		System.out.println(contextPath);

		HttpSession session = request.getSession(true);

//		System.out.println("������� ����??");
		
		
		if(command.equals("/club.zzimshow")) {
			System.out.println("Ŭ�� �� ������."+request.getParameter("clubid"));
			new Zzim_Show_Actions().club_show(request, response);;
		}
//		else if(command.equals("/club_drop.zzimshow")) {
//			System.out.println("Ŭ�� �� ���");
//			new Zzim_Club_Actions().clubZ_cancle(request, response);
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