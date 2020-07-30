package com.team7.photo.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.dao.Class_DAO;
import com.team7.vo.PhotoBean;


public class PhotoUploadService {

	public MultipartRequest upload(HttpServletRequest request, String savefolder, String photoid) throws IOException {
		System.out.println("사진 넣어봅시다. ");
		
		boolean ok = false;
		String realFolder="";
//		String saveFolder="/abc";
		if(savefolder ==null) {
			return null;
		}
		if(!savefolder.startsWith("/")) {
			savefolder = "/"+savefolder;
		}
		
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(savefolder);
//		realFolder=""+savefolder;
		//String path = "D:\\Eclipse\\Java\\새폴더"; //폴더 경로
		File Folder = new File(realFolder);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다 : "+realFolder);
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		PhotoBean photoBean = new PhotoBean();
		photoBean.setId(photoid);
		photoBean.setPicture(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		int k = sqlsession.insert("insert_PICTURE", photoBean); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 
		sqlsession.commit();
		sqlsession.close();
		
//		if(k >0) {
//			ok = true;
//		}
//		return ok;
		return multi;
	}
}
