<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="sticky-banner-frame" onclick="clickBtnDown();">
  <div class="sticky-banner">
   <%-- 버튼 숨기기 활성화시 div.btn-frame-ㅇㅇㅇ.btn-down 클래스 추가 hide 제외 --%>
    <div class="btn-frame btn-frame-bascket btn-down">
      <div class="btn-sizing btn-bascket">
        <p class="btn-center">장바구니</p>
      </div>
    </div>
    <div class="btn-frame btn-frame-call btn-down" onclick="clickCall();">
      <div class="btn-sizing btn-call">
        <p class="btn-center">전화연결</p>
      </div>
      <div class="call-popup-frame" onclick="event.stopPropagation()">
      <%-- popup class 추가로 팝업창 확인 가능 --%>
        <div class="call-popup">
          <div class="btn-close-frame gs-flex gs-flex-end">
            <div class="btn-close" onclick="clickCall();">
              <div class="ctrl-box">
                <p class="btn-close-01"></p>
                <p class="btn-close-02"></p>
              </div>
            </div>
          </div>
          <div class="call-popup-contents" >
            <i class="fas fa-phone-alt"></i>
            <div>
              <p class="gs-mh-10 gs-w80 gsm-mh-10">
                "곰소젓갈할인도매전문점" 입니다.
                <br/>
                문자연결은 모바일에서 가능합니다.
              </p>
              <p class="gs-mh-20 call-number gsm-mh-10">010 - 9937 - 1879</p>
              <p class="gs-line gs-line-grey"></p>
              <button class="gs-btn gsm-btn" onclick="clickCall();">확인</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="btn-frame btn-frame-map btn-down">
      <div class="btn-sizing btn-map">
        <p class="btn-center">오시는길</p>
      </div>
    </div>
    <div class="btn-frame btn-frame-top btn-down" onclick="clickTop();">
      <div class="btn-sizing btn-top">
        <div class="top-icon">
          <span class="top-icon-01"></span>
          <span class="top-icon-02"></span>
        </div>
        <p class="btn-center">맨 위로</p>
      </div>
    </div>
    <div class="btn-frame btn-frame-hide desktop-hidden ">
      <div class="btn-sizing btn-hide">
    <%-- 버튼 숨기기 활성화시 p.btn-hide-toggle 클래스 추가 --%>
        <p class="gsm-center gsm-txt-c"><i class="fas fa-bars"></i></p>
      </div>
    </div>
  </div>
</div>