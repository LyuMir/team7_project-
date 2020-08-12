package com.team7.club.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.ClubService;
import com.team7.photo.service.PhotoClubService;
import com.team7.vo.ClubBean;

public class ClubPhotoAction {

	public void upload1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getSession().getAttribute("LOG_ID");
//		int clubid = (Integer) request.getSession().getAttribute("clubid");
		Integer ci =  (Integer) request.getSession().getAttribute("clubid");
		int clubid = 0 ;
		if(ci ==null || ci==000|| ci==0) {
			List<ClubBean> cb = new ClubService().club_selectorAll();
			clubid = cb.size();
			clubid = cb.get(clubid-1).getNo() +1;
		}
		else {
			clubid = ci;
		}
		new PhotoClubService().upload_club_main(request, "/clubsphoto/"+id+"_"+clubid+"/main", id+"_club_"+clubid);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("history.back();");
		out.println("</script>");
	}

	public void upload2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getSession().getAttribute("LOG_ID");
//		int clubid = (Integer) request.getSession().getAttribute("clubid");
		Integer ci =  (Integer) request.getSession().getAttribute("clubid");
		int clubid = 0 ;
		if(ci ==null || ci==000|| ci==0) {
			List<ClubBean> cb = new ClubService().club_selectorAll();
			clubid = cb.size();
			clubid = cb.get(clubid-1).getNo() +1;
		}
		else {
			clubid = ci;
		}
		new PhotoClubService().upload_club_profile(request, "/clubsphoto/"+id+"_"+clubid+"/profile", id+"_club_"+clubid);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("history.back();");
		out.println("</script>");
	}
}
