package com.team7.trainer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Trainer_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class TrainerUserpageService {

	public List<Trainer_info> getTrainerOneinfo(Trainer_info info) {

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		
		List<Trainer_info> tser = sqlsession.selectList("selectOne_Trainer",info);
		
		System.out.println(tser.get(0).getId());
		System.out.println(tser.get(0).getTbigtext());

		System.out.print("¿©±â´Â?");

		sqlsession.close();
		
		return tser;
		
	}
	
	
	public List<Trainer_info> getmaintext(int no) {

		Trainer_info trainerinfo = new Trainer_info();
		trainerinfo.setNo(no);
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<Trainer_info> TrainerList= sqlsession.selectList("select_Notice", trainerinfo);
		sqlsession.close();
		
		
		return TrainerList;
	}


	public List<Trainer_info> getsmalltext(int no) {

	Trainer_info trainerinfo = new Trainer_info();
	trainerinfo.setNo(no);
	
	SqlSession sqlsession = new Class_DAO().get_conn().openSession();
	List<Trainer_info> TrainerList= sqlsession.selectList("select_Notice", trainerinfo);
	sqlsession.close();
	
	
		return TrainerList;
	}
	
	
	public List<Trainer_info> getmajor(int no) {

	Trainer_info trainerinfo = new Trainer_info();
	trainerinfo.setNo(no);
	
	SqlSession sqlsession = new Class_DAO().get_conn().openSession();
	List<Trainer_info> TrainerList= sqlsession.selectList("select_Notice", trainerinfo);
	sqlsession.close();
	
	
		return TrainerList;
	}


	
	}

