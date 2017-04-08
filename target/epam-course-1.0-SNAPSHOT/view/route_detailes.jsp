<%@ include file="/view/includePages/tag_direct.jspf" %>
<%@ include file="/view/includePages/page_direct.jspf" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>City Transport System</title>
</head>
<body>
<%@ include file="/view/includePages/loc_login.jspf" %>

<div id="route-stops-result">
    <c:choose>
    <c:when test="${empty allStops}">
        <h3><fmt:message key="route_detailes_jsp.label.error"></fmt:message></h3>
    </c:when>
    <c:otherwise>
    <h3><fmt:message key="route_detailes_jsp.label.route_detailes"></fmt:message><c:out value="${routeId}"/></h3>

    <form action="route_transport_units" accept-charset="UTF-8" method="post">
        <table style="margin: auto">
            <tr>
                <th><fmt:message key="route_detailes_jsp.label.stop_number"></fmt:message></th>
                <th></th>
                <th><fmt:message key="route_detailes_jsp.label.stop_name"></fmt:message></th>
                <th></th>
                <th><fmt:message key="route_detailes_jsp.label.stop_geopoint"></fmt:message></th>
            </tr>
            <c:forEach items="${allStops}" var="stop">
                <tr>
                    <td><c:out value="${stop.getId_stop()}"></c:out></td>
                    <td></td>
                    <td><c:out value="${language eq 'ru' ? stop.getNameRu() : stop.getNameEn()}"></c:out></td>
                    <td></td>
                    <td><c:out value="${stop.getGeoPoint().getLotitude()}"/></td>
                    <td></td>
                    <td><c:out value="${stop.getGeoPoint().getLongtude()}"/></td>
                </tr>
            </c:forEach>
        </table>
        <p><input type="submit" class="button-accept" name="route_transport_units" value="Get Transport Units"/></p>

        <form/>
        </c:otherwise>
        </c:choose>
</div>
</div>
<form action="routes" accept-charset="UTF-8" method="post">
    <input type="submit" value="Back to Routes List">
</form>
<br>
<%@ include file="/view/includePages/foot.jspf" %>
</body>
</html>
