package com.team7.trainer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.photo.service.PhotoTrainerService;
import com.team7.trainer.service.TrainerMypageService;
import com.team7.vo.ActionForward;
import com.team7.vo.PhotoBean;
import com.team7.vo.Trainer_info;

public class Trainer_mng_mainAction {

	
	public ActionForward toMngpage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("LOG_ID");
		
		Trainer_info info = new Trainer_info();
		info.setId(id);
		List<Trainer_info> rlist = new TrainerMypageService().getTrainerMyinfo(info);
		List<PhotoBean> photoBean = new PhotoTrainerService().getfilenames_trainerphoto(id, -1);

		request.setAttribute("rlist", rlist);
		request.setAttribute("photoBean", photoBean);
		
		ActionForward forward = new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=2trainer/introtrainer.jsp");
		
		return forward;
	}
}
