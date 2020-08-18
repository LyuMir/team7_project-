package com.team7.post.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.club.service.ClubService;
import com.team7.post.service.PostService;
import com.team7.vo.ClubBean;
import com.team7.vo.PostBean;

public class PostGetAction {

	public void indexGetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ArrayList<List<PostBean>> arr = new ArrayList<List<PostBean>>();
		arr = new PostService().getPOSTsForIndex();
//		arr.get(0).get(0).getTitle()
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> texts = new ArrayList<String>();
		ArrayList<String> authors = new ArrayList<String>();
		ArrayList<Integer> types = new ArrayList<Integer>();
		
//		types.add(0);
		for(int j = 0 ; j < 3; j ++) {
			for(int i = 0 ; i < 3 ; i++) {
				if(arr.get(j).size()>i) {
					titles.add(arr.get(j).get(i).getTitle());
					texts.add(arr.get(j).get(i).getContents());
					authors.add(arr.get(j).get(i).getWriter());
					types.add(j+1);
				}
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div>");
		int size0;
		size0 = Integer.min(Integer.min(titles.size(), texts.size()),authors.size());
		System.out.println(size0);
		for(int i = 0 ; i < size0 ; i++) {
			out.println("<div data-title='"+titles.get(i)+"' data-type='"+types.get(i)+"'");
			out.println(" data-author='"+authors.get(i)+"'     >");
			out.println(texts.get(i));
			out.println("</div>");
		}
		out.println("</div>");
	}
	
	public void indexadGetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<String> rlistlist = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> texts = new ArrayList<String>();
		ArrayList<String> excs = new ArrayList<String>();
//		ArrayList<String> names = new ArrayList<String>();
		List<ClubBean> rlist = new ClubService().zzim_order();
		for (int i = 0; i < rlist.size(); i++) {
			names.add(rlist.get(i).getAdmin());
			titles.add(rlist.get(i).getName());
			texts.add(rlist.get(i).getProfile());
			excs.add(rlist.get(i).getE_type());
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div class='clubs000'>");
		for(int i = 0 ; i < rlist.size();i++) {
			out.print("<div data-title='"+titles.get(i)+"' data-name='"+names.get(i));
			out.print("' data-text='"+texts.get(i)+"'  data-exc='"+excs.get(i)+"'></div>");
		}
		out.println("</div>");
	}
}
