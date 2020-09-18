package com.team7.zzim.service;

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
	
	

	public List<ZZIMBean> select_gyms_ALL(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim1_ALL");
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_trainer_ALL(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim2_ALL");
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_clubs_ALL(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim3_ALL");
		sqlsession.close();
		return rlist;
	}
	

	public List<ZZIMBean> select_gyms_count(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim1_withCount");
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_trainer_count(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim2_withCount");
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_clubs_count(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim3_withCount");
		sqlsession.close();
		return rlist;
	}
	
	

	public List<ZZIMBean> select_gyms_count2(String id){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ZZIMBean zzim = new ZZIMBean();
		zzim.setPerson(id);
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim1_withCount2",zzim);
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_trainer_count2(String id){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ZZIMBean zzim = new ZZIMBean();
		zzim.setPerson(id);
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim2_withCount2",zzim);
		sqlsession.close();
		return rlist;
	}
	public List<ZZIMBean> select_clubs_count2(String id){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ZZIMBean zzim = new ZZIMBean();
		zzim.setPerson(id);
		List<ZZIMBean> rlist = sqlsession.selectList("select_zzim3_withCount2",zzim);
		sqlsession.close();
		return rlist;
	}
	
	
	public List<ZZIMBean> select_gym_Z_YN(String id, int gymno) {

		ZZIMBean zzim = new ZZIMBean();
		zzim.setGym(gymno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist= sqlsession.selectList("select_zzim1_YN", zzim);

		return rlist;
		
	}	
	public List<ZZIMBean> select_trainer_Z_YN(String id, int trainerno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTrainer(trainerno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist= sqlsession.selectList("select_zzim2_YN", zzim);

		return rlist;
		
	}	
	public List<ZZIMBean> select_club_Z_YN(String id, int clubno) {

		ZZIMBean zzim = new ZZIMBean();
		zzim.setClub(clubno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist= sqlsession.selectList("select_zzim3_YN", zzim);

		return rlist;
		
	}
	
	
	
	// ���� �Ʒ��� post���� zzim ��  : team7_&post_zzim
	
	public List<ZZIMBean> select_gpost_Z(String id){
		ZZIMBean zzim = new ZZIMBean();
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_gpost_zzim",zzim);
		
		return rlist;
	}
	public List<ZZIMBean> select_tpost_Z(String id){
		ZZIMBean zzim = new ZZIMBean();
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_tpost_zzim",zzim);
		
		return rlist;
	}
	public List<ZZIMBean> select_cpost_Z(String id){
		ZZIMBean zzim = new ZZIMBean();
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ZZIMBean> rlist = sqlsession.selectList("select_cpost_zzim",zzim);
		
		return rlist;
	}
	
	//���ϱ� 
	public void insert_gpost_Z(String id, int gpostno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setGpost(gpostno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_gpost_z",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void insert_tpost_Z(String id, int tpostno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTpost(tpostno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_tpost_z",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void insert_cpost_Z(String id, int cpostno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setCpost(cpostno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.insert("insert_cpost_z",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	
	// �����
	public void delete_gpost_Z(String id,int gpostno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setGpost(gpostno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_gpost_z",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void delete_tpost_Z(String id,int tpostno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTpost(tpostno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_tpost_z",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
	public void delete_cpost_Z(String id,int cpostno) {
		ZZIMBean zzim = new ZZIMBean();
		zzim.setCpost(cpostno);
		zzim.setPerson(id);
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_cpost_z",zzim);
		sqlsession.commit();
		sqlsession.close();
	}
}
