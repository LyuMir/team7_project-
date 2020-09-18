package com.team7.club.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.service.CMemberService;
import com.team7.club.service.ClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;

public class ClubDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String clubid = request.getParameter("clubid");

		ClubBean clubBean = new ClubBean();
		clubBean.setNo(Integer.parseInt(clubid));
		
		List<CmemberBean> theclub = new CMemberService().cmember_selector(clubBean);
		if(theclub.size() <2) {	//
			HttpSession session = request.getSession();
			String idid = (String)session.getAttribute("LOG_ID");
			CmemberBean cmember = new CmemberBean();
			cmember.setCmember(idid);
			cmember.setClub(Integer.parseInt(clubid));
			new CMemberService().deleteMember(cmember);
			new ClubService().club_deletor(clubBean);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�Ҹ����� ���������� �����Ǿ����ϴ�. ')");
//			out.println("history.back()");
			out.println("location.href='id_Mng.club'");
			out.println("</script>");
			return null;
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('���� ���� : �Ҹ��ӿ� �����ִ� �ο��� �ֽ��ϴ�. ')");
			out.println("history.back()");
			out.println("</script>");
			return null;
		}
//		System.out.println(theclub.size()+"��. ");
//		ActionForward forward= new ActionForward();
//		forward.setPath("id_Mng.club");
//		return forward;
	}

}
