package com.team7.trainer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Trainer_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class TrainerService {

	
	
	public void delete(int no) {
		
		
		Trainer_info trainer = new Trainer_info();
		trainer.setNo(no);
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_Trainer", trainer);
		sqlsession.commit();
		sqlsession.close();
		
	}
	
	public void edit(Trainer_info trainer) {

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.update("update_Trainer",trainer);
		sqlsession.commit();
		sqlsession.close();
	}
	public void insert(Trainer_info trainer) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_Trainer",trainer);
		sqlsession.commit();
		sqlsession.close();
		
	}
//	public List<DTO_Notice> getNoticeList(int page) {
//
//		PageInfo pageinfo = new PageInfo();
//		pageinfo.setPage(page);
//		
//		
//		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
//		List<DTO_Notice> rlist= sqlsession.selectList("select_List_Notice", pageinfo);
//		sqlsession.close();
//		
//		
//		return rlist;
//	}
//	
//	public int getListCount() {
//	
//		int num=0;
//
//		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
//		List<PageInfo> rlist= sqlsession.selectList("select_ListCount_Notice");
//		sqlsession.close();
//		num= rlist.get(0).getPage();
//		System.out.println(num+"여기까지 왓음");
//		return num;
//	}
}
