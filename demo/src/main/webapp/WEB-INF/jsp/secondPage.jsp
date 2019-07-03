<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>secondPage JSP</title>
</head>
<body>
    this is secondPage
    <a href="<%= request.getRequestURL().toString().replace(request.getRequestURI(), "/will/first") %>">move first page</a>
</body>
</html>
