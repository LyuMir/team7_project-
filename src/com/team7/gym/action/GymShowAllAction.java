package com.team7.gym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.gym.service.*;
import com.team7.gym.service.GymShowAllService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PageInfo;



public class GymShowAllAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("쇼 올 액션까지왔을까요?");
		
		GymShowAllService gser = new GymShowAllService();
		
		List<Gym_info> gymlist = new ArrayList<Gym_info>();

		gymlist = gser.getGyminfo();
		System.out.println(gymlist.get(0).getId());
		

		ActionForward forward= new ActionForward();
		request.setAttribute("tser", gymlist);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/GymShowAll.jsp");
		return forward;
		
	}

}
