package com.team7.notice.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.notice.service.*;
import com.team7.vo.ActionForward;
import com.team7.vo.NoticeBean;
import com.team7.vo.PageInfo;


public class NoticeSelectedAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int no = Integer.parseInt(request.getParameter("notice_no"));
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
			
		
		NoticeShowService nser = new NoticeShowService();
		List<NoticeBean> noticeList = new ArrayList<NoticeBean>();
		noticeList = nser.getNotice(no);
		
		ActionForward forward= new ActionForward();
		request.setAttribute("rlist", noticeList);
		forward.setPath("/_FORWHERE.jsp?forwhere=5notice/notice_thatone.jsp");
		return forward;
	}

}
