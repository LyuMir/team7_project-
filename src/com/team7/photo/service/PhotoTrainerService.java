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
//		System.out.println("���� �־�ô�. ");
		
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

		// �ش� ���丮�� ������� ���丮�� �����մϴ�.
		if (!Folder.exists()) {
			try{
			    Folder.mkdirs(); //���� �����մϴ�.
			    System.out.println("������ �����Ǿ����ϴ� : "+realFolder);
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
		}
		
		//�ߺ������� ����...
		String id = (String) request.getSession().getAttribute("LOG_ID");
		List<PhotoBean> oldphoto = getfilenames_trainerphoto(id,photonum);
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_trainer_")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				if(deleteTHIS.isFile()) {
					boolean t =deleteTHIS.delete();	
				System.out.println("������ �ִ� ���� ����ϴ�...."+t);}
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
		sqlsession.delete("delete_rePICTURE",photoBean); 	//�ߺ� ������ ����...
		int r = sqlsession.insert("insert_PICTURE", photoBean); // �����̸���, ������  ... �ҷ��� id , ������ dto�ε�. 
System.out.println(ddd+r+"�� db�� �ֱ� �Ϸ� (������ ���ϰ��� �ٸ�) ");
		sqlsession.commit();
		sqlsession.close();

		return multi;
	}
	

	public List<PhotoBean> getfilenames_trainerphoto(String id, int num) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean pb = new PhotoBean();
		List<PhotoBean> photos;
		pb.setId(id); //Ʈ���̳� �̸��� �������ֽ��ϴ�. 
		pb.setNo(num); //-1 �� �������ֽ��ϴ�. 
		if(num == -1) {
			//��ü
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
