package com.team7.zzim.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;

public class Zzim_Club_Actions {

	public void clubZ(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�Ҹ��� ���ϱ� Ŭ����. 
		int clubid = Integer.parseInt(request.getParameter("clubid"));
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		
		System.out.println("�Ҹ��� ���ϴ� �� ..."+clubid+","+person);
		ZZIMBean zzim = new ZZIMBean();
		zzim.setClub(clubid);
		zzim.setPerson(person);
		System.out.println(zzim.getPerson());
		System.out.println(zzim.getClub());
		new ZzimService().insert_Club(zzim);
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("���������� �̷� ������ ���ٴ� ������...?");
	}
	
	public void clubZ_cancle(HttpServletRequest request, HttpServletResponse response) {
		//�Ҹ��� �� ��ҽ�. 
		int clubid = Integer.parseInt(request.getParameter("clubid"));
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		System.out.println("�Ҹ��� �� ����ϴ� �� ..."+clubid+","+person);
		
		ZZIMBean zzim = new ZZIMBean();
		zzim.setClub(clubid);
		zzim.setPerson(person);
		new ZzimService().delete_Club(zzim);
		
		
	}
}
