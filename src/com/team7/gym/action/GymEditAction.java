package com.team7.gym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.service.*;
import com.team7.photo.service.PhotoGymService;
import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;
import com.team7.vo.PageInfo;
import com.team7.vo.PhotoBean;
import com.team7.vo.PostBean;
import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;



public class GymEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


		HttpSession session = request.getSession(true);
		String owner= (String)session.getAttribute("LOG_ID"); //������ ���̵�������
		
//		int no = Integer.parseInt(request.getParameter("no"));
//		String gname = request.getParameter("gname");
		String address_num = request.getParameter("sample4_postcode"); //������ư
		String address = request.getParameter("adress1")+","+request.getParameter("adress2")+","+request.getParameter("address3");
		String gphone = request.getParameter("gphone");
		
		String opentime = request.getParameter("opentime")+","+request.getParameter("fromthistime")+","+request.getParameter("tothistime");
		
		
		String gprice =request.getParameter("oneprice")+","+ request.getParameter("threeprice")
		+","+request.getParameter("sixprice")+","+request.getParameter("yearprice");
	

		String gtype="";
		String [] gtypeimsi = request.getParameterValues("gtype");
		for(int i=0 ; i<gtypeimsi.length ; i++) {
			gtype = gtype+","+gtypeimsi[i];
			
		}// ���ø����� ���´�. �ڵ����� ���� �迭 i �ִ´�. ;
		gtype = gtype.substring(1);
		
		
		String contents = request.getParameter("gcontents"); //����Ʈ�ڽ�
		String gpage =request.getParameter("gpage");
		String gcerti =request.getParameter("gcerti");
		String gprogram = request.getParameter("gprogram");
		String gsmalltext = request.getParameter("gsmalltext");
		
		
		
		Gym_info gym = new Gym_info();
		
		gym.setOwner(owner);
		//gym.setGname(gname);
		gym.setAddress_num(address_num);
		gym.setAddress(address);
		gym.setGphone(gphone);
		gym.setOpentime(opentime);
		gym.setGprice(gprice);
		gym.setGtype(gtype);
		gym.setContents(contents);
		gym.setGpage(gpage);
		gym.setGcerti(gcerti);
		gym.setGprogram(gprogram);
		gym.setGsmalltext(gsmalltext);
		

		GymService gser = new GymService();
		gser.update_gym(gym);
		
		ActionForward forward = new ActionForward();
		forward.setPath("Mng.health");
		return forward;
		
	}

}
