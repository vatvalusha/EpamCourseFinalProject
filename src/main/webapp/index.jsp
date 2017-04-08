<%--
  Created by IntelliJ IDEA.
  User: valeriyartemenko
  Date: 03.04.17
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
  <%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>myServlet</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--<form action="/hello" method="get">--%>
    <%--<input type="text" name="userName" value=""/>--%>
    <%--<input type="submit" name="send" value="sendName"/>--%>
  <%--</form>--%>
  <%--</body>--%>
<%--</html>--%>
<%@ include file="/view/includePages/tag_direct.jspf" %>
<%@ include file="/view/includePages/page_direct.jspf" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>City Transport System</title>
</head>
<body>
<%@ include file="/view/includePages/loc_login.jspf" %>


<h3>Welcome to city transport system web-site!<br>
  <fmt:message key="welcome_jsp.label.options"></fmt:message></h3>

<a href="<c:url value="/pages/routes"/>"><fmt:message key="welcome_jsp.label.routes_list"></fmt:message></a>
<br>
<br>
<%@ include file="/view/includePages/foot.jspf" %>
</body>
</html>
