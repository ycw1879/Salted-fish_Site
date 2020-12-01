
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <div class="__body">
      <%@ include file="commons/header.jsp" %>
      <div class="contents">
        <section class="sec01">
          <article class="gs-inner">
            <h1 class="login-title gs-title gsm-title gs-mb-20 gsm-mb-20">
              회원가입
            </h1>
            <div class="post-write-frame">
              <ul class="post-write gs-mb-20 gs-li-flex gs-b gsm-mb-20 gsm-li-flex gsm-b gsm-w90 gsm-m-a">
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">아이디<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="아이디를 입력해주세요" /></div>
                </li>
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">암호<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="비밀번호 입력해주세요" /></div>
                </li>
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">암호확인<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="비밀번호 확인해주세요" /></div>
                </li>
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">이름<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="이름을 입력해주세요" /></div>
                </li>
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">주소<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="주소을 입력해주세요" /></div>
                </li>
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">상세주소<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="상세주소을 입력해주세요" /></div>
                </li>
                <li class="post-write-subject gs-mb-20">
                  <div class="gs-min-100 gsm-min-80">전화번호<b class="gs-txt-red gsm-txt-red">*</b></div>
                  <div class="subject-con"><input type="text" class="gs-w100" placeholder="전화를 입력해주세요" /></div>
                </li>
              </ul>
            </div>
            
            <div class="write-btn gs-flex gs-mb-20 gs-flex-end gsm-flex gsm-mb-20 gsm-flex-end">
              <div class="gs-btn gs-btn-green gsm-btn gsm-btn-green gsm-w100">가입</div>
            </div>
          </article>
        </section>
      </div>
      <%-- 필요한 경우에만 실행 --%>
      <%-- <%@ include file="commons/aside.jsp" %> --%>
      <%@ include file="commons/footer.jsp" %>
    </div>
  </body>
</html>