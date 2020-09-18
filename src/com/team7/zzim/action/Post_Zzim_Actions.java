package com.team7.zzim.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;

public class Post_Zzim_Actions {

	// Âò°¹¼ö ¹× ³» Âò º¸¿©ÁÖ±â 
	public void show_gposts_zzims(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//String gymno = request.getParameter("gymno");
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		
		
		List<ZZIMBean> zzim = new ZzimService().select_gpost_Z(person);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		for(int i = 0 ; i <zzim.size(); i++) {
			out.print("<div data-gpost=\"");
			out.print(zzim.get(i).getGpost());
			out.print("\" data-num=\"");
			out.print(zzim.get(i).getCount());
			out.print("\" data-youzzim=\"");
			out.print(zzim.get(i).getZzimed());
			out.print("\" >");
			out.print("</div>");
		}
		out.close();
	}
	public void show_tposts_zzims(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//String traierno = request.getParameter("traierno");
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		
		
		List<ZZIMBean> zzim = new ZzimService().select_tpost_Z(person);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		for(int i = 0 ; i <zzim.size(); i++) {
			out.print("<div data-tpost=\"");
			out.print(zzim.get(i).getTpost());
			out.print("\" data-num=\"");
			out.print(zzim.get(i).getCount());
			out.print("\" data-youzzim=\"");
			out.print(zzim.get(i).getZzimed());
			out.print("\" >");
			out.print("</div>");
		}
		out.close();
	}
	public void show_cposts_zzims(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//String clubid = request.getParameter("clubno");
		HttpSession session = request.getSession();
		String person = (String) session.getAttribute("LOG_ID");
		//boolean youzzim = false;
		
		List<ZZIMBean> zzim = new ZzimService().select_cpost_Z(person);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		for(int i = 0 ; i <zzim.size(); i++) {
			out.print("<div data-cpost=\"");
			out.print(zzim.get(i).getCpost());
			out.print("\" data-num=\"");
			out.print(zzim.get(i).getCount());
			out.print("\" data-youzzim=\"");
			out.print(zzim.get(i).getZzimed());
			out.print("\" >");
			out.print("</div>");
		}
		out.close();
	}
	
	//ÂòÇÏ±â
	public void gpost_zzim(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int gpostno = Integer.parseInt(request.getParameter("no"));
		
		new ZzimService().insert_gpost_Z(id, gpostno);
	}
	public void tpost_zzim(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int tpostno = Integer.parseInt(request.getParameter("no"));
		
		new ZzimService().insert_tpost_Z(id, tpostno);
	}
	public void cpost_zzim(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int cpostno = Integer.parseInt(request.getParameter("no"));
		new ZzimService().insert_cpost_Z(id, cpostno);
	}
	
	//Âò Ãë¼Ò
	public void gpost_zzimC(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int gpostno = Integer.parseInt(request.getParameter("no"));
		
		new ZzimService().delete_gpost_Z(id, gpostno);
	}
	public void tpost_zzimC(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int tpostno = Integer.parseInt(request.getParameter("no"));
		
		new ZzimService().delete_tpost_Z(id, tpostno);
	}
	public void cpost_zzimC(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int cpostno = Integer.parseInt(request.getParameter("no"));
		
		new ZzimService().delete_cpost_Z(id, cpostno);
	}
}
