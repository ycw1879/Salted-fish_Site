
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <div class="__body">
      <%@ include file="commons/header.jsp" %>
      <div class="contents">
        <section class="sec01">
          <article class="form-login gs-inner">
            <h1 class="login-title gs-title gsm-title">
              로그인
            </h1>
            <form action="GET" class="gs-flex gs-flex-ch gs-w80 gs-m-a">
              <div class="img-frame gs-m-w">
                <div class="img gs-w80 gs-m-a gsm-m-a">
                  <img src="/resources/img/name02.jpg" alt="명함사진">
                </div>
              </div>
              <input type="text" class="gs-input gs-mh-5 gs-w100 gsm-w100 gsm-mh-5" placeholder="전화번호">
              <input type="password" class="gs-input gs-mh-5 gs-w100 gsm-w100 gsm-mh-5" placeholder="비밀번호">
              <button type="submit" class="gs-input gs-mh-5 gs-w100 gsm-w100 gsm-mh-5">로그인</button>
            </form>

            <ul class="my-box gs-flex gs-m-a gs-center gs-li-wall gs-mh-10 gs-mb-100 gsm-flex gsm-m-a gsm-center gsm-mh-10 gsm-mb-50">
              <li><a href="#">비밀번호 찾기</a></li>
              <li><a href="#">회원가입</a></li>
            </ul>
          </article>
        </section>
      </div>
      <%-- 필요한 경우에만 실행 --%>
      <%-- <%@ include file="commons/aside.jsp" %> --%>
      <%@ include file="commons/footer.jsp" %>
    </div>
  </body>
</html>


