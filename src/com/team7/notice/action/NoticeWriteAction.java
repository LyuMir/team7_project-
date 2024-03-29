package com.team7.notice.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.notice.service.*;
import com.team7.vo.ActionForward;
import com.team7.vo.NoticeBean;
import com.team7.vo.PageInfo;


public class NoticeWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
//		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NoticeBean notice = new NoticeBean();
		notice.setContent(content);
		notice.setTitle(title);
		notice.setWriter(writer);
		
		
		NoticeService nser = new NoticeService();
		nser.insert(notice);;
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("noticeshow.notice"); //jsp 로 가던지 기능을 부르던지  //
		return forward;
	}

}
