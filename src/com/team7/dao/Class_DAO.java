package com.team7.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Class_DAO {
	
	SqlSessionFactory sqlF;
	public SqlSessionFactory get_conn() {
		SqlSessionFactory sqlF2 = null;
		Reader xml;
		try {
			xml = Resources.getResourceAsReader("com/team7/dao/mybatis_config.xml");
			sqlF2 = new SqlSessionFactoryBuilder().build(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlF2;
	}
//	
//	
//	public void club_creator(dtos.Class_DTO_ClubProperties club) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.insert("insert_CreateClub", club); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	
//	public List<dtos.Class_DTO_ClubProperties2> club_selectorAll() {
//		SqlSession sqlsession = get_conn().openSession();
//		List<dtos.Class_DTO_ClubProperties2> rlist = sqlsession.selectList("ClubselectAll");
//		sqlsession.close();
//		return rlist;
//	}
//	
//	public List<dtos.Class_DTO_ClubProperties2> club_selectorAll2(dtos.Class_DTO_i i0) {
//		SqlSession sqlsession = get_conn().openSession();
//		List<dtos.Class_DTO_ClubProperties2> rlist = sqlsession.selectList("ClubselectAll2", i0);
//		sqlsession.close();
//		return rlist;
//	}
//	
//
//	public List<dtos.Class_DTO_ClubProperties2> club_selector_no(dtos.Class_DTO_i i0) { // 리스트로밖에 ㅇ나됨 
//		SqlSession sqlsession = get_conn().openSession();
//		List<dtos.Class_DTO_ClubProperties2> theclub = sqlsession.selectList("ClubselectNo", i0);
//		sqlsession.close();
//		return theclub;
//	}
//	
//	public List<dtos.Class_DTO_ClubProperties2> club_selector_id(dtos.Class_DTO_String ss) { // 아이디(admin)에 따른 모든 것들. 
//		SqlSession sqlsession = get_conn().openSession();
//		List<dtos.Class_DTO_ClubProperties2> theclub = sqlsession.selectList("ClubselectID", ss);
//		sqlsession.close();
//		return theclub;
//	}
//
//	public void club_editor(dtos.Class_DTO_ClubProperties club) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.update("update_editClub", club); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//
//	public void club_deletor(dtos.Class_DTO_ClubProperties club) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.delete("delete_Club", club); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	
//
//	public List<dtos.Class_DTO_Notice> notice_selectorAll() {
//		SqlSession sqlsession = get_conn().openSession();
//		List<dtos.Class_DTO_Notice> rlist = sqlsession.selectList("NoticeselectAll");
//		sqlsession.close();
//		return rlist;
//	}
//	public List<dtos.Class_DTO_Notice> notice_selectThatone(dtos.Class_DTO_i i0) {
//		SqlSession sqlsession = get_conn().openSession();
//		List<dtos.Class_DTO_Notice> rlist = sqlsession.selectList("NoticeselectTHATONE",i0);
//		sqlsession.close();
//		return rlist;
//	}
//	public void notice_input(dtos.Class_DTO_Notice notice) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.insert("insert_Notice", notice); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	public void notice_edit(dtos.Class_DTO_Notice notice) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.update("update_Notice", notice); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	public void notice_delete(dtos.Class_DTO_Notice notice) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.delete("delete_Club", notice); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	
//
//	public void trainer_creator(dtos.Class_DTO_Trainer trainer) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.insert("insert_Trainer", trainer); // 
//		sqlsession.commit();
//		sqlsession.close();
//	}
}
