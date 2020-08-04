package com.team7.club.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.club.service.ClubService;
import com.team7.dao.Class_DAO;
import com.team7.photo.service.PhotoService;
import com.team7.vo.ActionForward;
import com.team7.vo.ClubBean;
import com.team7.vo.PhotoBean;

public class ClubEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String realFolder="";
		String savefolder="/Files/Photos";//+request.getParameter("");
//		if(savefolder ==null) {
//			return null;
//		}
//		if(!savefolder.startsWith("/")) {
//			savefolder = "/"+savefolder;
//		}
		
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
		photoBean.setId((String)multi.getParameter("club_name"));
		System.out.println(multi.getParameter("club_name")+"이라는 이름으로...");
		photoBean.setPicture(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		if (multi.getFileNames() ==null) {
			System.out.println("파일 없음. ");
		}
		else {
			SqlSession sqlsession = new Class_DAO().get_conn().openSession();
			sqlsession.insert("insert_PICTURE", photoBean); // 변수이름값, 변수값  ... 불러올 id , 보내줄 dto인듯. 
			sqlsession.commit();
			sqlsession.close();
			if(multi.getFileNames().nextElement() !=null) {
				sqlsession = new Class_DAO().get_conn().openSession();
				photoBean.setPicture(multi.getOriginalFileName(multi.getFileNames().toString()));
				sqlsession.insert("insert_PICTURE", photoBean);
				sqlsession.commit();
				sqlsession.close();
			}
		}		
		String club_name = multi.getParameter("club_name");
		String club_publicity = multi.getParameter("club_publicity");
		String club_memberJoin = multi.getParameter("club_memberJoin");
		String club_memLimit = multi.getParameter("club_memLimit");
//		int club_memLimit = Integer.parseInt(request.getParameter("club_memLimit"));
		String []club_exc_types = multi.getParameterValues("club_exc_type");
//		String club_date = request.getParameter("club_date");
		String meetingDate_select = multi.getParameter("meetingDate_select");
		String meeting_week1 = multi.getParameter("meeting_week1");
		String meeting_week2 = multi.getParameter("meeting_week2");
		String club_hour1 = multi.getParameter("club_hour1");
		String club_hour2 = multi.getParameter("club_hour2");
		String club_area = multi.getParameter("club_area");
		String club_profileText = multi.getParameter("club_profileText");
		
		String photo1 = multi.getParameter("photo1");
		String photo2 = multi.getParameter("photo2");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOG_ID");
		int Limit = 150;
		if(club_memLimit == null) {
			
		}
		else if(club_memLimit.equals("null"))	//그따구임!!
			Limit = 150;
		else{
			Limit = 150;
		}
		String club_Date_week = "";
		
		if(meetingDate_select.equals("meeting1")){
			club_Date_week = "매주 "+meeting_week1+"요일";
		}
		else if (meetingDate_select.equals("meeting2")){
			club_Date_week = "매 "+meeting_week1+"번째 주 "+meeting_week2+"요일";
		}
		else if(meetingDate_select.equals("meeting3")){
			club_Date_week = "매달 "+meeting_week1+"번째 "+meeting_week2+"요일";
		}
		String club_Date_hour = club_hour1+"시 부터 "+club_hour2+"시까지";
		String club_exc_type = "";

		ClubBean clubBean = new ClubBean();
		if(club_exc_types == null){}
		else{
			for(String sth : club_exc_types){
				club_exc_type += sth+",";
			}
			club_exc_type = club_exc_type.substring(0,club_exc_type.length()-1);
			clubBean.setE_type(club_exc_type);
		}
		
		clubBean.setAdmin(id);
		clubBean.setArea(club_area);
		clubBean.setMeetingDate(club_Date_week+" "+club_Date_hour);
		clubBean.setMemberJoin(club_memberJoin);
		clubBean.setMemberLimit(Limit);
		clubBean.setName(club_name);
//		clubBean.setNo();
		clubBean.setProfile(club_profileText);
		clubBean.setPublicity(club_publicity);
		clubBean.setPhoto1(photo1);
		clubBean.setPhoto2(photo2);
		new ClubService().club_creator(clubBean);
//		new PhotoUploadService().upload(request, "/Files/Photos", "clubMainPhoto");
//		new PhotoUploadService().upload(request, "/Files/Photos", "clubProfile");

//		System.out.println(k+"사진넣기");
//		System.out.println(k1+"사진넣기");
		
		ActionForward forward= new ActionForward();
		forward.setPath("id_Mng.club");
		return forward;
	}

}
