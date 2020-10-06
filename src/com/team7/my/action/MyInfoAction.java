package com.team7.my.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.gym.service.GymService;
import com.team7.gym.service.GymShowAllService;
import com.team7.my.service.MyInfoService;
import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PostBean;
import com.team7.vo.ZZIMBean;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.zzim.*;
import com.team7.zzim.service.ZzimService;


public class MyInfoAction {

	public void toMyInfoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = (String) request.getSession().getAttribute("LOG_ID");
		
		MemberLogInfo l = new MemberLogInfo();
		l.setId(id);
		
		List<MemberInfo1> minfo = new MyInfoService().myinfo(l);
		
		List<PostBean> cposts = new PostService().getMyCPOSTs(id);
		
		request.setAttribute("minfo", minfo);
		request.setAttribute("cposts", cposts);
		

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("_FORWHERE.jsp?forwhere=8others/Mypage.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	public void infoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String postcode = request.getParameter("sample4_postcode22");
		String adress = request.getParameter("adress");
		String dadress = request.getParameter("sample4_detailAddress");
		String interest = request.getParameter("interest");
		
		MemberInfo1 minfo = new MemberInfo1();
		minfo.setAddress(adress+dadress);
		minfo.setAddress_num(postcode);
		minfo.setName(name);
		minfo.setInterest(interest);
		
		new MyInfoService().myinfoedit(minfo);

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("id_myinfo.log");
		dispatcher.forward(request, response);
	}
	
public void toMyHealthZzimPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("액션까지왔습니다!");
		String person = (String) request.getSession().getAttribute("LOG_ID");
	
		System.out.println("아이디표기!="+person);
		MemberLogInfo l = new MemberLogInfo();
		l.setId(person);
		
		List<MemberInfo1> minfo = new MyInfoService().myinfo(l);
		
		List<PostBean> cposts = new PostService().getMyCPOSTs(person);
		List<ZZIMBean> gz =  new ZzimService().select_gym_Z(person); //kkkk
		//List<Gym_info> glist =  new GymShowAllService().getZzimGyminfo(dddd);
		List<Gym_info> ginfo = new ZzimService().select_gyminfo(person);
		
		request.setAttribute("ginfo", ginfo);
		request.setAttribute("gz", gz);
		request.setAttribute("minfo", minfo);
		request.setAttribute("cposts", cposts);
		

		RequestDispatcher dispatcher=
				request.getRequestDispatcher("_FORWHERE.jsp?forwhere=8others/HealthMy.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
