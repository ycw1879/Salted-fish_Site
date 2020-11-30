<%@ page import="java.util.List" %>
<%@ page import="com.gomso.vo.GsProductVO" %>
<%@ page import="com.gomso.core.utils.StringUtil" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  List<GsProductVO> bestProductList = (List) request.getAttribute("bestProductList");
  List<GsProductVO> newProductList = (List) request.getAttribute("newProductList");
%>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <div class="__body">
      <%@ include file="commons/header.jsp" %>

      <div class="contents">
      <section class="index-section gs-mb-100 gsm-mb-100">
        <article class="gs-inner">
          <div class="view-change gs-float-r gsm-float-r" onclick="clickView();">
            <div class="view-icon view-icon-big">
            <i class="fas fa-expand-arrows-alt"></i>
            &nbsp;크게 보기
            </div>
            <div class="view-icon view-icon-small">
            <i class="fas fa-th-large"></i>
            &nbsp;작게 보기
            </div>
          </div>
          <%-- 크게보기 누를시 best-li-box에 view-flex-ch추가 --%>
          <%-- 크게보기 작게보기는 모바일과 데스크탑이 반대로 되어있음 --%>
          <div class="best-li-box-frame">
            <h1 class="gs-title gs-mb-20 gsm-title gsm-mb-20"> 추천상품</h1>
            <ul class="best-li-box">

              <% for(GsProductVO bestProduct : bestProductList){ %>
                <li class="main-best" onclick="goViewPage(<%= bestProduct.getSeq() %>)">
                  <div class="li-img-box gs-w80 gs-m-a">
                    <div class="li-img">
<%--                  TODO: Img 처리 이후 해당 주석 변경    --%>
                      <img src="/resources/img/j01.jpg" alt="image01">
<%--                      <img src="/img/<%= bestProduct.getTitleFileName() %>" alt="image01">--%>
                      <div class="li-slide-box gs-w100 gs-flex">
                        <p class="li-slide gs-m-a">
                          제품 상세보기<a href="/product/view/<%= bestProduct.getSeq() %>"></a>
                        </p>
                      </div>
                    </div>
                    <div class="li-txt">
                      <p class="li-name"><%= bestProduct.getProductTitle() %></p>
                      <p class="li-price"><%= StringUtil.formatNumber( bestProduct.getPrice() ) %><b>&nbsp;원</b></p>
                      <p class="li-icon"></p>
                      <a href="/product/view/<%= bestProduct.getSeq() %>"></a>
                    </div>
                  </div>
                </li>
              <% } %>

<%--              품절, 매진일시 처리 --%>
<%--              <li class="main-soldout">--%>
<%--                <div class="li-img-box gs-w80 gs-m-a">--%>
<%--                  <div class="li-img">--%>
<%--                    <img src="/resources/img/j03.jpg" alt="image03">--%>
<%--                    <div class="li-slide-box gs-w100">--%>
<%--                      <p class="li-slide gs-m-a gs-w70 gs-txt-c">--%>
<%--                        상세보기--%>
<%--                      </p>--%>
<%--                    </div>--%>
<%--                  </div>--%>
<%--                  <div class="li-txt">--%>
<%--                    <p class="li-name">머시기젓갈</p>--%>
<%--                    <p class="li-price">10,000<b>&nbsp;원</b></p>--%>
<%--                    <p class="li-icon"></p>--%>
<%--                    <a href="#"></a>--%>
<%--                  </div>--%>
<%--                </div>--%>
<%--              </li>--%>


            </ul>
          </div>

          <p class="gs-line gs-line-bk gs-mh-50 gsm-line gsm-line-bk gsm-mh-50"></p>
          
          <div class="best-li-box-frame">
            <h1 class="gs-title gs-mb-20 gsm-title gsm-mb-20"> 신상품
            </h1>
            <ul class="best-li-box">
              <% for(GsProductVO newProduct : newProductList){ %>
                <li class="main-new" onclick="goViewPage(<%= newProduct.getSeq() %>)">
                  <div class="li-img-box gs-w80 gs-m-a">
                    <div class="li-img">
                      <img src="/resources/img/j01.jpg" alt="image01">
<%--                      <img src="/img/<%= newProduct.getTitleFileName() %>" alt="image01">--%>
                      <div class="li-slide-box gs-w100 gs-flex">
                        <p class="li-slide gs-m-a">
                          제품 상세보기
                          <a href="/product/view/<%= newProduct.getSeq() %>"></a>
                        </p>
                      </div>
                    </div>
                    <div class="li-txt">
                      <p class="li-name"><%= newProduct.getProductTitle() %></p>
                      <p class="li-price"><%= StringUtil.formatNumber( newProduct.getPrice() ) %><b>&nbsp;원</b></p>
                      <p class="li-icon"></p>
                      <a href="/product/view/<%= newProduct.getSeq() %>"></a>
                    </div>
                  </div>
                </li>
              <% } %>
            </ul>
          </div>
        </article>
      </section>
    </div>

      <%@ include file="commons/aside.jsp" %>
      </div>
    <%@ include file="commons/footer.jsp" %>
    </div>

  <script>
    const goViewPage = (seq) => {
      location.href = '/product/view/' + seq;
    }
  </script>

  </body>
</html>
