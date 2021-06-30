package com.team7.gym.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Gym_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;
import com.team7.vo.Trainer_info;

public class GymService {

	

	public void insert (Gym_info gym) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_Gym",gym);
		sqlsession.commit();
		sqlsession.close();
		
	}
	
	
	public List<Gym_info> select_mygym_prof(String gymowner){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		Gym_info gym = new Gym_info();
		gym.setOwner(gymowner);
		List<Gym_info> rlist = sqlsession.selectList("select_GYM_by_Owner",gym);
		sqlsession.close();
		return rlist;
	}
	public void update_gym(Gym_info info) {
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.update("update_gym_info",info);
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
