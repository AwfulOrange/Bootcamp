<%-- 
    Document   : header
    Created on : Mar 14, 2016, 1:46:53 PM
    Author     : bootcamp19
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.perficient.talentreviewsystem.utils.GetProperties" %>
    <%
        String reportIssuePROP = "Link.properties";
        GetProperties gp = new GetProperties("/properties/" + reportIssuePROP);
        String logout = "logout";
        String logoutLink = gp.getProperty(logout);
    %>
<header>
    <div class="masthead pagewidth">
        <div>
            <img src="../img/title_logo.png">
        </div>
            
        <table class="nav nav-tabs" role="tablist" >
            <tr>
                <td  class="w1-tab-hover"><a href="${pageContext.request.contextPath}/page/score.jsp"  class="w1-tab-a"><b>Score</b> </a></td>
                <td class="w1-tab-hover"><a href="${pageContext.request.contextPath}/page/pmo_leader.jsp" class="w1-tab-a"><b>PMO-Leader</b> </a></td>
                <td>
                    <li><a id="logout" href=<%=logoutLink%> > <span class="glyphicon glyphicon-log-out" aria-hidden="true">&ensp;</span>Log-out</a></li>
                </td>
            </tr>
        </table>
    </div>
</header>
