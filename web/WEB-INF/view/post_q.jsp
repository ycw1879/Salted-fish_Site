<%@ page import="java.util.List" %>
<%@ page import="com.gomso.vo.GsQuestionVO" %>
<%@ page import="com.gomso.core.utils.StringUtil" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  int pageNo = (Integer) request.getAttribute("pageNo");
  int pageSize = (Integer) request.getAttribute("pageSize");
  int listStartNo = (Integer) request.getAttribute("listStartNo");
  int listEndNo = (Integer) request.getAttribute("listEndNo");
  List<GsQuestionVO> questionList = (List) request.getAttribute("questionList");
%>
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
              <table class="gs-table-txt-c gs-w100 gs-table gs-mb-20 gsm-table gsm-mb-20 gsm-table-txt-c gsm-w90 gsm-m-a question-table">
                <thead>
                  <tr>
                    <th>글제목</th>
                    <th>글쓴이</th>
                    <th>작성일</th>
                  </tr>
                </thead>
                <tbody>
                  <%-- <i class="fa fa-lock" aria-hidden="true"></i>&nbsp;&nbsp;<i class="far fa-comment"></i> 자물쇠,말풍선 --%>
                  <% for(GsQuestionVO question : questionList){ %>
                  <tr>
                    <td><%= question.getQuestionTitle() %><span class="gs-txt-red gs-b gsm-txt-red gsm-b">&nbsp;&nbsp;<%= question.getCommentCnt() %></span></td>
                    <td><%= question.getUserName() %></td>
                    <td><%= question.getCreateTime().substring(0, 4) %>.<%= question.getCreateTime().substring(4, 6) %>.<%= question.getCreateTime().substring(6, 8) %></td>
                  </tr>
                  <% } %>
                </tbody>
              </table>
              <div class="gs-list-frame gs-mb-20 gsm-list-frame gsm-mb-20">
                <form id="questListForm" action="/question/list" method="get" class="gsm-flex">
                  <ul class="gs-list gsm-list">
                    <div class="gs-list-l gsm-list-l"><i class="fas fa-angle-left"></i><a href="javascript:pageLeftMove();"></a></div>
                    <% for(int i=listStartNo; i<=listEndNo; ++i){ %>
                    <li class="gs-list-num gsm-list-num <%= i == pageNo ? "gs-list-active gsm-list-active" : "" %>"><a href="javascript:pageMove(<%= i %>);"></a><%= i %></li>
                    <% } %>
                    <div class="gs-list-r gsm-list-r"><i class="fas fa-angle-right"></i><a href="javascript:pageRightMove();"></a></div>
                  </ul>
                  <input type="hidden" id="pageNo" name="pageNo" value="<%= pageNo %>" />
                  <input type="hidden" id="pageSize" name="pageSize" value="<%= pageSize %>" />
                  <input type="hidden" id="listStartNo" name="listStartNo" value="<%= listStartNo %>" />
                  <input type="hidden" id="listEndNo" name="listEndNo" value="<%= listEndNo %>" />
                </form>
              </div>
              <div class="write-btn gs-flex gs-mb-20 gs-flex-end gsm-flex gsm-mb-20 gsm-flex-end">
                <form class="gs-flex gsm-flex">
<%--                  <input type="text" class="gs-input gs-mr-20 gsm-mr-5" placeholder="검색어를 입력해 주세요" />--%>
<%--                  <button class="gs-btn gs-mr-20 gs-b gsm-btn gsm-mr-5 gsm-b">검색</button>--%>
<%--                  <div class="gs-btn gs-btn-green gsm-btn gsm-btn-green">글쓰기</div>--%>
                </form>
              </div>
            </article>
          </section>
        </div>
      <%-- 필요한 경우에만 실행 --%>
      <%-- <%@ include file="commons/aside.jsp" %> --%>
    </div>
    <%@ include file="commons/footer.jsp" %>

  <script type="text/javascript">
    const pageMove = (pageNo) => {
        const inputPageNo = document.querySelector("#pageNo");
        inputPageNo.value = pageNo;

        const questListForm = document.querySelector("#questListForm");
        questListForm.submit();
    }

    const pageLeftMove = () => {
        const listStartNo = document.querySelector("#listStartNo");
        const pageNo = document.querySelector("#pageNo");
        pageNo.value = Math.max( Number(listStartNo.value) - 10, 1 ).toString();

        const questListForm = document.querySelector("#questListForm");
        questListForm.submit();
    }

    const pageRightMove = () => {
        const listStartNo = document.querySelector("#listStartNo");
        const pageSize = document.querySelector("#pageSize");
        const pageNo = document.querySelector("#pageNo");
        pageNo.value = Math.min( Number(listStartNo.value) + 10, Number(pageSize.value) ).toString();

        const questListForm = document.querySelector("#questListForm");
        questListForm.submit();
    }
  </script>
  </body>
</html>