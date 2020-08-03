package com.team7.club.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.ClubService;
import com.team7.controller.ClubController;
import com.team7.vo.*;
import com.team7.zzim.controller.ZzimService;

public class ClubPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//request.getParameter("");
		String id0 = (String)request.getSession().getAttribute("LOG_ID");
		String club_id = request.getParameter("clubid");
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(Integer.parseInt(club_id));
		List<ClubBean> mylist = new ArrayList<ClubBean>();
		List<ClubBean> mylist2 = new ArrayList<ClubBean>();
		List<ClubBean> rlist = new ClubService().club_selector_no(clubBean);
		if(id0 ==null || "null".equals(id0)) {
			ClubBean cl = new ClubBean();
			cl.setName("로그인해주세요");
			cl.setNo( -1 );
			mylist.add(cl);
			mylist2.add(cl);
		}
		else {
			MemberLogInfo id = new MemberLogInfo();
			id.setId(id0);
			mylist = new ClubService().club_selector_cmember(id);
			mylist2 = new ClubService().select_club_by_ZZIM(id);
			
		}
		System.out.println(rlist.get(0).getArea());
		clubBean.setArea(rlist.get(0).getArea());
		List<ClubBean> tlist = new ClubService().select_club_by_where(clubBean);
		
		request.setAttribute("mylist", mylist);
		request.setAttribute("mylist2", mylist2);
		request.setAttribute("tlist", tlist);

		request.setAttribute("rlist", rlist);
		request.setAttribute("rlist00", rlist);
				System.out.println(rlist.get(0).getAdmin());
				System.out.println(rlist.get(0).getMeetingDate());
				
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_main.jsp");
		return forward;
	}

}
