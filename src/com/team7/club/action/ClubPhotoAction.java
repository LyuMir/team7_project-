package com.team7.club.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.photo.service.PhotoService;

public class ClubPhotoAction {

	public void upload1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getSession().getAttribute("LOG_ID");
		new PhotoService().upload_club_main(request, "/clubsphoto/"+id+"/main", id+"_club");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("history.back();");
		out.println("</script>");
	}

	public void upload2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getSession().getAttribute("LOG_ID");
		new PhotoService().upload_club_profile(request, "/clubsphoto/"+id+"/profile", id+"_club");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("history.back();");
		out.println("</script>");
	}
}
