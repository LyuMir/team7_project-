package com.team7.zzim.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.NoticeBean;
import com.team7.vo.ZZIMBean;

public class ZzimService {

	public void insert_Gym(ZZIMBean zzim) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_ZGym",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void insert_Trainer(ZZIMBean zzim) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_ZTrainer",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void insert_Club(ZZIMBean zzim) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_ZClub",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	
	
	public void delete_Gym(ZZIMBean zzim) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_ZGym", zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void delete_Trainer(ZZIMBean zzim) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_ZTrainer", zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void delete_Club(ZZIMBean zzim) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_ZClub", zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	
	public List<ZZIMBean> select_gyms(int gymno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ZZIMBean zzim = new ZZIMBean();
		zzim.setGym(gymno);
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim1", zzim);
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_trainer(int trainerno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTrainer(trainerno);
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim2", zzim);
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_clubs(int clubno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ZZIMBean zzim = new ZZIMBean();
		zzim.setClub(clubno);
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim3", zzim);
		sqlsession.close();
		return rlist;
	}
	
}
