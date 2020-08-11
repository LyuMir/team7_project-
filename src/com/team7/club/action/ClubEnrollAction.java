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
import com.team7.photo.service.PhotoClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.C_enroll_Bean;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;
import com.team7.vo.PhotoBean;

public class ClubEnrollAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String clubid = request.getParameter("clubid");
		
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(Integer.parseInt(clubid));
		
		
		List<ClubBean> rlist = new ClubService().club_selector_no(clubBean);
		List<C_enroll_Bean> rlist_e = new CEnrollService().c_enroll_selector(clubBean);

		List<CmemberBean> rlist_m = new CMemberService().cmember_selector(clubBean);
		

		request.setAttribute("rlist", rlist);
		request.setAttribute("rlist_e", rlist_e);
		request.setAttribute("rlist_m", rlist_m);
		
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_manage.jsp");
		return forward;
	}

}
