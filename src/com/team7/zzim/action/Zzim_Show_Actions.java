package com.team7.zzim.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ZZIMBean;
import com.team7.zzim.controller.ZzimService;

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
}
