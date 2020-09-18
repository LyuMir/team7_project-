package com.team7.zzim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;

public class GymZAction {

	public void gz(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int gymid = Integer.parseInt(request.getParameter("gymid"));
		
		System.out.println("??");
		
		ZZIMBean zzim = new ZZIMBean();
		zzim.setGym(gymid);
		zzim.setPerson(id);
		
		new ZzimService().insert_Gym(zzim);
		
	}
	
	
	public void gzC(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int gymid = Integer.parseInt(request.getParameter("gymid"));
		
		ZZIMBean zzim = new ZZIMBean();
		zzim.setGym(gymid);
		zzim.setPerson(id);
		
		new ZzimService().delete_Gym(zzim);
	}
}
