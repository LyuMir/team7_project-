package com.team7.gym.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.service.GymService;
import com.team7.photo.service.PhotoGymService;
import com.team7.photo.service.PhotoTrainerService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PhotoBean;

public class Gym_mng_mainAction {

	
	public ActionForward toMngpage(HttpServletRequest request, HttpServletResponse response) {


		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("LOG_ID");
		
		List<Gym_info>rlist = new GymService().select_mygym_prof(id);
		if(rlist.size()>0) {
			int gymnum = rlist.get(0).getGid();
			List<PhotoBean> photoBean = new PhotoGymService().getfilenames_gymphoto(id, gymnum, -1);
			request.setAttribute("photoBean", photoBean);
		}
		
		request.setAttribute("rlist", rlist);
		ActionForward forward = new ActionForward(); 
		forward.setPath("_FORWHERE.jsp?forwhere=4health/introhealth.jsp");
		return forward;
	}
}
