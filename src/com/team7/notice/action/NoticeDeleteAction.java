package com.team7.notice.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.notice.service.*;
import com.team7.vo.ActionForward;
import com.team7.vo.DTO_Notice;
import com.team7.vo.PageInfo;


public class NoticeDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		NoticeService nser = new NoticeService();
		int no = Integer.parseInt(request.getParameter("no"));
		nser.delete(no);
		
		ActionForward forward= new ActionForward();
		forward.setPath("noticeshow.notice");
		return forward;
	}

}
