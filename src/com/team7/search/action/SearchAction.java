package com.team7.search.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.search.service.SearchService;
import com.team7.vo.ClubBean;

public class SearchAction {

	SearchService ser = new SearchService();
	
	////////////////////// ����!!!!!!!!!!!!!!! ������!!!! �ʽ��ϴ�!!!!!!!!!!!!!
	public void clubname(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String search = request.getParameter("search");
		List<ClubBean> rlist =ser.search_name(search);
		System.out.println(search+"�� �˻� . . .");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<div class='theResult'>");
//		out.print("[");
		for(int i = 0 ; i < rlist.size() - 1;i++) {
			out.print(rlist.get(i).getNo()+",");
		}
		out.print(rlist.get(rlist.size()-1).getNo());
//		out.print("]");		//�� script���� split �Ҳ��� �ʿ� ����
		out.print("</div>");
		
		
	}
	
	public void clubexc(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
	}
}
