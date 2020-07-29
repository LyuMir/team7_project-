package com.team7.trainer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.notice.action.Action;
import com.team7.notice.service.NoticeService;
import com.team7.vo.ActionForward;
import com.team7.vo.DTO_Notice;

public class TrainerCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
//		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		DTO_Notice notice = new DTO_Notice();
		notice.setContent(content);
		notice.setTitle(title);
		notice.setWriter(writer);
		
		
		NoticeService nser = new NoticeService();
		nser.insert(notice);;
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("noticeshow.notice");
		return forward;
	} 

}
