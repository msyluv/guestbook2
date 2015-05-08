<%@ page import="com.sds.icto.guestbook.dao.*" %>
<%@ page import="com.sds.icto.guestbook.vo.*" %>
<%
//삭제
String no = request.getParameter( "no" );
String password = request.getParameter( "password" );

GuestBookVo vo = new GuestBookVo();
vo.setNo( Long.parseLong(no) );
vo.setPassword(password);

GuestBookDao dao = new GuestBookDao();
dao.delete(vo);

//리다이렉트
response.sendRedirect( "/guestbook" );
%>