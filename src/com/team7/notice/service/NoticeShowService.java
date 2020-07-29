package com.team7.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.DTO_Notice;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class NoticeShowService {

	public List<DTO_Notice> getNoticeList(int page) {

		PageInfo pageinfo = new PageInfo();
		pageinfo.setPage(page);
		
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<DTO_Notice> rlist= sqlsession.selectList("select_List_Notice", pageinfo);
		sqlsession.close();
		
		
		return rlist;
	}
	
	public int getListCount() {
	
		int num=0;

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PageInfo> rlist= sqlsession.selectList("select_ListCount_Notice");
		sqlsession.close();
		num= rlist.get(0).getPage();
		System.out.println(num+"������� ����");
		return num;
	}
	
	
	public List<DTO_Notice> getNotice(int no) {

		DTO_Notice notice = new DTO_Notice();
		notice.setNo(no);
		
		
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<DTO_Notice> rlist= sqlsession.selectList("select_Notice", notice);
		sqlsession.close();
		
		
		return rlist;
	}
}
