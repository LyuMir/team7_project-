package com.team7.trainer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.photo.service.PhotoGymService;
import com.team7.photo.service.PhotoTrainerService;
import com.team7.post.service.PostService;
import com.team7.trainer.service.*;
import com.team7.trainer.service.TrainerShowAllService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;
import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.PostBean;
import com.team7.vo.Trainer_info;


public class TrainerShowAllAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("액션까지왔을까요?");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOG_ID");	
		
		TrainerShowAllService tser = new TrainerShowAllService();
		
		List<Trainer_info> trainerlist =tser.getTrainerinfo();
		List<PhotoBean> photos = new PhotoTrainerService().entire_trainerphoto();
		List<ZZIMBean> trainerzzim	= new ZzimService().select_trainer_count2(id);
		List<PostBean> posts = new PostService().getTPOSTnum();
		
		

		ActionForward forward= new ActionForward();
		request.setAttribute("tser", trainerlist);
		request.setAttribute("photos", photos);
		request.setAttribute("trainerzzim", trainerzzim);
		request.setAttribute("posts", posts);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/TrainerShowAll.jsp");
		return forward;
		
	}

}
