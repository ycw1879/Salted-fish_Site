<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String loginYn = (String) request.getSession().getAttribute("loginYn");
%>
<header>
  <div class="__header">
    <%-- 로그인이 된 경우 --%>
    <% if("Y".equals(loginYn)){ %>
    <%@ include file="logout/logout.jsp" %>
    <% }else{ %>
    <%-- 로그인이 필요한 경우 --%>
    <%@ include file="login/login.jsp" %>
    <% } %>

    <div class="gs-flex gs-mb-20 gsm-flex m-header">
      <div class="card-name-frame gs-flex-g1 gs-flex gsm-mb-20">
        <div class="card-name gs-m-a gsm-m-a">
          <img src="/resources/img/name02.jpg" alt="곰소젓갈전문점이미지" />
        </div>
      </div>
      
      <div class="sign-frame gs-flex-g3 gsm-m-a">
        <div class="sign gs-m-a">
          <a href="/"></a>
          <img src="/resources/img/sign02.jpg" alt="곰소젓갈전문점간판이미지" />
        </div>
      </div>

      <div class="search-frame gs-flex-g1 gs-flex gs-flex-end gsm-flex gsm-flex-end gsm-mb-20">
        <div class="search-box gs-m-h gsm-m-h gsm-w100">
          <div class="search-body gs-flex gsm-flex gsm-w100">
            <div class="search-form-frame gsm-w100">
            <%-- 밑에 클래스 search-off 추가로 검색창 --%>
              <form class="search-input-frame search-off" id="header-form-search" action="/product/search" method="get">
                <input type="text" id="header-input-search" class="gs-w100 gsm-w100" name="text" />
              </form>
            </div>
            <div class="search-icon gs-txt-c gs-flex gsm-txt-c gsm-flex" onclick="clickSearch();">
<%--              <i class="fas fa-search gs-min-70 gs-m-a gsm-min-60 gsm-m-a"> 상품 검색</i>--%>
              <%-- 아이콘 제거 --%>
              <span class="gs-min-70 gs-m-a gsm-min-60 gsm-m-a">상품 검색</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <nav class="nav-frame gs-w80 gs-center gs-mb-100 gsm-mb-20">
      <ul class="nav gs-flex gs-ch-fill gsm-flex">
        <li><a href="/gomsoInfo">곰소 젓갈</a></li>
        <li><a href="/map">오시는 길</a></li>
        <li><a href="/product/list">상품 소개</a></li>
<%--        <li><a href="#">제품 후기</a></li>--%>
        <li><a href="/question/list">문의 게시판</a></li>
      </ul>
    </nav>
  </div>
</header>