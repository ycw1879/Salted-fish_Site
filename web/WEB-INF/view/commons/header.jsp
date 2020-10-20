<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<header>
  <div class="__header">
    <%-- 로그인이 된 경우 --%>
    <%@ include file="logout/logout.jsp" %>
    
    <%-- 로그인이 필요한 경우 --%>
<%--      <%@ include file="login/login.jsp" %>--%>

  
    <div class="banner-frame gs-flex gs-mb-20">
      <div class="card-name-frame gs-m-h">
        <div class="card-name">
          <img src="/resources/img/name.png" alt="곰소젓갈전문점이미지" />
        </div>
      </div>
      
      <div class="sign-frame gs-m-a">
        <div class="sign">
          <a href="#">
            <img src="/resources/img/sign.png" alt="곰소젓갈전문점간판이미지" />
          </a>
        </div>
      </div>
      <div class="gs-blank gs-w10"></div>
    </div>

    <nav class="nav-frame gs-w80 gs-center gs-mb-100">
      <ul class="nav gs-flex gs-ch-fill">
        <li><a href="#">오시는 길</a></li>
        <li><a href="#">제품 소개</a></li>
        <li><a href="#">주문 안내</a></li>
        <li><a href="#">고객게시판</a></li>
        <li><a href="#">제품 후기</a></li>
      </ul>
    </nav>
  </div>
</header>