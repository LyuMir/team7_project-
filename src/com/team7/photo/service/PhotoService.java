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
import com.team7.vo.PhotoBean;


public class PhotoService {
	
	//Files / clubsphoto / 'id' / main / 'id'_club_main
	public MultipartRequest upload_club_main(HttpServletRequest request, String savefolder, String photoid) throws IOException {
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
			    Folder.mkdir(); //���� �����մϴ�.
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
		List<PhotoBean> oldphoto = getfilenames_clubmains(id);
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_main")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				boolean t =deleteTHIS.delete();	
				System.out.println("������ �ִ� ���� ����ϴ�...."+t);
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
		sqlsession.delete("delete_rePICTURE",photoBean); 	//�ߺ� ������ ����...
		sqlsession.insert("insert_PICTURE", photoBean); // �����̸���, ������  ... �ҷ��� id , ������ dto�ε�. 

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

		// �ش� ���丮�� ������� ���丮�� �����մϴ�.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //���� �����մϴ�.
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
		List<PhotoBean> oldphoto = getfilenames_clubmains(id);
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_profile")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				boolean t = deleteTHIS.delete();
				System.out.println("������ �ִ� ���� ����ϴ�...."+t);
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
			sqlsession.delete("delete_rePICTURE",photoBean); 	//�ߺ� ������ ����...
			sqlsession.insert("insert_PICTURE",photoBean);
			sqlsession.commit();
			sqlsession.close();

		return multi;

	}
	
	public List<PhotoBean> getfilenames_clubmains(String id) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean pb = new PhotoBean();
		pb.setId(id);
		List<PhotoBean> photos = sqlsession.selectList("select_club_mainphotos",pb);
		sqlsession.close();
		return photos;
	}
}
