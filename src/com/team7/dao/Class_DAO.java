package com.team7.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.team7.vo.*;

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
//
//	public List<DTO_Notice> notice_selectorAll() {
//		SqlSession sqlsession = get_conn().openSession();
//		List<DTO_Notice> rlist = sqlsession.selectList("NoticeselectAll");
//		sqlsession.close();
//		return rlist;
//	}
//	public List<DTO_Notice> notice_selectThatone(DTO_i i0) {
//		SqlSession sqlsession = get_conn().openSession();
//		List<DTO_Notice> rlist = sqlsession.selectList("NoticeselectTHATONE",i0);
//		sqlsession.close();
//		return rlist;
//	}
//	public void notice_input(DTO_Notice notice) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.insert("insert_Notice", notice); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	public void notice_edit(DTO_Notice notice) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.update("update_Notice", notice); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	public void notice_delete(DTO_Notice notice) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.delete("delete_Club", notice); 
//		sqlsession.commit();
//		sqlsession.close();
//	}
//	
//
//	public void trainer_creator(DTO_Trainer trainer) {
//		SqlSession sqlsession = get_conn().openSession();
//		sqlsession.insert("insert_Trainer", trainer); // 
//		sqlsession.commit();
//		sqlsession.close();
//	}
}
