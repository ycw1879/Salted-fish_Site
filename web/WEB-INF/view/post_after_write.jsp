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
                후기게시판
              </h1>

              <div class="post-write-frame">
                <ul class="post-write gs-mb-20 gs-li-flex gs-b gsm-mb-20 gsm-li-flex gsm-b">
                  <li class="post-write-title">
                    <h2 class="">후기글작성</h2>
                  </li>
                  <li class="post-write-name">
                    <div>이름<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div>홍길동</div>
                  </li>
                  <li class="post-write-subject gs-mb-20">
                    <div>제목<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div class="subject-con"><input type="text" class="gs-w100" placeholder="제목을 입력해주세요" /></div>
                  </li>
                  <li class="post-write-subject gs-mb-20">
                    <div>별점<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <form class="post-star-chk">
                      <label for="star-1"><input type="radio" vlaue="star-chk-1" name="input-star-chk"/>&nbsp;1&nbsp;&nbsp;</label>
                      <label for="star-2"><input type="radio" vlaue="star-chk-2" name="input-star-chk"/>&nbsp;2&nbsp;&nbsp;</label>
                      <label for="star-3"><input type="radio" vlaue="star-chk-3" name="input-star-chk"/>&nbsp;3&nbsp;&nbsp;</label>
                      <label for="star-4"><input type="radio" vlaue="star-chk-4" name="input-star-chk"/>&nbsp;4&nbsp;&nbsp;</label>
                      <label for="star-5"><input type="radio" vlaue="star-chk-5" name="input-star-chk"/>&nbsp;5</label>
                    </form>
                  </li>
                  <li class="post-write-content gsm-flex-ch">
                    <div class="gsm-mb-10">내용<b class="gs-txt-red gsm-txt-red">*</b></div>
                    <div class="gs-border-none gs-w100">
                      <%@ include file="commons/summernote.jsp" %>
                      <textarea name="" id="summernote" class="form-control" cols="30" rows="10"></textarea>
                      <div class="gs-flex-end gs-txt-r">0&nbsp;/&nbsp;<b>3,000</b>자</div>
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
    <script>
      $(document).ready(function() {
        $('#summernote').summernote({
          lang: 'ko-KR',
          height: 300,
        });
    });
    </script>
    <%@ include file="commons/footer.jsp" %>
  </body>
</html>