<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <%@ include file="commons/head.jsp" %>
  <body>
    <%@ include file="commons/header.jsp" %>
      <div class="__body">
        <div class="contents">
          <section class="post-section gs-mb-100 gsm-mb-50">
            <article class="gs-inner">
              <h1 class="gs-title gs-mb-20 gsm-title gsm-mb-20">
                문의게시판
              </h1>
              <table class="gs-table-txt-c gs-w100 gs-table gs-mb-20 gsm-table gsm-mb-20 gsm-table-txt-c question-table">
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>글제목</th>
                    <th>글쓴이</th>
                    <th>작성일</th>
                  </tr>
                </thead>
                <tbody onclick="clickQList();">
                  <tr>
                    <th>7</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;6</span></td>
                    <td>mings**</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr class="table-comment">
                    <td></td>
                    <td class="gs-txt-l">&nbsp;<i class="fas fa-reply gs-180d gsm-180d"></i>&nbsp;내일 도착해요 좀 기다려요</td>
                    <td>관리자</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr>
                    <th>6</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;3</span></td>
                    <td>mings**</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr class="table-comment gs-off gsm-off">
                    <td></td>
                    <td class="gs-txt-l">&nbsp;<i class="fas fa-reply gs-180d gsm-180d "></i>&nbsp;내일 도착해요 좀 기다려요</td>
                    <td>관리자</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr>
                    <th>5</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;2</span></td>
                    <td>mings**</td>
                    <td>2020.10.17</td>
                  </tr>
                  <tr class="table-comment gs-off gsm-off">
                    <td></td>
                    <td class="gs-txt-l">&nbsp;<i class="fas fa-reply gs-180d gsm-180d "></i>&nbsp;내일 도착해요 좀 기다려요</td>
                    <td>관리자</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr>
                    <th>4</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;1</span></td>
                    <td>mings**</td>
                    <td>2020.10.17</td>
                  </tr>
                  <tr class="table-comment gs-off gsm-off">
                    <td></td>
                    <td class="gs-txt-l">&nbsp;<i class="fas fa-reply gs-180d gsm-180d "></i>&nbsp;내일 도착해요 좀 기다려요</td>
                    <td>관리자</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr>
                    <th>3</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;2</span></td>
                    <td>mings**</td>
                    <td>2020.10.16</td>
                  </tr>
                  <tr class="table-comment gs-off gsm-off">
                    <td></td>
                    <td class="gs-txt-l">&nbsp;<i class="fas fa-reply gs-180d gsm-180d "></i>&nbsp;내일 도착해요 좀 기다려요</td>
                    <td>관리자</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr>
                    <th>2</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;2</span></td>
                    <td>mings**</td>
                    <td>2020.10.16</td>
                  </tr>
                  <tr class="table-comment gs-off gsm-off">
                    <td></td>
                    <td class="gs-txt-l">&nbsp;<i class="fas fa-reply gs-180d gsm-180d "></i>&nbsp;내일 도착해요 좀 기다려요</td>
                    <td>관리자</td>
                    <td>2020.10.18</td>
                  </tr>
                  <tr>
                    <th>1</th>
                    <td>언제오나요?&nbsp;&nbsp;<i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i></i><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;6</span></td>
                    <td>mings**</td>
                    <td>2020.10.16</td>
                  </tr>
                </tbody>
              </table>
              <div class="gs-list-frame gs-mb-20 gsm-list-frame gsm-mb-20">
                <ul class="gs-list gsm-list">
                  <div class="gs-list-l gsm-list-l"><i class="fas fa-angle-left"></i><a href="#"></a></div>
                  <li class="gs-list-num gs-list-active gsm-list-num gsm-list-active"><a href="#"></a>1</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>2</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>3</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>4</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>5</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>6</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>7</li>
                  <li class="gs-list-num gsm-list-num"><a href="#"></a>8</li>
                  <div class="gs-list-r gsm-list-r"><i class="fas fa-angle-right"></i><a href="#"></a></div>
                </ul>
              </div>
              <div class="write-btn gs-flex gs-mb-20 gs-flex-end gsm-flex gsm-mb-20 gsm-flex-end">
                <form class="gs-flex gsm-flex">
                  <input type="text" class="gs-input gs-mr-20 gsm-mr-5" placeholder="검색어를 입력해 주세요" />
                  <button class="gs-btn gs-mr-20 gs-b gsm-btn gsm-mr-5 gsm-b">검색</button>
                  <div class="gs-btn gs-btn-green gsm-btn gsm-btn-green">글쓰기</div>
                </form>
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