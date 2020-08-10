package com.team7.gym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.gym.service.*;
import com.team7.gym.service.GymShowAllService;
import com.team7.photo.service.PhotoGymService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;



public class GymShowAllAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("쇼 올 액션까지왔을까요?");
	
		GymShowAllService gser = new GymShowAllService();
		
		List<Gym_info> gymlist = new ArrayList<Gym_info>();
		List<PhotoBean> photos = new PhotoGymService().entire_gymphoto();
		
		
		gymlist = gser.getGyminfo();
		
		ActionForward forward= new ActionForward();
		
		request.setAttribute("photos", photos);
		request.setAttribute("gser", gymlist);
		forward.setPath("/_FORWHERE.jsp?forwhere=4health/GymShowAll.jsp");
		return forward;
		
	}

}
