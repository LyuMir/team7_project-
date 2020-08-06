package com.team7.club.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.club.service.ClubService;
import com.team7.dao.Class_DAO;
import com.team7.photo.service.PhotoService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;
import com.team7.vo.PhotoBean;

public class ClubCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		


		request.setCharacterEncoding("utf-8");
		
//		PhotoBean photoBean = new PhotoBean();
//		photoBean.setId((String)request.getParameter("club_name"));
//		System.out.println(request.getParameter("club_name")+"이라는 이름으로...");

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
		
//		String photo1 = request.getParameter("photo1");
//		String photo2 = request.getParameter("photo2");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOG_ID");
		int Limit = 150;
		if(club_memLimit == null) {
			
		}
		else if(club_memLimit.equals("null"))	//그따구임!!
			Limit = 150;
		else{
			Limit = 150;
		}
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
		clubBean.setMemberLimit(Limit);
		clubBean.setName(club_name);
//		clubBean.setNo();
		clubBean.setProfile(club_profileText);
		clubBean.setPublicity(club_publicity);
		
		String photo1 =null , photo2 = null;
		List<PhotoBean> photos = new PhotoService().getfilenames_clubmains(id);
		
		for(int i = 0 ; i <photos.size(); i++) {
			if(photos.get(i).getId().contains("_main")) {
				photo1 = photos.get(i).getPicture();
			}
			else if(photos.get(i).getId().contains("_profile")) {
				photo2 = photos.get(i).getPicture();
			}
		}
		
		clubBean.setPhoto1(photo1);
		clubBean.setPhoto2(photo2);
		new ClubService().club_creator(clubBean);
//		new PhotoUploadService().upload(request, "/Files/Photos", "clubMainPhoto");
//		new PhotoUploadService().upload(request, "/Files/Photos", "clubProfile");

//		System.out.println(k+"사진넣기");
//		System.out.println(k1+"사진넣기");
		
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("id_Mng.club");
		return forward;
	}

}
