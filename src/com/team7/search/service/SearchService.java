package com.team7.search.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.ClubBean;

public class SearchService {
	
	
	public List<ClubBean> search_name(String str){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist = sqlsession.selectList("Select_club_by_search_name");
		sqlsession.close();
		return rlist;
	}
	public List<ClubBean> search_exc(String str){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist = sqlsession.selectList("Select_club_by_search_exc");
		sqlsession.close();
		return rlist;
	}
	
//	public List<>
}
