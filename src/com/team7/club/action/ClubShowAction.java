package com.team7.club.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.club.service.*;

public class ClubShowAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		PageInfo pageInfo = new PageInfo();
		ClubBean clubBean = new ClubBean();

		//List<ClubBean> rlist = new ClubService().club_selectorAll2(pageInfo);
		List<ClubBean> rlist = new ClubService().club_selectorAll();
		List<PhotoBean> plist = new ClubService().club_mainPselector();
		if(rlist ==null) rlist = new ArrayList<ClubBean>();
		if(plist ==null) plist = new ArrayList<PhotoBean>();
		
		request.setAttribute("rlist", rlist);
		request.setAttribute("plist", plist);
		
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_searchAll.jsp");
		return forward;
	}

}
