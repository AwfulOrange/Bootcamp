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
            
        <table >
            <tr >
            
                <td   class="w1-tab-hover1" ><a href="${pageContext.request.contextPath}/page/score.jsp"  class="w1-tab-a"><b>Reviewer</b> </a></td>

            
                <td class="w1-tab-hover2"   ng-show="checkT()" ><a href="${pageContext.request.contextPath}/page/pmo_leader.jsp" class="w1-tab-a"><b >PMO-Leader</b></a> </td>
                <!--<td class="w1-head-name"></td>-->
                <!--</div></td>-->
                <td class="w1-log-out"  align="right"width="10%">
                    <b style="font-size: 14px;"> {{info.screenName}}</b> <a id="logout" href=<%=logoutLink%> > <span class="glyphicon glyphicon-log-out" aria-hidden="true">&ensp;</span>Log-out</a>
                </td>
            </tr>
        </table>
    </div>
                <script>
                       angular.element(document).ready(function() {
                            angular.bootstrap("app1",['myApp1']);
                          });
     </script>
</header>
