package com.team7.club.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.CMemberService;
import com.team7.vo.ActionForward;
import com.team7.vo.CmemberBean;

public class ClubOutmeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int clubid = Integer.parseInt(request.getParameter("clubid"));
		String id0 = (String)request.getSession().getAttribute("LOG_ID");
		CmemberBean cmember = new CmemberBean();
		cmember.setClub(clubid);
		cmember.setCmember(id0);
		new CMemberService().letmeout(cmember);
		

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>");
		out.print("history.go(0)");
		out.print("</script>");
		
		return null;
	}

}
