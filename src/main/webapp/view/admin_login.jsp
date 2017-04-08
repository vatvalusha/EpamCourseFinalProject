<%--
  Created by IntelliJ IDEA.
  User: valeriyartemenko
  Date: 06.04.17
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h3>Admin Login page<br></h3>
Use admin admin.
<br>
    <form id="slick-login" action="admin_cabinet" method="post" >
        <label>Login:   </label><input type="text" name="login" class="placeholder" placeholder="admin"> <br/><br/>
        <label>Password:</label><input type="password" name="password" class="placeholder" placeholder="password"> <br/><br/>
        <br/><br/>
        <input type="button" onclick="history.back()" value="Back"> <input type="submit" value="Log in"/>

    </form>


<%@ include file="/view/includePages/foot.jspf" %>
</body>
</html>
