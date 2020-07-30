package com.team7.club.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.club.service.ClubService;
import com.team7.dao.Class_DAO;
import com.team7.photo.service.PhotoUploadService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;
import com.team7.vo.PhotoBean;

public class ClubEnrollAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_manage.jsp");
		return forward;
	}

}
