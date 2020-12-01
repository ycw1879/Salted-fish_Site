<%@ page import="com.gomso.vo.GsProductVO" %>
<%@ page import="com.gomso.core.utils.StringUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gomso.vo.GsProductImgListVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
	GsProductVO product = (GsProductVO) request.getAttribute("product");
    List<GsProductImgListVO> productImgList = (List) request.getAttribute("productImgList");
%>
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
							<h2 class="gs-title gsm-title"> <%= product.getCategoryTitle() %>
							</h2>
						</div>
						<div class="mp-breadcrumb-frame">
							<div class="mp-bc gs-flex gsm-flex">
<%--								<a href="/" class="bc-section">홈</a>--%>
                                <div class="bc-active bc-section">홈</div>
								<div class="bc-div"> ></div>
<%--								<a href="#" class="bc-section">제품 소개</a>--%>
                                <div class="bc-active bc-section">상품 소개</div>
								<div class="bc-div"> ></div>
								<div class="bc-active bc-section"><%= product.getCategoryTitle() %></div>
							</div>
						</div>
					</div>
					<p class="gs-line gs-line-bk gs-line-bold gs-mb-50"></p>
				</article>
				<article class="mp-contents-frame gs-inner">
					<div class="mp-contents gs-m-a gsm-m-a">
						<div class="mp-contents-top-frame">
							<div class="mp-con-top gs-mb-50 gs-flex gs-space-between gsm-mb-100">
								<div class="con-top-img-frame gs-w60">
									<div class="con-top-img gs-w90">
										<div class="img-big-box-frame gs-mb-10">
											<div class="img-big-box">
												<%-- TODO: image 더미 작업 후 주석 변경 --%>
<%--												<img src="/resources/img/j01.jpg" alt="b-img"/>--%>
                                                <img src="/img/<%= product.getTitleFileName() %>" alt="b-img"/>
											</div>
										</div>
										<div class="img-small-box-frame gs-flex gsm-flex">
											<div class="img-small-btn-l"><p class="gs-m-a gsm-m-a">&lt;</p></div>
											<ul class="img-small-box gs-flex gsm-flex">
                                                <%-- TODO: gs_product_img_list table --%>
                                                <% for(GsProductImgListVO productImg : productImgList){ %>
                                                    <li class="img-small">
<%--                                                        <img src="/resources/img/j01.jpg" alt="s-img01"/>--%>
                                                        <img src="/img/<%= productImg.getFileName() %>" alt="s-img01"/>
                                                    </li>
                                                <% } %>
											</ul>
											<div class="img-small-btn-r"><p class="gs-m-a gsm-m-a">&gt;</p></div>
										</div>
									</div>
								</div>
								<div class="con-top-info-frame gs-w40">
									<div class="con-top-info gs-w90 gs-flex-end">
										<div class="info-title">
											<h1 class="info-title-con"><%= product.getProductTitle() %></h1>
										</div>
										<div class="info-ad">
                                            <%-- TODO: sub_title or 무게 표기에 대해 내일 토의 --%>
											<p class="info-ad-con">밴댕이젓150g 특가</p>
										</div>
										<p class="gs-line gs-line-grey gsm-line gsm-line-grey"></p>
										<div class="info-box gs-m-a">
											<ul class="info-box-sub gs-li-flex">
												<li class="info-price">
													<div class="info-sub">
														<div>판매가</div>
													</div>
													<div class="info-con">
														<b class="price-num"><%= StringUtil.formatNumber( product.getPrice() ) %> 원</b>
													</div>
												</li>
												<li class="info-transport">
													<div class="info-sub">배송비</div>
													<div class="info-con">
                                                        <%-- TODO: 배송비는 고정값 --%>
														기본 4,000원 / 80,000이상 무료
													</div>
												</li>
												<%--                            <li class="info-point">--%>
												<%--                              <div class="info-sub">적립금</div>--%>
												<%--                              <div class="info-con">190<i class="far fa-coins gs-txt-magenta gsm-txt-magenta"></i></div>--%>
												<%--                            </li>--%>
											</ul>
										</div>
										<div class="info-quantity-frame">
											<%--                          <form action="GET">--%>
											<%--                            <div class="quan-title"><p>선택옵션</p></div>--%>
											<%--                            <select class="quan-box form-control gs-mh-10 gsm-mh-10">--%>
											<%--                              <option value="choose">선택</option>--%>
											<%--                              <option value="Salted fish 01">150g +0원</option>--%>
											<%--                              <option value="Salted fish 02">300g +11,000원</option>--%>
											<%--                              <option value="Salted fish 03">600g +31,000원</option>--%>
											<%--                            </select>--%>
											<%--                            <p class="gs-line gs-line-grey gsm-line gsm-line-grey"></p>--%>
											<%--                            <div class="buy-item gs-flex gsm-flex">--%>
											<%--                              <button class="gs-btn gs-w50 gs-mr-5 gs-btn-green gsm-btn gsm-w50 gsm-mr-5 gsm-btn-green">구매하기</button>--%>
											<%--                              <button class="gs-btn gs-w50 gs-mr-5 gs-btn-white gsm-btn gsm-w50 gsm-mr-5 gsm-btn-white">장바구니</button>--%>
											<%--                              <button class="gs-btn gs-btn-red gsm-btn gsm-btn-red item-favorite"><i class="far fa-heart"></i></button>--%>
											<%--                            </div>--%>
											<%--                          </form>--%>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="mp-contents-mid-frame gs-mb-50 gsm-mb-50">
							<div class="mp-tab-frame gs-mb-50 gsm-mb-50">
								<h2 class="gs-title gsm-title"> 상세정보
								</h2>
							</div>
							<div class="mp-con-mid gs-w80 gs-m-a">
