package com.team7.club.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.service.CMemberService;
import com.team7.vo.ActionForward;
import com.team7.vo.CmemberBean;

public class ClubKickoutAction {

	public void kickout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		int clubno = (Integer)session.getAttribute("clubid");
		session.removeAttribute("clubid");
		
		String kickmembers[] = request.getParameterValues("bb123");
		CMemberService cm = new CMemberService();
		CmemberBean cmember = new CmemberBean();
		cmember.setClub(clubno);
		for(int i = 0 ; i <kickmembers.length; i++) {
			cmember.setCmember(kickmembers[i]);
			cm.deleteMember(cmember);
			System.out.println("Ε»Επ : "+cmember);
		}
		
		response.sendRedirect("manage.club?clubid="+clubno);
	}
}
