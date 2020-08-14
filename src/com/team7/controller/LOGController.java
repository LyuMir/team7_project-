
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
		
		request.setCharacterEncoding("UTF-8");	//�궡媛� 異붽��븿
		String RequestURI=request.getRequestURI();	//req 媛��졇�샂 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�븵�뿉 湲��옄 吏��� : boardList.bo
		//利� '/'�씠�썑 留� 留덉�留됰쭔. 
		
		
		ActionForward forward=null;	//forward : 媛� 怨� 吏��젙 
		Action action=null;			//action : �븷 �씪 吏��젙  �젙�솗�엳�뒗 action.execute()濡�. (�씤�꽣�럹�씠�뒪濡� 援ъ꽦�븿)
		HttpSession session = request.getSession();
		int logyn =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logyn=(Integer) session.getAttribute("LOG_STATUS");
		}
		
		if(command.contains("id_") && logyn !=1) {

			String referer = request.getHeader("Referer");
			if(referer.contains("/id_")) {
				referer = "index.jsp";
			}
			else {
				request.getSession().setAttribute("fail", "로그인이필요합니다");
			}
			response.sendRedirect(referer);
			
			return;
		}
		
		
		if(command.equals("/join.log")){	// 洹� �씪 �슂泥�諛쏆� 嫄곕㈃ �떎�쓬�쓣 �빐�씪.
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
		else if(command.equals("/id_myinfo.log")) {
			new MyInfoAction().toMyInfoPage(request, response);
		}
		else if(command.equals("/id_editmyinfo.log")) {
			new MyInfoAction().infoEdit(request, response);
		}


		if(forward != null){	//媛��빞�븷 怨녹씠 �엳�떎硫� 蹂대깂. \
			//�븞蹂대깂. �깉濡쒓퀬移� �떆�궗嫄곗엫. 

//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
////			out.println("alert('�옒紐삳맂 寃쎈줈 : �씠誘� 媛��엯�릺�뼱�엳�뒗 �냼紐⑥엫�엯�땲�떎. ')");
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
		response.setContentType("text/html; charset=utf-8"); //�궡媛� 異붽��븿
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //�궡媛� 異붽��븿
		doProcess(request,response);
	}   
	
}