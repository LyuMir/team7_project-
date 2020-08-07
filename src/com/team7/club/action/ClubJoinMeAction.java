package com.team7.club.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.service.CEnrollService;
import com.team7.club.service.CMemberService;
import com.team7.vo.ActionForward;
import com.team7.vo.C_enroll_Bean;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;

public class ClubJoinMeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String clubid = request.getParameter("clubid");
//		String clubid = (String)request.getAttribute("clubid");
		//System.out.println(clubid);
		//System.out.println(request.getPathInfo()); 
		String  etime="", wanttodo="",memo="",id ="";
		etime = request.getParameter("etime");
		wanttodo = request.getParameter("wanttodo");
		memo = request.getParameter("memo");
		HttpSession session = request.getSession(true);
		id =(String)session.getAttribute("LOG_ID");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(etime);
		System.out.println(wanttodo);
		System.out.println(id);
		System.out.println(memo);
		System.out.println(request.getParameter("etime"));
		System.out.println(request.getCharacterEncoding());

		ActionForward forward = null;
		
		C_enroll_Bean enrll = new C_enroll_Bean();
		enrll.setClub(Integer.parseInt(clubid));
//		enrll.setClub(clubid);
		enrll.setEtime(etime);
		enrll.setMemo(memo);
		enrll.setWanttobe(id);
		enrll.setWanttodo(wanttodo);
		
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(Integer.parseInt(clubid));
		List<CmemberBean> member = new CMemberService().cmember_selector(clubBean);
		
		boolean ok = true;
		for(int i = 0 ; i < member.size(); i++) {
			if (member.get(i).getCmember().equals(id)) {
				ok = false;
				break;
			}
		}
		
		
		if(ok) {
			new CEnrollService().cEnrollMe(enrll);
			forward= new ActionForward();
			forward.setPath("Search.club");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('잘못된 경로 : 이미 가입되어있는 소모임입니다. ')");
			out.println("history.back();");
			out.println("</script>");
		}
		//new ClubService().club_selector_no(clubBean);


//		forward.setPath("toClubMain.club");
//		forward.setPath("Search.club");
//		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_main.jsp&");
		return forward;
	}

}
