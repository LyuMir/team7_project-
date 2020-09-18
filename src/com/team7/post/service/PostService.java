package com.team7.post.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.PostBean;
import com.team7.vo.Trainer_info;
import com.team7.vo.ClubBean;
import com.team7.vo.Gym_info;
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
	public List<PostBean> getTPOSTnum(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PostBean> posts = sqlsession.selectList("select_TPOST");
		sqlsession.close();
		return posts;
	}
	
	public List<PostBean> getGPOSTs(int gymno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(gymno);
		List<PostBean> cposts = sqlsession.selectList("select_GPOST_by_gymno",clubBean);
		sqlsession.close();
		return cposts;
	}
	public List<PostBean> getGPOSTnum(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PostBean> posts = sqlsession.selectList("select_GPOST");
		sqlsession.close();
		return posts;
	}
	

	public ArrayList<List<PostBean>> getPOSTsForIndex(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PostBean> post1 = sqlsession.selectList("select_POST_for_index1");
		List<PostBean> post2 = sqlsession.selectList("select_POST_for_index2");
		List<PostBean> post3 = sqlsession.selectList("select_POST_for_index3");
		ArrayList<List<PostBean>> posts = new ArrayList<List<PostBean>>();
		posts.add(post1);
		posts.add(post2);
		posts.add(post3);
		sqlsession.close();
		return posts;
	}
	
	public List<Gym_info> getAdForIndex1(){	// 고쳐 써야 한다!!!
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<Gym_info> rlist1 = sqlsession.selectList("");	//어ㅕ기!!!
		sqlsession.close();
		return rlist1;
	}
	public List<Trainer_info> getAdForIndex2(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<Trainer_info> rlist2 = sqlsession.selectList("");
		sqlsession.close();
		return rlist2;
	}
	public List<ClubBean> getAdForIndex3(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<ClubBean> rlist3	 = sqlsession.selectList("");
		sqlsession.close();
		return rlist3;
	}
	
	
	// delete
	public void deleteCpost(int postno) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_Cpost",postno);
		sqlsession.commit();
		sqlsession.close();
	}
	public void deleteGpost(int postno) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_Gpost",postno);
		sqlsession.commit();
		sqlsession.close();
		
	}
	public void deleteTpost(int postno) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_Tpost",postno);
		sqlsession.commit();
		sqlsession.close();
		
	}
}
