package com.team7.club.action;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.club.service.CEnrollService;
import com.team7.club.service.CMemberService;
import com.team7.club.service.ClubService;
import com.team7.dao.Class_DAO;
import com.team7.photo.service.PhotoUploadService;
import com.team7.vo.ActionForward;
import com.team7.vo.C_enroll_Bean;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;
import com.team7.vo.PhotoBean;

public class ClubJoinMeFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//String clubid = request.getParameter("clubid");
		Integer clubid = (Integer)request.getAttribute("clubid");
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		String  etime, wanttodo,memo ="";
		etime = request.getParameter("etime");
		wanttodo = request.getParameter("wanttodo");
		memo = request.getParameter("memo");
		
		C_enroll_Bean enrll = new C_enroll_Bean();
		enrll.setClub(clubid);
		enrll.setEtime(etime);
		enrll.setMemo(memo);
		enrll.setWanttobe((String)session.getAttribute("LOG_ID"));
		enrll.setWanttodo(wanttodo);
		
		new CEnrollService().cEnrollMe(enrll);
		
		//new ClubService().club_selector_no(clubBean);
		

		
		ActionForward forward= new ActionForward();
		forward.setPath("Search.club");
		return forward;
	}

}
