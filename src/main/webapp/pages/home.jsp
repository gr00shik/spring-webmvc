<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 4.06.24
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="mes" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<mes:message code="title"/>
${title}

<hr>

<a href="/app/home?lang=en">En</a><br>
<a href="/app/home?lang=ru">Ru</a><br>
<a href="/app/home?lang=fr">Fr</a><br>

<hr>

Hello from home jsp ${name}

<sp:form action="/app/info" method="post" modelAttribute="usermodel">
    Login: <sp:input path="login" name="login" type="text"/><sp:errors path="login"/><br>
    Password: <sp:input path="password" name="password" type="password"/><sp:errors path="password"/> <br>
    Age: <input name="age" type="number"/><br>
    Login: <input type="submit">
</sp:form>

<%--<form action="/app/info" method="post">--%>
<%--    Login: <input name="login" type="text">${login_error}<br>--%>
<%--    Password: <input name="password" type="password">${password_error}<br>--%>
<%--    Age: <input name="age" type="number"><br>--%>
<%--    Login: <input type="submit">--%>
<%--</form>--%>

</body>
</html>
