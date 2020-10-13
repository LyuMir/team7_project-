package com.team7.zzim.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;

public class Zzim_Show_Actions {

	public void club_show(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String clubid = request.getParameter("clubid");
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		boolean youzzim = false;
		
		List<ZZIMBean> zzim = new ZzimService().select_clubs(Integer.parseInt(clubid));
		
		int howmany = zzim.size();
		String bywhom="";
		for(int i = 0 ; i < zzim.size(); i++) {
			bywhom +=zzim.get(i).getPerson();
			if(zzim.get(i).getPerson().equals(person)) {
				youzzim=true;
			}
		}
		if(bywhom.equals("")) {
			bywhom="아직 하트를 누른 사람이 없습니다. 하트를 눌러보세요!";
		}
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
//		out.println("에이젝스로 이런 문구가 간다는 말이지...?");
		out.print("<div data-number=\"");
		out.print(howmany);
		out.print("\" data-people=\"");
		out.print(bywhom);
		out.print("\" data-youzzim=\"");
		out.print(youzzim);
		out.print("\" >");
		out.print("</div>");
		out.close();
	}
	
	
	
	//헬스찜목록 액션
	
	
	
	public void club_show_count_nolog(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<ZZIMBean> zzim = new ZzimService().select_clubs_count();
		
		System.out.println("몇번이나 오는거냐.");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<div class='datasss'><div id = \"");
		for(int i = 0 ; i < zzim.size(); i++) {
			int club = zzim.get(i).getClub();
			int count = zzim.get(i).getCount();
			out.print(club);
			out.print("\" data-count=");
			out.print(count);
			out.print(" ></div>  <div id =\"");
		}
		out.print("nothing..\"></div></div>");
		
	}
	
	public void club_show_count(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		
		List<ZZIMBean> zzim = new ZzimService().select_clubs_count2(person);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<div class='datasss'><div id = \"");
		for(int i = 0 ; i < zzim.size(); i++) {
			int club = zzim.get(i).getClub();
			int count = zzim.get(i).getCount();
			int zzimed = zzim.get(i).getZzimed();
			out.print(club);
			out.print("\" data-count=");
			out.print(count);
			out.print(" data-zzimed=");
			out.print(zzimed);
			out.print(" ></div>  <div id =\"");
		}
		out.print("nothing..\"></div></div>");
	}
}
