<%-- 
    Document   : header
    Created on : Mar 14, 2016, 1:46:53 PM
    Author     : bootcamp19
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<header>
    <div class="masthead pagewidth">
        <div>
            <img src="../pictures/title_logo.png">
        </div>
            
        <ul class="nav nav-tabs" role="tablist" >
            <li ><a href="${pageContext.request.contextPath}/page/score.jsp" >Score </a></li>
            <li role="presentation" class="list-group-item"><a href="${pageContext.request.contextPath}/page/criteria.jsp" >Criteria</a></li>
        </ul>
    </div>
</header>