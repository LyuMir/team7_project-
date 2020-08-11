package com.team7.post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.PostBean;
import com.team7.vo.ClubBean;
import com.team7.vo.MemberLogInfo;

public class PostService {

	public void cpostPOST(PostBean pbean) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_CPOST",pbean);
		sqlsession.commit();
		sqlsession.close();
		
	}

	public void gpostPOST(PostBean pbean) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_GPOST",pbean);
		sqlsession.commit();
		sqlsession.close();
		
	}

	public void tpostPOST(PostBean pbean) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_TPOST",pbean);
		sqlsession.commit();
		sqlsession.close();
		
	}
	
	
	public List<PostBean> getCPOSTs(int clubno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(clubno);
		List<PostBean> cposts = sqlsession.selectList("select_CPOST_by_Clubno",clubBean);
		sqlsession.close();
		return cposts;
	}
	

	public List<PostBean> getMyCPOSTs(String id){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		MemberLogInfo lin = new MemberLogInfo();
		lin.setId(id);
		List<PostBean> cposts = sqlsession.selectList("select_CPOST_by_writer",lin);
		sqlsession.close();
		return cposts;
	}
	
	
	
	public List<PostBean> getTPOSTs(int trainerno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(trainerno);
		List<PostBean> cposts = sqlsession.selectList("select_TPOST_by_trainerno",clubBean);
		sqlsession.close();
		return cposts;
	}
	public List<PostBean> getGPOSTs(int gymno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(gymno);
		List<PostBean> cposts = sqlsession.selectList("select_GPOST_by_gymno",clubBean);
		sqlsession.close();
		return cposts;
	}
}
