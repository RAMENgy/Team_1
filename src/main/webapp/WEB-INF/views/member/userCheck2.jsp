<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// member/userCheck2.jsp
String id=request.getParameter("userid");
MemberDAO mDAO=new MemberDAO();
MemberDTO mDTO=mDAO.getMember(id);
if(mDTO!=null){
	%>아이디 중복<%
}else{
	%>아이디 사용가능<%
}
%>