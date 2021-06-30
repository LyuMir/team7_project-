package com.team7.my.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.gym.service.GymService;
import com.team7.gym.service.GymShowAllService;
import com.team7.gym.service.GymUserpageService;
import com.team7.my.service.MyInfoService;
import com.team7.photo.service.PhotoClubService;
import com.team7.photo.service.PhotoGymService;
import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PostBean;
import com.team7.vo.Trainer_info;
import com.team7.vo.ZZIMBean;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PhotoBean;
import com.team7.zzim.*;
import com.team7.zzim.service.ZzimService;

public class MyInfoAction {

	public void toMyInfoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = (String) request.getSession().getAttribute("LOG_ID");

		MemberLogInfo l = new MemberLogInfo();
		l.setId(id);

		List<MemberInfo1> minfo = new MyInfoService().myinfo(l);

		List<PostBean> cposts = new PostService().getMyCPOSTs(id);
		
		request.setAttribute("minfo", minfo);
		request.setAttribute("cposts", cposts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("_FORWHERE.jsp?forwhere=8others/Mypage.jsp");
		dispatcher.forward(request, response);

	}

	public void infoEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String postcode = request.getParameter("sample4_postcode22");
		String adress = request.getParameter("adress");
		String dadress = request.getParameter("sample4_detailAddress");
		String interest = request.getParameter("interest");

		MemberInfo1 minfo = new MemberInfo1();
		minfo.setAddress(adress + dadress);
		minfo.setAddress_num(postcode);
		minfo.setName(name);
		minfo.setInterest(interest);

		new MyInfoService().myinfoedit(minfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("id_myinfo.log");
		dispatcher.forward(request, response);
	}

	public void toFindMyHealthZzim(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("액션까지왔습니다!");
		String person = (String) request.getSession().getAttribute("LOG_ID");

		System.out.println("아이디표기!=" + person);
		MemberLogInfo l = new MemberLogInfo();
		l.setId(person);
		ArrayList<Integer> id = new ArrayList<Integer>();
		ArrayList<String> smallText = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> major = new ArrayList<String>();
		
		List<ZZIMBean> list = new ZzimService().select_gym_Z(person);
		//찜한거만 가져왔어요! 여기에는 머가있나면~! 바로바로~ 찜한 짐 아이디가 있습니당~~
		List<ZZIMBean> tlist = new ZzimService().select_tpost_Z(person);
		for(int j = 0 ; j < list.size(); j ++) {
			int findgym = list.get(j).getId();//넘버를 먼저찾구여
			List<Gym_info> glist = new GymShowAllService().getZzimGyminfo(person);
			
		}
		
		
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("_FORWHERE.jsp?forwhere=8others/HealthMy.jsp");
		dispatcher.forward(request, response);

	}

	public void toMyTrainerZzimPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("액션까지왔습니다!");
		String person = (String) request.getSession().getAttribute("LOG_ID");
		System.out.println("아이디표기!=" + person);
		MemberLogInfo l = new MemberLogInfo();
		l.setId(person);

		List<MemberInfo1> minfo = new MyInfoService().myinfo(l);

		List<PostBean> cposts = new PostService().getMyCPOSTs(person);
		List<ZZIMBean> tz = new ZzimService().select_gym_Z(person); // kkkk
		List<Gym_info> glist = new GymShowAllService().getZzimGyminfo(person);
		List<Trainer_info> tinfo = new ZzimService().select_trainerinfo(person);


		request.setAttribute("tinfo", tinfo);
		request.setAttribute("tz", tz);
		request.setAttribute("minfo", minfo);
		request.setAttribute("cposts", cposts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("_FORWHERE.jsp?forwhere=8others/TrainerMy.jsp");
		dispatcher.forward(request, response);

	}

}
