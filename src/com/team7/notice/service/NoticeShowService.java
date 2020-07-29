package com.team7.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.DTO_Notice;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class NoticeShowService {

	public List<DTO_Notice> getNoticeList(int page, int limit) {

		PageInfo page = new PageInfo();
		page.setPage(i);
		
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<DTO_Notice> rlist= sqlsession.selectList("select_List_Notice", page);
		sqlsession.close();
		
		
		return rlist;
	}
}
