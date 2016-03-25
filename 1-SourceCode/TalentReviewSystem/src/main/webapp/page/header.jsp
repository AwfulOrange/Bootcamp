<%-- 
    Document   : header
    Created on : Mar 14, 2016, 1:46:53 PM
    Author     : bootcamp19
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<header>
    <div class="masthead pagewidth">
        <div>
            <img src="../img/title_logo.png">
        </div>
            
        <table class="nav nav-tabs" role="tablist" >
            <tr width="10px">
                <td  class="w1-tab-hover"><a href="${pageContext.request.contextPath}/page/score.jsp"  class="w1-tab-a"><b>Score</b> </a></td>
                <td class="w1-tab-hover"><a href="${pageContext.request.contextPath}/page/pmo_leader.jsp" class="w1-tab-a"><b>PMO-Leader</b> </a></td>
                <td></td>
            </tr>
        </table>
    </div>
</header>