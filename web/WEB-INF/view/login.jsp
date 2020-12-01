
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
            <form action="javascript:login();" method="post" class="gs-flex gs-flex-ch gs-w80 gs-m-a" id="loginForm">
              <div class="img-frame gs-m-w">
                <div class="img gs-w80 gs-m-a gsm-m-a">
                  <img src="/resources/img/name02.jpg" alt="명함사진">
                </div>
              </div>
              <input type="text" class="gs-input gs-mh-5 gs-w100 gsm-w100 gsm-mh-5" placeholder="아이디" name="id">
              <input type="password" class="gs-input gs-mh-5 gs-w100 gsm-w100 gsm-mh-5" placeholder="비밀번호" name="pw">
              <button type="submit" class="gs-input gs-mh-5 gs-w100 gsm-w100 gsm-mh-5">로그인</button>
            </form>

            <ul class="my-box gs-flex gs-m-a gs-center gs-li-wall gs-mh-10 gs-mb-100 gsm-flex gsm-m-a gsm-center gsm-mh-10 gsm-mb-50">
<%--              <li><a href="#">비밀번호 찾기</a></li>--%>
<%--              <li><a href="#">회원가입</a></li>--%>
            </ul>
          </article>
        </section>
      </div>
      <%-- 필요한 경우에만 실행 --%>
      <%-- <%@ include file="commons/aside.jsp" %> --%>
      <%@ include file="commons/footer.jsp" %>
    </div>
  <script type="text/javascript">
    const login = () => {
      const formData = document.querySelector("#loginForm");
      const id = formData.id.value;
      const pw = formData.pw.value;

      if(id == null || id == undefined || id.length == 0){
        alert('아이디를 입력해주세요.');
        formData.id.focus();
        return;
      }

      if(pw == null || pw == undefined || pw.length == 0){
        alert('비밀번호를 입력해주세요.');
        formData.pw.focus();
        return;
      }

      axios.post('/login',{
        userId: id,
        userPw: pw
      }).then((response) => {
        const responseData = response.data;
        const resultCode = responseData.resultCode;

        if(resultCode == '000'){
          location.href = '/';
        }else if(resultCode == '401'){
          alert('아이디를 입력해 주세요.');
          formData.id.focus();
        }else if(resultCode == '402'){
          alert('비밀번호를 입력해주세요.');
          formData.pw.focus();
        }else if(resultCode == '403'){
          alert('아이디가 틀립니다.');
          formData.id.focus();
        }else if(resultCode == '404'){
          alert('비밀번호가 틀립니다.');
          formData.pw.focus();
        }else{
          alert('시스템 오류 입니다.\n' +
                  '잠시 후 다시 시도해 주세요.');
        }
      }).catch((error) => {
        console.warn(error);
      });
    }
  </script>
  </body>
</html>


