<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <div class="__body">
    <%@ include file="commons/header.jsp" %>
        
      <div class="contents">
        <section class="more-page-frame">
          <div class="more-page">
            <article class="mp-header-frame gs-inner">
              <div class="mp-header gs-mb-50">
                <div class="mp-title-frame gs-mb-10">
                  <h1 class="gs-title"> 양념젓갈</h2>
                </div>
                <div class="mp-breadcrumb-frame">
                  <div class="mp-bc gs-flex">
                    <a href="#" class="bc-section">홈</a>
                    <div class="bc-div"> > </div>
                    <a href="#" class="bc-section">제품 소개</a>
                    <div class="bc-div"> > </div>
                    <div class="bc-active bc-section">양념젓갈</div>
                  </div>
                </div>
              </div>
              <p class="gs-line gs-line-bk gs-line-bold gs-mb-50"></p>
            </article>
            <article class="mp-contents-frame gs-inner">
              <div class="mp-contents gs-m-a">
                <div class="mp-contents-top-frame">
                  <div class="mp-con-top gs-mb-50 gs-flex gs-space-between">
                    <div class="con-top-img-frame gs-w60">
                      <div class="con-top-img gs-w90">
                        <div class="img-big-box-frame gs-mb-10">
                          <div class="img-big-box">
                            <img src="/resources/img/j01.jpg" alt="b-img" />
                          </div>
                        </div>
                        <div class="img-small-box-frame gs-flex">
                          <div class="img-small-btn-l gs-flex"><p class="gs-m-a">&lt;</p></div>
                          <ul class="img-small-box gs-flex">
                            <li class="img-small img-active">
                              <img src="/resources/img/j01.jpg" alt="s-img01" />
                            </li>
                            <li class="img-small">
                              <img src="/resources/img/j02.jpg" alt="s-img02" />
                            </li>
                            <li class="img-small">
                              <img src="/resources/img/j03.jpg" alt="s-img03" />
                            </li>
                            <li class="img-small">
                              <img src="/resources/img/j01.jpg" alt="s-img03" />
                            </li>
                            <li class="img-small">
                              <img src="/resources/img/j02.jpg" alt="s-img03" />
                            </li>
                          </ul>
                          <div class="img-small-btn-r gs-flex"><p class="gs-m-a">&gt;</p></div>
                        </div>
                      </div>
                    </div>
                    <div class="con-top-info-frame gs-w40">
                      <div class="con-top-info gs-w90 gs-flex-end">
                        <div class="info-title">
                          <h1 class="info-title-con">밴댕이젓</h1>
                        </div>
                        <div class="info-ad">
                          <p class="info-ad-con">밴댕이젓150g 특가</p>
                        </div>
                        <p class="gs-line gs-line-grey"></p>
                        <div class="info-box gs-m-a">
                          <ul class="info-box-sub gs-li-flex">
                            <li class="info-price">
                              <div class="info-sub"><div>판매가</div></div>
                              <div class="info-con">
                                <b class="price-num">19,000원</b>
                              </div>
                            </li>
                            <li class="info-transport">
                              <div class="info-sub">배송비</div>
                              <div class="info-con">
                                기본 4,000원 / 80,000이상 무료
                              </div>
                            </li>
                            <li class="info-point">
                              <div class="info-sub">적립금</div>
                              <div class="info-con">190</div>
                            </li>
                          </ul>
                        </div>
                        <div class="info-quantity-frame">
                          <form action="GET">
                            <div class="quan-title"><p>선택옵션</p></div>
                            <select class="quan-box form-control gs-mh-10">
                              <option value="choose">선택</option>
                              <option value="Salted fish 01">150g +0원</option>
                              <option value="Salted fish 02">300g +11,000원</option>
                              <option value="Salted fish 03">600g +31,000원</option>
                            </select>
                            <p class="gs-line gs-line-grey"></p>
                            <div class="buy-item gs-flex">
                              <button class="gs-btn gs-w50 gs-mr-5 gs-btn-green">구매하기</button>
                              <button class="gs-btn gs-w50 gs-mr-5 gs-btn-white">장바구니</button>
                              <button class="gs-btn gs-btn-red item-favorite"><i class="far fa-heart"></i></button>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                  <p class="gs-line gs-line-bk gs-line-bold gs-mb-50"></p>
                </div>
                <div class="mp-contents-mid-frame">
                  <div class="mp-con-mid">
                    <img src="/resources/img/detail.jpg" alt="detail" />
                  </div>
                </div>
              </div>
              <p class="gs-line gs-line-bk gs-line-bold"></p>
            </article>
          </div>
        </section>
      </div>
  
      <%-- <div class="blank gs-center">
        스크롤 필요한 경우 공백 추가
      </div> --%>
  
      <%-- 필요한 경우에만 실행 --%>
      <%@ include file="commons/aside.jsp" %>
    </div>
  <%@ include file="commons/footer.jsp" %>
  </div>
</body>
</html>
