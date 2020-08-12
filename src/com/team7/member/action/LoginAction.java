package com.team7.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.vo.ActionForward;
import com.team7.member.service.*;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String log_id2 = request.getParameter("log_id2"); 
		String log_pw2 = request.getParameter("log_pw2");
		
		com.team7.vo.MemberLogInfo loginfo = new com.team7.vo.MemberLogInfo();
		
		loginfo.setId(log_id2);
		loginfo.setPw(log_pw2);
		
		boolean loginGood = new LogMatchService().Login(loginfo);

//		ActionForward forward= new ActionForward();
		ActionForward forward = null;
        PrintWriter out = response.getWriter();
		javax.servlet.http.HttpSession session = request.getSession(true);
//        System.out.println("���� ���̷�"+log_id2+loginGood);
		out.println("<div><div class='mont' data-log='");
		if(loginGood) {
			session.setAttribute("LOG_ID",log_id2);
	        session.setAttribute("LOG_STATUS",1);
	        session.removeAttribute("fail");
//	        session.setAttribute("NAME",namedata);
//			forward.setPath("/index.jsp"); 	// �� ���� ������ �����
			out.println("����");
		}
		else {
			session.setAttribute("fail", "�α��� ����!");
//			forward.setPath("/Join_and_LogIn.jsp?fail=�α��� ����");
			out.println("����");
		}
		out.println("'></div></div>");
//		forward.setRedirect(true);
		
   		return forward;
	}

}