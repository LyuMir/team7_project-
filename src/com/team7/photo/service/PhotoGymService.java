package com.team7.photo.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.dao.Class_DAO;
import com.team7.vo.ClubBean;
import com.team7.vo.PhotoBean;


public class PhotoGymService {
	
	//Files / clubsphoto / 'id' / main / 'id'_club_main
	public MultipartRequest upload_gym_main
	(HttpServletRequest request) throws IOException {
		
        HttpSession session = request.getSession();
		String bywhom = (String) session.getAttribute("LOG_ID");
		int fileSize=5*1024*1024;
		
		
		MultipartRequest multif=new MultipartRequest(request,
				request.getServletContext().getRealPath("Files/dump"),
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());	//�ӽ÷� �����׾��. ���Ŀ� �ű���� �϶��. 
		String num = multif.getParameter("num");
		String photonum = multif.getParameter("photonum");
		System.out.println(num+"�׸���"+photonum);
		String photoid = bywhom+"_gym_"+num+"_"+photonum;
		String savefolder = "Files/gym/"+bywhom+"/"+photonum;
		String realFolder="";
		
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
		List<PhotoBean> oldphoto = getfilenames_gymphoto(id,Integer.parseInt(num),Integer.parseInt(photonum));
		for(int i = 0 ; i <oldphoto.size();i++) {
			if(oldphoto.get(i).getId().contains("_gym_")) {
				String oldone = oldphoto.get(i).getPicture();
				
				File deleteTHIS = new File(realFolder+"/"+oldone);
				boolean t =deleteTHIS.delete();	
				System.out.println("������ �ִ� ���� ����ϴ�...."+t);
				System.out.println(deleteTHIS.getPath());
			}
		}
		String filename= multif.getOriginalFileName((String)multif.getFileNames().nextElement());
		File moveTHIS = new File(context.getRealPath("Files/dump")+"/"+filename);
		boolean t = moveTHIS.renameTo(new File(realFolder+"/"+filename));
		System.out.println("�ű�� : "+t);
		
//		MultipartRequest multi=new MultipartRequest(request,
//				realFolder,
//				fileSize,
//				"UTF-8",
//				new DefaultFileRenamePolicy());
		
		PhotoBean photoBean = new PhotoBean();
		SqlSession sqlsession;
		photoBean.setId(photoid);

		photoBean.setPicture(filename);
		
		sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.delete("delete_rePICTURE",photoBean); 	//�ߺ� ������ ����...
		sqlsession.insert("insert_PICTURE", photoBean); // �����̸���, ������  ... �ҷ��� id , ������ dto�ε�. 

		sqlsession.commit();
		sqlsession.close();

		return multif;
	}
	

	public List<PhotoBean> getfilenames_gymphoto(String id, int gymnum, Integer photonum) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		PhotoBean pb = new PhotoBean();
		pb.setId(id);
		pb.setNo(gymnum);
		pb.setPicture(photonum.toString());
		List<PhotoBean> photos;
		if(photonum == -1) {
			photos = sqlsession.selectList("select_gym_photo_all",pb);
		}
		else {
			photos = sqlsession.selectList("select_gym_photo",pb);
		}
		sqlsession.close();
		return photos;
	}
	
	public List<PhotoBean> entire_gymphoto(){
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<PhotoBean> photos = sqlsession.selectList("select_Entire_gym_photos");
		sqlsession.close();
		return photos;
		
	}
}
