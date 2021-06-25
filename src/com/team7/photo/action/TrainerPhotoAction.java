package com.team7.photo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.photo.service.PhotoTrainerService;
import com.team7.vo.PhotoBean;

public class TrainerPhotoAction {
	public void photoUpload(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, IOException {

        HttpSession session = request.getSession();
		String bywhom = (String) session.getAttribute("LOG_ID");
//		String num = request.getParameter("num");
		Integer num = (Integer)session.getAttribute("num");
		System.out.println(request.getParameter("n"));
		
		String photoid = bywhom+"_trainer_"+num;
		String savefolder = "trainer/"+bywhom;
		
		new PhotoTrainerService().upload_trainer_s(request, savefolder, photoid, num);
		
	}
	
	public void photoget(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
		String trainer = request.getParameter("trainer");
		List<PhotoBean> photoBean = new PhotoTrainerService().getfilenames_trainerphoto(trainer, -1); // -1 means all
		System.out.println("오는가요");
		System.out.println(photoBean.get(0));
		System.out.println(photoBean.get(1));
		
		request.setAttribute("photoBean", photoBean);
		
	}
	public void photoSelect(HttpServletRequest request, HttpServletResponse response) {
		String trainerNum = (String)request.getAttribute("trainerNum");
		List<PhotoBean> photoBean = new PhotoTrainerService().getfilenames_trainerphoto(trainerNum, -1);
		request.setAttribute("photoBean", photoBean);
	}
}
