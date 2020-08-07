package com.team7.gym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.action.Action;
import com.team7.gym.service.*;
import com.team7.gym.service.GymUserpageService;
import com.team7.vo.ActionForward;
import com.team7.vo.PageInfo;
import com.team7.vo.Gym_info;


public class GymUserpageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("유저페이지 액션까지왔을까요?");
		int no = Integer.parseInt(request.getParameter("number"));
		
		System.out.println(no);
		
		Gym_info info = new Gym_info();
		info.setGid(no);
		
		
		GymUserpageService gser = new GymUserpageService();
		List<Gym_info> Gymonelist = new ArrayList<Gym_info>();
		
		Gymonelist = gser.getGymOneinfo(info);

	
		

		ActionForward forward= new ActionForward();
		
		request.setAttribute("gser", Gymonelist);
		forward.setPath("/_FORWHERE.jsp?forwhere=4health/GymUserpage.jsp");
		return forward;
		
	}

}
