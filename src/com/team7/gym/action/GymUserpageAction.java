package com.team7.gym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.action.Action;
import com.team7.gym.service.*;
import com.team7.gym.service.GymUserpageService;
import com.team7.photo.action.GymPhotoAction;
import com.team7.photo.service.PhotoGymService;
import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.PostBean;
import com.team7.vo.Gym_info;


public class GymUserpageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("유저페이지 액션까지왔을까요?");
		int no = Integer.parseInt(request.getParameter("number"));
		
		System.out.println(no+"입니다!!");
		
		Gym_info info = new Gym_info();
		info.setId(no);
		
		
		GymUserpageService gser = new GymUserpageService();
		List<Gym_info> Gymonelist = new ArrayList<Gym_info>();
//		List<PhotoBean> photos = new PhotoGymService().getfilenames_gymphoto(id, no, -1);
		
		Gymonelist = gser.getGymOneinfo(info);
		
		String gymO = Gymonelist.get(0).getOwner();
		List<PhotoBean>photoBean = new PhotoGymService().getfilenames_gymphoto(gymO, 11, -1);
		
//		int trainerno = Gymonelist.get(0).get
		List<PostBean> posts	= new PostService().getGPOSTs(no);

	
		

		ActionForward forward= new ActionForward();
		
		request.setAttribute("photoBean", photoBean);
		request.setAttribute("gser", Gymonelist);
		request.setAttribute("posts", posts);
		forward.setPath("/_FORWHERE.jsp?forwhere=4health/GymUserpage.jsp");
		return forward;
		
	}

}
