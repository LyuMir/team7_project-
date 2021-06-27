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
import com.team7.zzim.service.ZzimService;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.PostBean;
import com.team7.vo.Trainer_info;


public class TrainerUserpageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		int no = Integer.parseInt(request.getParameter("number"));
				


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
		if(id !=null) {
			System.out.println("아이디감지!!!!");
			zzimYN = new ZzimService().select_trainer_Z_YN(id, no);
			System.out.println(no+id+"트레이너 넘버확인");
			if(zzimYN.size()==0) {
				System.out.println("왜 널이들어오는거지");
				zzimYN = null;
			}
		}
		
		List<ZZIMBean> trainerzzim = new ZzimService().select_trainer_count2(id);
		List<ZZIMBean> tpostzzim = new ZzimService().select_tpost_Z(id);
		if (tpostzzim ==null) tpostzzim = new ArrayList<ZZIMBean>();
		
		ActionForward forward= new ActionForward();

		request.setAttribute("tser", traineronelist);
		request.setAttribute("photos", photos);
		request.setAttribute("posts", posts);
		request.setAttribute("zzimYN", zzimYN);
		request.setAttribute("trainerzzim", trainerzzim);
		request.setAttribute("tpostzzim", tpostzzim);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/trainer_userpage.jsp");
		return forward;

	}

}
