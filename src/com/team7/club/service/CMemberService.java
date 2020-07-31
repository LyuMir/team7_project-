package com.team7.club.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.C_enroll_Bean;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;
import com.team7.vo.MemberLogInfo;

public class CMemberService {


	public List<CmemberBean> cmember_selector(ClubBean clubBean){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<CmemberBean> members = sqlsession.selectList("select_C_members",clubBean);
		sqlsession.close();
		return members;
		
	}
	
	public void member_toCLUB(CmemberBean cmember) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_cmem",cmember);
		sqlsession.commit();
		sqlsession.close();
	}
	
	public void c_letme(C_enroll_Bean enroll) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_enroll",enroll);
		sqlsession.commit();
		sqlsession.close();
	}
	
	
//	public List<C_enroll_Bean> c_enroll_selector(ClubBean clubBean){
//		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
//		List<C_enroll_Bean> papers = sqlsession.selectList("select_C_enrolls",clubBean);
//		sqlsession.close();
//		return papers;
//	}
	
}
