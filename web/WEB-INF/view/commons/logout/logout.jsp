<%@ page import="com.gomso.vo.GsUserVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  GsUserVO loginUser = (GsUserVO) request.getSession().getAttribute("loginUser");
%>
<div class="login-nav-frame">
  <ul class="login-nav gs-flex gsm-flex gs-flex-end gsm-flex-end">
    <li>어서오세요&nbsp;<span class="gs-b gsm-b">&nbsp;<%= loginUser.getUserName() %></span>&nbsp;님</li>
    <li><a href="/logout"></a>로그아웃</li>
<%--    <li><a href="#"></a>마이페이지</li>--%>
  </ul>
</div>