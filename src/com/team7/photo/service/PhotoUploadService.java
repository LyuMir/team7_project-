package com.team7.photo.service;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.dao.Class_DAO;
import com.team7.vo.PhotoBean;


public class PhotoUploadService {

	public boolean upload(HttpServletRequest request, String savefolder, String photoid) throws IOException {
		boolean ok = false;
		String realFolder="";
//		String saveFolder="/abc";
		if(savefolder ==null) {
			return false;
		}
		if(!savefolder.startsWith("/")) {
			savefolder = "/"+savefolder;
		}
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(savefolder);
//		realFolder=""+savefolder;
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
		
		if(k >0) {
			ok = true;
		}
		return ok;
	}
}
