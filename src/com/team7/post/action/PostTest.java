package com.team7.post.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.post.service.PostService;
import com.team7.vo.ActionForward;
import com.team7.vo.PostBean;

public class PostTest {
public ActionForward TestindexGetter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ArrayList<List<PostBean>> arr = new ArrayList<List<PostBean>>();
		arr = new PostService().getPOSTsForIndex();
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> texts = new ArrayList<String>();
		ArrayList<String> authors = new ArrayList<String>();
		ArrayList<Integer> types = new ArrayList<Integer>();
		
		List<PostBean> gym = arr.get(0);
		System.out.println("다시확인합니다"+gym.get(0).getTitle());
		List<PostBean> trainer = arr.get(0);
		List<PostBean> club = arr.get(0);
//		types.add(0);
		request.setAttribute("gym", gym);
		response.setContentType("text/html;charset=UTF-8");
		ActionForward forward= new ActionForward();
		forward.setPath("_FORWHERE.jsp?forwhere=.index.jsp");
		return forward;
	}
}
