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
import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;
import com.team7.vo.Gym_info;


public class GymUserpageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		int no = Integer.parseInt(request.getParameter("number"));
		
		System.out.println(no+"입니다!!");
		
		Gym_info info = new Gym_info();
		info.setGid(no);
		
		
		GymUserpageService gser = new GymUserpageService();
		List<Gym_info> Gymonelist = new ArrayList<Gym_info>();
//		List<PhotoBean> photos = new PhotoGymService().getfilenames_gymphoto(id, no, -1);
		
		Gymonelist = gser.getGymOneinfo(info);
		
		String gymO = Gymonelist.get(0).getOwner();
		List<PhotoBean>photoBean = new PhotoGymService().getfilenames_gymphoto(gymO, 11, -1);
		
//		int trainerno = Gymonelist.get(0).get
		List<PostBean> posts	= new PostService().getGPOSTs(no);

		
		List<ZZIMBean> zzimYN = null;
		String id = (String )request.getSession().getAttribute("LOG_ID");
		if(id !=null) {
			System.out.println("아이디감지! 찜을 했는지 판단합니다!");
			zzimYN = new ZzimService().select_gym_Z_YN(id, no);
			System.out.println("사이즈감지"+zzimYN.size());
			if(zzimYN.size()==0) {
				zzimYN = null;
			}
			
		}
		System.out.println("확인합니다 널인가"+zzimYN);
		
		List<ZZIMBean> gpostzzim= new ZzimService().select_gpost_Z(id);

		ActionForward forward= new ActionForward();
		
		request.setAttribute("photoBean", photoBean);
		request.setAttribute("gser", Gymonelist);
		request.setAttribute("posts", posts);
		request.setAttribute("zzimYN", zzimYN);
		request.setAttribute("gpostzzim", gpostzzim);
		
		forward.setPath("/_FORWHERE.jsp?forwhere=4health/GymUserpage.jsp");
		return forward;
		
	}

}
