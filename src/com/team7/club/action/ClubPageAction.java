package com.team7.club.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.CEnrollService;
import com.team7.club.service.CMemberService;
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
		CmemberBean cmember = new CmemberBean();
		cmember.setClub(Integer.parseInt(club_id));
		cmember.setCmember(id0);
		List<CmemberBean> ami0 = new CMemberService().amiinclub(cmember);
		List<C_enroll_Bean> didi = new CEnrollService().c_enroll_selector(clubBean);
		boolean ami = false;
		boolean ied = false;
		if(ami0 !=null && ami0.size() !=0) {
			if(ami0.get(0).getOutatdate() !=null) {
				ami = true;
			}
		}
		for(int i = 0 ; i < didi.size(); i++) {
			if(didi.get(i).getWanttobe().equals(id0)) {
				ied = true;
			}
		}
		
		request.setAttribute("mylist", mylist);
		request.setAttribute("mylist2", mylist2);
		request.setAttribute("tlist", tlist);
		request.setAttribute("ami", ami);
		request.setAttribute("ied", ied);

		request.setAttribute("rlist", rlist);
		request.setAttribute("rlist00", rlist);
				System.out.println(rlist.get(0).getAdmin());
				System.out.println(rlist.get(0).getMeetingDate());
				
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_main.jsp");
		return forward;
	}

}
