package com.team7.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ActionForward;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(true);
		session.removeAttribute("LOG_ID");
		session.removeAttribute("fail");
        session.setAttribute("LOG_STATUS",0);

		ActionForward forward= new ActionForward();
//		String fromwhere = request.getHeader("referer");	 //�̰� ����԰ڴ�.  �߰��� �� �ɸ�. 
		String fromwhere = request.getParameter("forwhere");	// �� �� ��������� ���� �ؿ��� �˾Ƽ� �ɸ�����. �̰� ����.
		forward.setPath(fromwhere);
//		forward.setPath("/index.jsp");
		return forward;	
	}

}
