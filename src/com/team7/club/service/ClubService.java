package com.team7.club.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.DTO_ClubProperties;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.ClubBean;
import com.team7.vo.PageInfo;

public class ClubService {

	
	public void club_creator(ClubBean club) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_CreateClub", club); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 
		List<ClubBean> clubBean = sqlsession.selectList("ClubselectID", club);
			System.out.println(clubBean.get(clubBean.size()-1).getNo()+"라는 놈의..");
		sqlsession.insert("insert_CCMember",clubBean.get(clubBean.size()-1));//될까??? 진짜 될까??? 된다. 이제 개설자는 자동으로...
		sqlsession.commit();
		sqlsession.close();
	}
	
	public List<ClubBean> club_selectorAll() {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist = sqlsession.selectList("ClubselectAll");
		sqlsession.close();
		return rlist;
	}
	
	public List<ClubBean> club_selectorAll2(PageInfo pageInfo) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist = sqlsession.selectList("ClubselectAll2", pageInfo);
		sqlsession.close();
		return rlist;
	}
	

	public List<ClubBean> club_selector_no(ClubBean clubBean) { // 리스트로밖에 ㅇ나됨 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("ClubselectNo", clubBean);
		sqlsession.close();
		return theclub;
	}
	
	public List<ClubBean> club_selector_id(ClubBean clubBean) { // 아이디(admin)에 따른 모든 것들. 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("ClubselectID", clubBean);
		sqlsession.close();
		return theclub;
	}
	

	public List<ClubBean> club_selector_cmember(MemberLogInfo id) { // 아이디(admin)에 따른 모든 것들. 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("Select_club_by_Member", id);
		sqlsession.close();
		return theclub;
	}

	public void club_editor(ClubBean clubBean) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.update("update_editClub", clubBean); 
		sqlsession.commit();
		sqlsession.close();
	}

	public void club_deletor(ClubBean clubBean) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_Club", clubBean); 
		sqlsession.commit();
		sqlsession.close();
	}
}
