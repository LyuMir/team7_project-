package com.team7.club.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.club.service.ClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;

public class ClubCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String club_name = request.getParameter("club_name");
		String club_publicity = request.getParameter("club_publicity");
		String club_memberJoin = request.getParameter("club_memberJoin");
		String club_memLimit = request.getParameter("club_memLimit");
//		int club_memLimit = Integer.parseInt(request.getParameter("club_memLimit"));
		String []club_exc_types = request.getParameterValues("club_exc_type");
//		String club_date = request.getParameter("club_date");
		String meetingDate_select = request.getParameter("meetingDate_select");
		String meeting_week1 = request.getParameter("meeting_week1");
		String meeting_week2 = request.getParameter("meeting_week2");
		String club_hour1 = request.getParameter("club_hour1");
		String club_hour2 = request.getParameter("club_hour2");
		String club_area = request.getParameter("club_area");
		String club_profileText = request.getParameter("club_profileText");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOG_ID");
		
		
		String club_Date_week = "";
		
		if(meetingDate_select.equals("meeting1")){
			club_Date_week = "매주 "+meeting_week1+"요일";
		}
		else if (meetingDate_select.equals("meeting2")){
			club_Date_week = "매 "+meeting_week1+"번째 주 "+meeting_week2+"요일";
		}
		else if(meetingDate_select.equals("meeting3")){
			club_Date_week = "매달 "+meeting_week1+"번째 "+meeting_week2+"요일";
		}
		String club_Date_hour = club_hour1+"시 부터 "+club_hour2+"시까지";
		String club_exc_type = "";

		ClubBean clubBean = new ClubBean();
		if(club_exc_types == null){}
		else{
			for(String sth : club_exc_types){
				club_exc_type += sth+",";
			}
			club_exc_type = club_exc_type.substring(0,club_exc_type.length()-1);
			clubBean.setE_type(club_exc_type);
		}
		
		clubBean.setAdmin(id);
		clubBean.setArea(club_area);
		clubBean.setMeetingDate(club_Date_week+" "+club_Date_hour);
		clubBean.setMemberJoin(club_memberJoin);
//		clubBean.setMemberLimit(club_memLimit);
		clubBean.setName(club_name);
//		clubBean.setNo();
		clubBean.setProfile(club_profileText);
		clubBean.setPublicity(club_publicity);
//		clubBean.setPhoto1();
//		clubBean.setPhoto2();
		new ClubService().club_creator(clubBean);
		

		ActionForward forward= new ActionForward();
		forward.setPath("");
		return forward;
	}

}
