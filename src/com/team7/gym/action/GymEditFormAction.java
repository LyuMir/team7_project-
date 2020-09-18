package com.team7.gym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.service.*;
import com.team7.gym.service.GymShowAllService;
import com.team7.photo.service.PhotoGymService;
import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.PostBean;
import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;



public class GymEditFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOG_ID");
		
		List<Gym_info> info = new GymService().select_mygym_prof(id);

		request.setAttribute("gym", info);
		

		ActionForward forward = new ActionForward();
		forward.setPath("/_FORWHERE.jsp?forwhere=4health/gym_editForm.jsp");
		return forward;
		
	}

}
