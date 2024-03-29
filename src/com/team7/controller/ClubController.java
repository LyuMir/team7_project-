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
import com.team7.vo.ActionForward;

@WebServlet("*.club")
public class ClubController extends javax.servlet.http.HttpServlet 
{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
		
		ActionForward forward=null;	//forward : 갈 곳 지정 
		Action action=null;			//action : 할 일 지정  정확히는 action.execute()로. (인터페이스로 구성함)

		HttpSession session = request.getSession(true);
		int logined =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logined=(Integer) session.getAttribute("LOG_STATUS");
		}
		//해당 jsp에서 처리...!!!
		if(command.startsWith("/id_") && logined !=1) {

//			request.setAttribute("fail", "로그인이 필요한 서비스입니다!");
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("history.back();");
//			out.println("</script>");
			String referer = request.getHeader("Referer");
			if(referer.contains("/id_")) {
				referer = "index.jsp";
			}
			else {
				request.getSession().setAttribute("fail", "로그인이 필요한 서비스입니다, 로그인해주세요.");
			}
			response.sendRedirect(referer);
//			response.sendRedirect("_FORWHERE.jsp?fail3=nolog&forwhere="+referer);
			
			return;	//여기에 걸리면 밑에 구문들은 실행하지 않습니다... sendRedirect라서 어차피 실행 안되겠지만, 혹시 모르니까. 
		}
		

      //  <% for(int j=0; j< major.length; j++){ %>
   		//<%=major[j]%>
		
		
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
		else if(command.equals("/id_Mng.club")){	// 그 일 요청받은 거면 다음을 해라.
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
		else if(command.equals("/photo_upload.club")){
			new com.team7.club.action.ClubPhotoAction().upload1(request, response );
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		else if(command.equals("/photo_upload2.club")){
			new com.team7.club.action.ClubPhotoAction().upload2(request, response );
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
		else if(command.equals("/managePro.club")){
			action  = new com.team7.club.action.ClubEnrollProAction();	//clubid
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
		else if(command.equals("/id_joinme.club")){
			action  = new com.team7.club.action.ClubJoinMeFormAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
//			forward = new ActionForward();
//			forward.setPath("_FORWHERE.jsp?forwhere=3club/club_enroll.jsp");
		}
		else if(command.equals("/enrollgo.club")){
			action  = new com.team7.club.action.ClubJoinMeAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/outme.club")){
			action  = new com.team7.club.action.ClubOutmeAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/outyou.club")){
			new com.team7.club.action.ClubKickoutAction().kickout(request, response);
		}
		


		if(forward != null){	//가야할 곳이 있다면 보냄. \
			if(forward.getPath()==null) {
				forward.setPath("/index.jsp");
			}
			if(forward.getPath().equals("")) {
				forward.setPath("/index.jsp");
			}
			if(forward.getPath().startsWith("\\")) {
				forward.setPath(forward.getPath().substring(1));
				System.out.println(forward.getPath()+"필요 할까?");
			}

			System.out.println(forward.getPath()+"으로 갑니다...");
			
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
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}   
	
}