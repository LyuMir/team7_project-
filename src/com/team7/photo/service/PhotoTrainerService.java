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


public class PhotoTrainerService {
	
	//Files / clubsphoto / 'id' / main / 'id'_club_main
	public MultipartRequest upload_trainer_s
	(HttpServletRequest request, String savefolder, String photoid, int photonum) throws IOException {
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
		String id = (String) request.getSession().getAttribute("LOG_ID");
		List<PhotoBean> oldphoto = getfilenames_trainerphoto(id,photonum);
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_trainer_")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				if(deleteTHIS.isFile()) {
					boolean t =deleteTHIS.delete();	
				System.out.println("예전에 있던 사진 지웁니다...."+t);}
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
		photoBean.setId(photoid);
//		photoBean.setPicture(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		String ddd= multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		photoBean.setPicture(ddd);
		
		sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_rePICTURE",photoBean); 	//중복 데이터 삭제...
		int r = sqlsession.insert("insert_PICTURE", photoBean); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 
System.out.println(ddd+r+"개 db에 넣기 완료 (서버에 파일과는 다른) ");
		sqlsession.commit();
		sqlsession.close();

		return multi;
	}
	

	public List<PhotoBean> getfilenames_trainerphoto(String id, int num) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean pb = new PhotoBean();
		List<PhotoBean> photos;
		pb.setId(id); //트레이너 이름을 가지고있습니다. 
		pb.setNo(num); //-1 을 가지고있습니다. 
		if(num == -1) {
			//전체
			photos = sqlsession.selectList("select_trainer_photo_all",pb);
		}
		else {
			photos = sqlsession.selectList("select_trainer_photo",pb);
		}
		
//		List<PhotoBean> photos = sqlsession.selectList("select_club_mainphotos",pb);
		sqlsession.close();
		return photos;
	}
	
	
	public void upload_empty(String id ) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean photos = new PhotoBean();
		photos.setId(id);
		photos.setPicture("");
		sqlsession.insert("insert_PICTURE",photos);
		sqlsession.commit();
		sqlsession.close();
	}

	public List<PhotoBean> entire_trainerphoto(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PhotoBean> photos = sqlsession.selectList("select_Entire_trainer_photos");
		sqlsession.close();
		return photos;
		
	}
	
}
