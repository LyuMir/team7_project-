package com.team7.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.CPostBean;
import com.team7.vo.ClubBean;

public class PostClubService {

	public void cpostPOST(CPostBean pbean) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_CPOST",pbean);
		sqlsession.commit();
		sqlsession.close();
		
	}
	
	
	public List<CPostBean> getCPOSTs(int clubno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(clubno);
		List<CPostBean> cposts = sqlsession.selectList("select_CPOST_by_Clubno",clubBean);
		sqlsession.close();
		return cposts;
	}
}
