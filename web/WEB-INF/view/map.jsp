<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <div class="__body">
    <%@ include file="commons/header.jsp" %>
    <div class="contents">
      <section class="map-section">
        <article class="form-login gs-inner">
          <h1 class="login-title gs-title gs-mb-100 gsm-title gsm-mb-20">
           오시는 길
          </h1>
          
          <div class="map-frame gs-border-line-bk gs-flex gs-mb-100 gsm-border-line-bk gsm-flex gsm-mb-20">
              <img src= "/resources/img/map.png" alt="지도사진">
          </div>

          <ul class="map-text-frame gs-li-wall-row gsm-li-wall-row">
            <li>
              <div class="map-title"><i class="fas fa-map-marker-alt"></i>&nbsp;오시는길</div>
              <div class="map-data gs-flex">
                <div class="gs-min-90 gs-fc-999 gs-b">주차정보</div>
                <div>넓은 주차장으로 편안히 이용하실 수 있습니다.</div>
              </div>
            </li>
            <li>
              <div class="map-title"><i class="fas fa-clock"></i>&nbsp;이용시간</div>
              <div class="map-data gs-flex">
                <div class="gs-min-60 gs-fc-999 gs-b">매일</div>
                <div>10:00 ~ 19:00</div>
              </div>
            </li>
            <li>
              <div class="map-title"><i class="fas fa-phone-alt"></i>&nbsp;전화번호</div>
              <div class="map-data">
                <div class="gs-mb-5">010-9937-1879</div>
                <div>063-582-0080</div>
              </div>
            </li>
<%--            <li>--%>
<%--              <div class="map-title"><i class="fas fa-info-circle"></i>&nbsp;이용안내</div>--%>
<%--              <div class="map-data">--%>
<%--                주차--%>
<%--              </div>--%>
<%--            </li>--%>
            <li class="gsm-flex-ch">
              <div class="data-left gs-flex gs-w40 gsm-w100 gsm-flex">
                <div class="map-title"><i class="fas fa-user-alt"></i>&nbsp;사업자정보</div>
                <div class="map-data">
                  <ul>
                    <li class="data01 gs-flex">
                      <div class="gs-min-60 gs-fc-999 gs-b">상호명</div>
                      <div>곰소젓갈할인점</div>
                    </li>
                    <li class="data02 gs-flex">
                      <div class="gs-min-60 gs-fc-999 gs-b">대표자</div>
                      <div>윤덕암</div>
                    </li>
                  </ul>
                </div>
              </div>

              <div class="data-right gs-flex gs-w60 gsm-w100 gsm-flex">
                <div class="map-title"><i class="fas fa-user-alt"></i>&nbsp;입금계좌</div>
                <div class="map-data">
                  <ul class="">
                    <li>
                      <div class="gs-min-90 gs-fc-999 gs-b">예금주</div>
                      <div>박성자</div>
                    </li>
                    <li>
                      <div class="gs-min-90 gs-fc-999 gs-b">입금은행</div>
                      <div>농협</div>
                    </li>
                    <li>
                      <div class="gs-min-90 gs-fc-999 gs-b">계좌번호</div>
                      <div>300-0000-1234-00</div>
                    </li>
                  </ul>
                </div>
              </div>
            </li>
          </ul>
        </article>
        
      </section>
    </div>
    <%-- 필요한 경우에만 실행 --%>
    <%-- <%@ include file="commons/aside.jsp" %> --%>
    </div>
    <%@ include file="commons/footer.jsp" %>
    </div>
  </body>
</html>