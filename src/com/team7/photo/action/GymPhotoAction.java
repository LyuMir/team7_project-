package com.team7.photo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.photo.service.PhotoGymService;
import com.team7.photo.service.PhotoTrainerService;
import com.team7.vo.PhotoBean;

public class GymPhotoAction {
	public void photoUpload(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, IOException {

        HttpSession session = request.getSession();
		String bywhom = (String) session.getAttribute("LOG_ID");
		String num =  (String)session.getAttribute("num");
		String photonum = (String) session.getAttribute("photonum");
		
		System.out.println(num+"확인합");
		System.out.println(photonum+"확인합");
//		
		String photoid = bywhom+"_gym_"+num+"_"+photonum;
		String savefolder = "gym/"+bywhom+"/photonum";
		
		new PhotoGymService().upload_gym_main(request);//
		
	}
	
	public void photoget(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
		String trainer = request.getParameter("trainer");
		List<PhotoBean> photoBean = new PhotoTrainerService().getfilenames_trainerphoto(trainer, -1); // -1 means all
		
		request.setAttribute("photoBean", photoBean);
		
	}
	
	public void photoSelect(HttpServletRequest request, String gymid ,Integer gymNum) {
		List<PhotoBean> photoBean = new PhotoGymService().getfilenames_gymphoto(gymid, gymNum, -1);
		request.setAttribute("photoBean", photoBean);
	}
}
