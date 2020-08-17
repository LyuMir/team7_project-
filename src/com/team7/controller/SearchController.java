package com.team7.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.action.Action;
import com.team7.search.action.SearchAction;
import com.team7.vo.ActionForward;

@WebServlet("*.search")
public class SearchController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 

		// 유의! ajax용임!! 보내는 forward redirect 없음!
		System.out.println("search컨트롤러 진입 : "+command);
		
		SearchAction act = new SearchAction();
		
		if(command.contains("/clubname.search")){
			System.out.println("소모임 이름으로 검색. . .");
			act.clubname(request, response);
		}
		else if(command.contains("/clubexc.search")){	
			System.out.println("운동종류로 검색 . . . ");
		}


	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}   
	
}