<%--								<img src="/resources/img/detail.jpg" alt="detail"/>--%>
                                <%= product.getProductContent() %>
							</div>
						</div>


						<div class="mp-contents-bot-frame gs-mb-50">
							<div class="mp-tab-frame">
								<h2 class="gs-title gsm-title gs-mb-50 gsm-mb-50"> 배송정보
								</h2>
							</div>
							<div class="mp-table-frame">
								<ul class="mp-table">
									<li class="mp-table-img"></li>
									<li class="mp-table-text-frame">
										<ul class="mp-table-text">
											<table class="gs-w100 gs-txt-c gs-mb-50 gsm-txt-c gsm-mb-50 ">
												<thead>
												<tr>
													<th class="gs-txt-l" colspan="4">
														<b>곰소 젓갈 할인 도매 전문점 배송안내</b><br/>
													</th>
												</tr>
												</thead>
												<tbody>
												<tr>
													<th>택배배송</th>
													<td>3,000원 <b class="gs-txt-grey gs-n">(주문시 결제)</b></td>
													<th>추가비용</th>
													<td>도서산간 : 9,000원<br/>제주도 : 4,000원</td>
												</tr>
												<tr>
													<td class="gs-txt-c gs-txt-l" colspan="4">
														<b class="gs-n">제품 특성상 교환이나 환불이 어렵습니다.</b>
													</td>
												</tr>
												</tbody>
											</table>
										</ul>
									</li>
								</ul>
							</div>


                            <%-- TODO: 교환/반품 정보는 없애고 탭을 2개로 --%>
							<div class="mp-tab-frame">
								<h2 class="gs-title gsm-title gs-mb-50 gsm-mb-50"> 판매자 정보
								</h2>
							</div>
							<div class="mp-change-frame">
								<li class="mp-table-text-frame">
									<ul class="mp-table-text">
<%--										<table class="gs-w100 gs-mb-20 gs-txt-l">--%>
<%--											<thead>--%>
<%--											<tr>--%>
<%--												<th class="gs-txt-l" colspan="4">--%>
<%--													<b>교환 / 반품 안내</b><br/>--%>
<%--												</th>--%>
<%--											</tr>--%>
<%--											</thead>--%>
<%--											<tbody>--%>
<%--											<tr>--%>
<%--												<th>판매자 지정택배사</th>--%>
<%--												<td colspan="3">명수택배</td>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<th>반품배송비</th>--%>
<%--												<td>편도 3,000원 (최초 비용 무료인 경우 6,000원)</td>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<th>교환배송비</th>--%>
<%--												<td>6,000원</td>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<th>보내실 곳</th>--%>
<%--												<td>전북 부안군 진서면 곰소항길 22-13, 다동 155호</td>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<th rowspan="2">--%>
<%--		                                    <span>--%>
<%--		                                        반품/교환&nbsp;사유에&nbsp;따른 요청&nbsp;가능&nbsp;기간--%>
<%--		                                    </span>--%>
<%--												</th>--%>
<%--												<td rowspan="2">표시/광고와 상이, 상품하자의 경우 상품 수령 후 3개월 이내 혹은 표시/광고와 다른 사실을 안--%>
<%--													날로부터 30일 이내--%>
<%--												</td>--%>
<%--											</tr>--%>
<%--											</tbody>--%>
<%--										</table>--%>

										<table class="gs-w100 gs-mb-50 gs-txt-l gsm-mb-50">
											<thead>
											<tr>
												<th class="gs-txt-l" colspan="4">
													<b>판매자정보</b><br/>
												</th>
											</tr>
											</thead>
											<tbody>
											<tr>
												<th>상호명</th>
												<td colspan="3">곰소젓갈할인도매전문점</td>
											</tr>
											<tr>
												<th>대표자</th>
												<td>이은영</td>
											</tr>
<%--											<tr>--%>
<%--												<th>사업자등록번호</th>--%>
<%--												<td>0000000000</td>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<th>통신판매업번호</th>--%>
<%--												<td>2020-전북무안-00000</td>--%>
<%--											</tr>--%>
											<tr>
												<th rowspan="2">
													사업장 소재지
												</th>
												<td rowspan="2">
													전북 부안군 진서면 곰소항길 22-13, 다동 155호<br/>
													전화번호 : 010-9937-1879
												</td>
											</tr>
											</tbody>
										</table>
									</ul>
								</li>
							</div>
						</div>
					</div>
					<%-- <p class="gs-line gs-line-bk gs-line-bold"></p> --%>
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
