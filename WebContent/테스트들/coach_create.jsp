<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="daos.Class_DAO" %>
<%@ page import="dtos.Class_DTO_ClubProperties" %>
<%@ page import="java.util.List" %>

    <%
    	String majors="";
         request.setCharacterEncoding("UTF-8");
        String coachname = request.getParameter("coachname") ;
        String sex =   request.getParameter("sex") ;
        String coachphone =   request.getParameter("coachphone") ;
        String coachbirth =   request.getParameter("coachbirth") ;
        String coachemail =   request.getParameter("coachemail") ;
        String coachtime =   request.getParameter("coachtime") ;
        String [] majorimsi =   request.getParameterValues("major");
        for (int i=0 ; i<=3 ; i ++){
          majors = majors+","+majorimsi[i];
        }
        String coachcareer =   request.getParameter("coachhowlong") ;
        String coachprofile =   request.getParameter("coachprofile") ;
        String coachcerti =   request.getParameter("coachcerti") ;
        String coachstory =   request.getParameter("coachstory") ;
        String coachwhy =   request.getParameter("coachwhy") ;
        String coachsns =  request.getParameter("coachsns");
        String coachhowjoin =   request.getParameter("coachhowjoin") ;
        String photo = request.getParameter("file");

      %>


      <%

      dtos.Class_DTO_Trainer trainer  = new dtos.Class_DTO_Trainer();
      trainer.setTname(coachname);
      trainer.setSex(sex);
      trainer.setTphone(coachphone);
      trainer.setTbirth(coachbirth);
      trainer.setTemail(coachemail);
      trainer.setTtime(coachtime);
      trainer.setTmajor(majors);
      trainer.setTcareer(coachcareer);
      trainer.setTprofile(coachprofile);
      trainer.setTcerti(coachcerti);
      trainer.setTstory(coachstory);
      trainer.setTwhy(coachwhy);
      trainer.setTsns(coachsns);
      trainer.setThowjoin(coachhowjoin);
     
      
      new Class_DAO().trainer_creator(trainer);
      
      %>
      
     
이름: <%=coachname%>





  </body>
</html>
