<%@ page import = "com.sds.icto.guestbook.vo.GuestBookVo" %>
<%@ page import = "com.sds.icto.guestbook.dao.GuestBookDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String password = request.getParameter("pass");
String message = request.getParameter("content");

GuestBookVo vo = new GuestBookVo();
vo.setName(name);
vo.setPassword(password);
vo.setMessage(message);

GuestBookDao dao = new GuestBookDao();
dao.insert(vo);

response.sendRedirect("/guestbook");
%>