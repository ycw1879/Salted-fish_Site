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
              <h1 class="gs-title gs-mb-20 gsm-title gsm-mb-20">
                문의게시판
              </h1>

              <div class="post-write-frame">
                <ul class="post-write gs-mb-20 gs-li-flex gs-b gsm-mb-20 gsm-li-flex gsm-b">
                  <li class="post-write-title">
                    <h2 class="">문의글작성</h2>
                  </li>
                  <li class="post-write-name">
                    <div>이름<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div>홍길동</div>
                  </li>
                  <li class="post-write-subject gs-mb-20">
                    <div>제목<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div class="subject-con"><input type="text" class="gs-w100" placeholder="제목을 입력해주세요" /></div>
                  </li>
                  <li class="post-write-img gs-mb-20">
                    <div>사진<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div><input type="file" class="form-control"></div>
                  </li>
                  <li class="post-write-content gsm-flex-ch">
                    <div class="gsm-mb-10">내용<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div class="gs-border-none gs-w100">
                      <textarea name="" class="form-control gs-w100 gsm-w100" cols="30" rows="10" style="resize: none;"></textarea>
                    </div>
                  </li>
                </ul>
              </div>
             
              <div class="write-btn gs-flex gs-mb-20 gs-flex-end gsm-flex gsm-mb-20 gsm-flex-end">
                <div class="gs-btn gs-mr-20 gsm-btn gsm-mr-10 gsm-w100">취소</div>
                <div class="gs-btn gs-btn-green gsm-btn gsm-btn-green gsm-w100">등록</div>
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