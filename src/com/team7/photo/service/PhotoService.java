package com.team7.photo.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.dao.Class_DAO;
import com.team7.vo.ClubBean;
import com.team7.vo.PhotoBean;


public class PhotoService {
	
	//Files / clubsphoto / 'id' / main / 'id'_club_main
	public MultipartRequest upload_club_main(HttpServletRequest request, String savefolder, String photoid) throws IOException {
//		System.out.println("사진 넣어봅시다. ");
		
//		boolean ok = false;
		String realFolder="";
//		String saveFolder="/abc";
		if(savefolder ==null) {
			return null;
		}
		if(!savefolder.startsWith("/")) {
			savefolder = "/"+savefolder;
		}
		savefolder = "/Files"+savefolder;
		
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(savefolder);
		File Folder = new File(realFolder);	

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdirs(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다 : "+realFolder);
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		//중복데이터 삭제...
//		String id = (String) request.getSession().getAttribute("LOG_ID");
		int clubid = (Integer) request.getSession().getAttribute("clubid");
		List<PhotoBean> oldphoto = getfilenames_clubmains(clubid);
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_main")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				boolean t =deleteTHIS.delete();	
				System.out.println("예전에 있던 사진 지웁니다...."+t);
				System.out.println(deleteTHIS.getPath());
			}
		}
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		PhotoBean photoBean = new PhotoBean();
		SqlSession sqlsession;
		photoBean.setId(photoid+"_main");
//		photoBean.setPicture(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));

		String ddd= multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		photoBean.setPicture(ddd);
		
		sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_rePICTURE",photoBean); 	//중복 데이터 삭제...
		sqlsession.insert("insert_PICTURE", photoBean); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 

		sqlsession.commit();
		sqlsession.close();

		return multi;
	}
	

	//Files / clubsphoto / 'id' / profile / 'id'_club_profile
	public MultipartRequest upload_club_profile(HttpServletRequest request, String savefolder, String photoid) throws IOException {

		String realFolder="";
//		String saveFolder="/abc";
		if(savefolder ==null) {
			return null;
		}
		if(!savefolder.startsWith("/")) {
			savefolder = "/"+savefolder;
		}
		savefolder = "/Files"+savefolder;
		
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(savefolder);
		File Folder = new File(realFolder);	

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdirs(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다 : "+realFolder);
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		//중복데이터 삭제...
//		String id = (String) request.getSession().getAttribute("LOG_ID");
		int clubid = (Integer) request.getSession().getAttribute("clubid");
		List<PhotoBean> oldphoto = getfilenames_clubmains(clubid);
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_profile")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				boolean t = deleteTHIS.delete();
				System.out.println("예전에 있던 사진 지웁니다...."+t);
				System.out.println(deleteTHIS.getPath());
			}
		}
		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		PhotoBean photoBean = new PhotoBean();
		SqlSession sqlsession;
			photoBean.setId(photoid+"_profile");
			String ddd= multi.getOriginalFileName((String)multi.getFileNames().nextElement());

			photoBean.setPicture(ddd);
			
			sqlsession = new Class_DAO().get_conn().openSession();
			sqlsession.delete("delete_rePICTURE",photoBean); 	//중복 데이터 삭제...
			sqlsession.insert("insert_PICTURE",photoBean);
			sqlsession.commit();
			sqlsession.close();

		return multi;

	}
	
	public List<PhotoBean> getfilenames_clubmains(int clubid) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean pb = new PhotoBean();
		pb.setNo(clubid);
		List<PhotoBean> photos = sqlsession.selectList("select_club_mainphotos",pb);
		sqlsession.close();
		return photos;
	}
	
	
	
	
	// 소모임 포스트에 올리는 사진 업로드 메소드입니다~
	public MultipartRequest upload_post_photo(HttpServletRequest request, String savefolder, String photoid) throws IOException {

		String realFolder="";
		if(savefolder ==null) {
			return null;
		}
		if(!savefolder.startsWith("/")) {
			savefolder = "/"+savefolder;
		}
		savefolder = "/Files"+savefolder;
		
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(savefolder);
		File Folder = new File(realFolder);	

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdirs(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다 : "+realFolder);
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		//중복데이터 삭제...
//		String id = (String) request.getSession().getAttribute("LOG_ID");
		int clubid = (Integer) request.getSession().getAttribute("clubid");
		int cpostid = (Integer) request.getSession().getAttribute("mypostnumber");
//		System.out.println(id+","+cpostid+"라...");
		List<PhotoBean> oldphoto = getfilenames_clubpost(clubid, cpostid);
		for(int i = 0 ; i <oldphoto.size(); i++) {
//			System.out.println(oldphoto.get(i).getId()+"라는...");
			if(oldphoto.get(i).getId().contains("_clubpost")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				boolean t =deleteTHIS.delete();	
				System.out.println("예전에 있던 사진 지웁니다...."+t);
				System.out.println(deleteTHIS.getPath());
			}
		}
		MultipartRequest multi=new MultipartRequest(request,		//한번 더.....???
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		PhotoBean photoBean = new PhotoBean();
		SqlSession sqlsession;
		photoBean.setId(photoid);// 이미 완성되어있음...	

		String ddd= multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		photoBean.setPicture(ddd);
		
		sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_rePICTURE",photoBean); 	//중복 데이터 삭제...
		sqlsession.insert("insert_PICTURE", photoBean);  

		sqlsession.commit();
		sqlsession.close();

		return multi;
	}
	

	public List<PhotoBean> getfilenames_clubpost(int clubid, int num) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean pb = new PhotoBean();
		pb.setId(((Integer)clubid).toString());
		pb.setNo(num);	System.out.println(clubid+"_clubpost_"+num);
		List<PhotoBean> photos = sqlsession.selectList("select_cpost_myphoto",pb);
		sqlsession.close();
		return photos;
	}
	
	public List<PhotoBean> getPs_cpost(int clubno){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		ClubBean clubBean = new ClubBean();
		clubBean.setNo(clubno);
		List<PhotoBean> photos = sqlsession.selectList("select_cpost_photo",clubBean);
		sqlsession.close();
		return photos;
		
	}
}
