package com.team7.trainer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.photo.service.PhotoTrainerService;
import com.team7.trainer.service.*;
import com.team7.trainer.service.TrainerUserpageService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.Trainer_info;


public class TrainerEditFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Trainer_info info  = new Trainer_info();
		info.setId((String)session.getAttribute("LOG_ID"));
		List<Trainer_info> rlist = new TrainerMypageService().getTrainerMyinfo(info);
		

		request.setAttribute("rlist", rlist);
		//System.out.println(rlist.size() + "¶ó´Ï±ñ¿ä");
		ActionForward forward = new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=2trainer/traineredit.jsp");
		return forward;
		
	}

}
