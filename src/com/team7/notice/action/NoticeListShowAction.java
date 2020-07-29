package com.team7.notice.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team7.notice.service.*;
import com.team7.vo.ActionForward;
import com.team7.vo.DTO_Notice;
import com.team7.vo.PageInfo;


public class NoticeListShowAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
		List<DTO_Notice> noticeList = new ArrayList<DTO_Notice>();
		
		
	  	int page=1;
		int limit=10;

		if(request.getParameter("page")==null){
			page=1;
		}
		else if(request.getParameter("page").equals("null")){
			page=1;
		}
		else if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}

		BoardListService boardListService = new BoardListService();
		int listCount=boardListService.getListCount();
		articleList = boardListService.getArticleList(page,limit);
		//총 페이지 수.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("noticeList", noticeList);
		
		List<DTO_Notice> rlist = new NoticeShowService().showList(i);
		request.setAttribute("rlist", rlist);
		
		ActionForward forward= new ActionForward();
		forward.setPath("/_FORWHERE.jsp?forwhere=5notice/notice_Entire.jsp");
		return null;
	}

}
