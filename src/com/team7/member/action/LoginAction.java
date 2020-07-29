package com.team7.member.action;

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

		ActionForward forward= new ActionForward();
		if(loginGood) {
			javax.servlet.http.HttpSession session = request.getSession(true);
			session.setAttribute("LOG_ID",log_id2);
	        session.setAttribute("LOG_STATUS",1);
//	        session.setAttribute("NAME",namedata);
			forward.setPath("/index.jsp");
		}
		else {
			forward.setPath("/Join_and_LogIn.jsp?fail=로그인 실패");
		}
//		forward.setRedirect(true);
		
   		return forward;
	}

}