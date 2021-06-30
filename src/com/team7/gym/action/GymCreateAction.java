package com.team7.gym.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.gym.action.Action;
import com.team7.gym.service.GymService;
import com.team7.vo.ActionForward;
import com.team7.vo.Gym_info;

public class GymCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session = request.getSession(true);
		String owner= (String)session.getAttribute("LOG_ID"); //오너의 아이디가져오기
		
		
		
//		int no = Integer.parseInt(request.getParameter("no"));
		String gname = request.getParameter("gname");
		System.out.println(gname+"확인용");
		String address_num = request.getParameter("adress_num"); //라디오버튼
		String address = request.getParameter("adress1")+","+request.getParameter("adress2")+","+request.getParameter("address3");
		String gphone = request.getParameter("gphone");
		
		String opentime = request.getParameter("opentime")+","+request.getParameter("fromthistime")+","+request.getParameter("tothistime");
		
		
		String gprice =request.getParameter("oneprice")+","+ request.getParameter("threeprice")
		+","+request.getParameter("sixprice")+","+request.getParameter("yearprice");
	

		//String gtype="";
		String [] gtypeimsi = request.getParameterValues("gtype");
		System.out.println(gtypeimsi[0]+"널인가 널인가널인가");
		
//		for(int i=0 ; i<gtypeimsi.length ; i++) {
//			gtype = gtype+","+gtypeimsi[i];
//			
//		}// 스플릿으로 빼온다. 자동으로 나온 배열 i 넣는다. ;
//		gtype = gtype.substring(1);
		
		
		String contents = request.getParameter("gcontents"); //셀렉트박스
		String gpage =request.getParameter("gpage");
		String gcerti =request.getParameter("gcerti");
		String gprogram = request.getParameter("gprogram");
		String gsmalltext = request.getParameter("gsmalltext");
		
		
		String gtypes="";
		Gym_info gym = new Gym_info();
		if(gtypeimsi ==null) {}
		else {
			for(String sth : gtypeimsi) {
				gtypes +=sth+",";
			}
			gtypes =gtypes.substring(0,gtypes.length()-1);
			gym.setGtype(gtypes);
		}
		
		
		
		gym.setOwner(owner);
		gym.setGname(gname);
		gym.setAddress_num(address_num);
		gym.setAddress(address);
		gym.setGphone(gphone);
		gym.setOpentime(opentime);
		gym.setGprice(gprice);
		//gym.setGtype(gtype);
		gym.setContents(contents);
		gym.setGpage(gpage);
		gym.setGcerti(gcerti);
		gym.setGprogram(gprogram);
		gym.setGsmalltext(gsmalltext);
//		
//		System.out.println(owner);
//		System.out.println(gname);
//		System.out.println(address_num);
//		
//		System.out.println(address);
//		System.out.println(gsmalltext);
//		System.out.println(gphone);
//		System.out.println(opentime);
//		System.out.println(gprice);
//		System.out.println(gtype);
//		System.out.println(contents);
//		System.out.println(gpage);
//		System.out.println(gcerti);
		
		
		GymService gser = new GymService();
		gser.insert(gym);
		System.out.println("서비스로갔음 ");
		
		ActionForward forward= new ActionForward();
		forward.setPath("index.jsp");
		return forward;
	} 

}
