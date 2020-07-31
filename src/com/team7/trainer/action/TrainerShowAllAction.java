package com.team7.trainer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.trainer.service.*;
import com.team7.trainer.service.TrainerShowAllService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;
import com.team7.vo.PageInfo;
import com.team7.vo.Trainer_info;


public class TrainerShowAllAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("액션까지왔을까요?");
		
		TrainerShowAllService tser = new TrainerShowAllService();
		
		List<Trainer_info> trainerlist = new ArrayList<Trainer_info>();

		trainerlist = tser.getTrainerinfo();
		System.out.println(trainerlist.get(0).getNo());
		

		ActionForward forward= new ActionForward();
		request.setAttribute("tser", trainerlist);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/TrainerShowAll.jsp");
		return forward;
		
	}

}
