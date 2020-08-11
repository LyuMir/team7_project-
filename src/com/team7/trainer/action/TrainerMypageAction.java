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


public class TrainerMypageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		

		System.out.println("트레이너 마이페이지 액션까지왔을까요?");
		HttpSession session = request.getSession(true);
		
		String id = (String)session.getAttribute("LOG_ID");
		System.out.println(id);
		
		Trainer_info info = new Trainer_info();
		info.setId(id);

		
		TrainerMypageService tser = new TrainerMypageService();
		List<Trainer_info> traineronelist = new ArrayList<Trainer_info>();
		
		traineronelist = tser.getTrainerMyinfo(info);
		System.out.println(traineronelist.get(0).getNo()+"안웅ㅇ기까지온건가요?");
		
		
		String tid =	traineronelist.get(0).getId();
		List<PhotoBean> photos = new PhotoTrainerService().getfilenames_trainerphoto(tid, -1);
		

		ActionForward forward= new ActionForward();
		
		request.setAttribute("tser", traineronelist);
		request.setAttribute("photos", photos);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/trainer_userpage.jsp");
		return forward;
		
	}

}
