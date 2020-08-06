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
		sqlsession.insert("insert_CreateClub", club); // �����̸���, ������  ... �ҷ��� id , ������ dto�ε�. 
		List<ClubBean> clubBean = sqlsession.selectList("ClubselectID", club);
			System.out.println(clubBean.get(clubBean.size()-1).getNo()+"��� ����..");
		sqlsession.insert("insert_CCMember",clubBean.get(clubBean.size()-1));//�ɱ�??? ��¥ �ɱ�??? �ȴ�. ���� �����ڴ� �ڵ�����...
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
	

	public List<ClubBean> club_selector_no(ClubBean clubBean) { // ����Ʈ�ιۿ� ������ 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("ClubselectNo", clubBean);
		sqlsession.close();
		return theclub;
	}
	
	public List<ClubBean> club_selector_id(ClubBean clubBean) { // ���̵�(admin)�� ���� ��� �͵�. 
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> theclub = sqlsession.selectList("ClubselectID", clubBean);
		sqlsession.close();
		return theclub;
	}
	

	public List<ClubBean> club_selector_cmember(MemberLogInfo id) { // ���̵�(admin)�� ���� ��� �͵�. 
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
