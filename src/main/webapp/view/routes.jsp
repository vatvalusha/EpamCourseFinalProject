<%--
  Created by IntelliJ IDEA.
  User: valeriyartemenko
  Date: 06.04.17
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/view/includePages/tag_direct.jspf" %>
<%@ include file="/view/includePages/page_direct.jspf" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>City Transport System</title>
</head>
<body>
<%@ include file="/view/includePages/loc_login.jspf" %>
<h3><fmt:message key="routes_jsp.label.routes_list"></fmt:message></h3>

<div id="routs-result">
    <c:choose>
        <c:when test="${empty routes}">
            <h3><fmt:message key="routes_jsp.label.error"></fmt:message></h3>
        </c:when>
        <c:otherwise>
                <table style="margin: auto">
                    <tr>
                        <th><fmt:message key="routes_jsp.label.route_number"></fmt:message></th>
                        <th></th>
                        <th><fmt:message key="routes_jsp.label.route_name"></fmt:message></th>
                        <th></th>
                        <th><fmt:message key="routes_jsp.label.route_transport_type"></fmt:message></th>
                        <th></th>
                    </tr>
                    <c:forEach items="${routes}" var="route">
                        <tr>
                            <td><c:out value="${route.getRouteId()}"></c:out></td>
                            <td></td>
                            <td><c:out
                                    value="${language eq 'ru' ? route.getName_route_ru() : route.getName_route_en()}"></c:out></td>
                            <td></td>
                            <td><c:out
                                    value="${language eq 'ru' ? route.getTypeTransport().getNameType() : route.getTypeTransport().getNameType()}"></c:out></td>
                            <td>
                                <form action="route_detailes" accept-charset="UTF-8" method="post">
                                <input type="hidden" name="routeId" value=${route.getRouteId()}>
                                <input type="submit" class="button-accept" name="${route.getRouteId()}" value=<fmt:message
                                    key="routes_jsp.button.detailes"></fmt:message>>
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                </table>

            <p><fmt:message key="routes_jsp.label.using"></fmt:message></p>
        </c:otherwise>
    </c:choose>
</div>
<%@ include file="/view/includePages/foot.jspf" %>
</body>
</html>
