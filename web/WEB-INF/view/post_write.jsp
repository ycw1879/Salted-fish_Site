<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <%@ include file="commons/header.jsp" %>
      <div class="__body">
        <div class="contents">
          <section class="post-section gs-mb-100">
            <article class="gs-inner">
              <h1 class="login-title gs-title gs-mb-20">
                게시글작성
              </h1>

              <div class="post-write-frame">
                <ul class="post-write gs-mb-20 gs-li-flex gs-b">
                  <li class="post-write-title">
                    <h2 class="">고객게시판 ( 질문 / 후기 )</h2>
                  </li>
                  <li class="post-write-name">
                    <div>이름<b class="gs-txt-red">*</b></div>
                    <div>홍길동</div>
                  </li>
                  <li class="post-write-subject gs-mb-20">
                    <div>제목<b class="gs-txt-red">*</b></div>
                    <div><input type="text" class="gs-w100" placeholder="제목을 입력해주세요" /></div>
                  </li>
                  <li class="post-write-content">
                    <div class="">내용<b class="gs-txt-red">*</b></div>
                    <div class="gs-n">
                      <textarea type="text" class="gs-w100 gs-border-none" placeholder="내용을 입력해주세요"></textarea>
                      <div class="gs-flex-end gs-txt-r">0&nbsp;/&nbsp;<b>3,000</b>자</div>
                    </div>
                  </li>
                  <li class="post-write-img">
                    <div>사진</div>
                    <div class="write-img"><input type="file"></div>
                  </li>
                </ul>
              </div>
             
              <div class="write-btn gs-flex gs-mb-20 gs-flex-end">
                <div class="gs-btn gs-mr-20">취소</div>
                <div class="gs-btn gs-btn-green">등록</div>
              </div>
            </article>
          </section>
        </div>
      <%-- 필요한 경우에만 실행 --%>
      <%-- <%@ include file="commons/aside.jsp" %> --%>
    </div>
    <%@ include file="commons/footer.jsp" %>
  </body>
</html>