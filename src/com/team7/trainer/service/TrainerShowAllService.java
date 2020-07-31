package com.team7.trainer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Trainer_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class TrainerShowAllService {

	public List<Trainer_info> getTrianerinfo(int page) {

		PageInfo pageinfo = new PageInfo();
		pageinfo.setPage(page);
		
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<Trainer_info> rlist= sqlsession.selectList("select_List_Notice", pageinfo);
		sqlsession.close();
		
		
		return rlist;
	}
	
	public int getListCount() {
	
		int num=0;

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PageInfo> rlist= sqlsession.selectList("select_ListCount_Notice");
		sqlsession.close();
		num= rlist.get(0).getPage();
		System.out.println(num+"여기까지 왓음");
		return num;
	}
	
	
	public List<Trainer_info> getNotice(int no) {

		Trainer_info notice = new NoticeBean();
		notice.setNo(no);
		
		
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<Trainer_info> rlist= sqlsession.selectList("select_Notice", notice);
		sqlsession.close();
		
		
		return rlist;
	}
}
