package com.team7.trainer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Trainer_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class TrainerMypageService {

	public List<Trainer_info> getTrainerMyinfo(Trainer_info info) {

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		System.out.print("겟 트레이너 마이인포입니다");
		
		
		List<Trainer_info> tser = sqlsession.selectList("selectMy_Trainer",info);
		
		
		
		
		System.out.println(tser.get(0).getId() +"된건가");
		System.out.println(tser.get(0).getTbigtext()+"된건가?");
		
		
		System.out.println(tser.get(0).getTtime());
		

		System.out.print("여기는?");

		sqlsession.close();
		
		return tser;
		
	}
	



	
	public List<Trainer_info> getmajor(int no) {

	Trainer_info trainerinfo = new Trainer_info();
	trainerinfo.setNo(no);
	
	
	
	SqlSession sqlsession = new Class_DAO().get_conn().openSession();
	List<Trainer_info> TrainerList= sqlsession.selectList("select_Notice", trainerinfo);
	sqlsession.close();
	
	
		return TrainerList;
	}





//	public List<Trainer_info> getTrainerMyinfo(Trainer_info info) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	}

