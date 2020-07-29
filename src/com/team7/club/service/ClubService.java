package com.team7.club.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.DTO_ClubProperties;
import com.team7.vo.ClubBean;
import com.team7.vo.PageInfo;

public class ClubService {

	
	public void club_creator(DTO_ClubProperties club) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_CreateClub", club); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 
		sqlsession.commit();
		sqlsession.close();
	}
	
	public List<ClubBean> club_selectorAll() {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist = sqlsession.selectList("ClubselectAll");
		sqlsession.close();
		return rlist;
	}
	
	public List<ClubBean> club_selectorAll2(PageInfo i0) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist = sqlsession.selectList("ClubselectAll2", i0);
		sqlsession.close();
		return rlist;
	}
	

	public List<ClubBean> club_selector_no(ClubBean i0) { // 리스트로밖에 ㅇ나됨 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("ClubselectNo", i0);
		sqlsession.close();
		return theclub;
	}
	
	public List<ClubBean> club_selector_id(ClubBean ss) { // 아이디(admin)에 따른 모든 것들. 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("ClubselectID", ss);
		sqlsession.close();
		return theclub;
	}

	public void club_editor(DTO_ClubProperties club) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.update("update_editClub", club); 
		sqlsession.commit();
		sqlsession.close();
	}

	public void club_deletor(DTO_ClubProperties club) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_Club", club); 
		sqlsession.commit();
		sqlsession.close();
	}
}
