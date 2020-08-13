package com.team7.trainer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.photo.service.PhotoTrainerService;
import com.team7.post.service.PostService;
import com.team7.trainer.service.*;
import com.team7.trainer.service.TrainerUserpageService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;
import com.team7.vo.ZZIMBean;
import com.team7.zzim.controller.ZzimService;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.PostBean;
import com.team7.vo.Trainer_info;


public class TrainerUserpageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("���������� �׼Ǳ�����������?");
		int no = Integer.parseInt(request.getParameter("number"));

		System.out.println(no);

		Trainer_info info = new Trainer_info();
		info.setNo(no);

		TrainerUserpageService tser = new TrainerUserpageService();
		List<Trainer_info> traineronelist = new ArrayList<Trainer_info>();

		traineronelist = tser.getTrainerOneinfo(info);
		String tid =	traineronelist.get(0).getId();
		List<PhotoBean> photos = new PhotoTrainerService().getfilenames_trainerphoto(tid, -1);

		List<PostBean> posts	= new PostService().getTPOSTs(no);


		List<ZZIMBean> zzimYN = null;
		String id = (String )request.getSession().getAttribute("LOG_ID");
		if(id !=null)
			zzimYN = new ZzimService().select_trainer_Z_YN(id, no);


		ActionForward forward= new ActionForward();

		request.setAttribute("tser", traineronelist);
		request.setAttribute("photos", photos);
		request.setAttribute("posts", posts);
		request.setAttribute("zzimYN", zzimYN);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/trainer_userpage.jsp");
		return forward;

	}

}
