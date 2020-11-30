<%@ page import="java.util.List" %>
<%@ page import="com.gomso.vo.GsProductVO" %>
<%@ page import="com.gomso.core.utils.StringUtil" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    List<List<GsProductVO>> productCategoryList = (List) request.getAttribute("productCategoryList");
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

                <%
                    for (int i = 0; i < productCategoryList.size(); ++i) {
                        List<GsProductVO> productList = productCategoryList.get(i);
                %>

                    <div class="best-li-box-frame">
                        <h1 class="gs-title gs-mb-20 gsm-title gsm-mb-20"> <%= productList.get(0).getCategoryTitle() %></h1>
                        <ul class="best-li-box">

                            <% for (GsProductVO product : productList) { %>
                                <li class="main" onclick="goViewPage(<%= product.getSeq() %>)">
                                    <div class="li-img-box gs-w80 gs-m-a">
                                        <div class="li-img">
                                            <%-- TODO: Img 처리 이후 해당 주석 변경 --%>
                                            <img src="/resources/img/j01.jpg" alt="image01">
                                            <%--<img src="/img/<%= bestProduct.getTitleFileName() %>" alt="image01">--%>
                                            <div class="li-slide-box gs-w100 gs-flex">
                                                <p class="li-slide gs-m-a">
                                                    제품 상세보기<a href="/product/view/<%= product.getSeq() %>"></a>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="li-txt">
                                            <p class="li-name"><%= product.getProductTitle() %></p>
                                            <p class="li-price"><%= StringUtil.formatNumber(product.getPrice()) %><b>&nbsp;원</b></p>
                                            <p class="li-icon"></p>
                                            <a href="/product/view/<%= product.getSeq() %>"></a>
                                        </div>
                                    </div>
                                </li>
                            <% } %>
                        </ul>
                    </div>

                    <% if(i+1 < productCategoryList.size()){ %>
                        <p class="gs-line gs-line-bk gs-mh-50 gsm-line gsm-line-bk gsm-mh-50"></p>
                    <% } %>
                <% } %>
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
