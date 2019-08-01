<%@ include file="/WEB-INF/jsp/ViewHelper/jstl.jsp" %>

<html>
<%@ include file="/WEB-INF/jsp/ViewHelper/html_head.jsp" %>

<body>
  <title>user add</title>

  <form class="login-form" action="<%= request.getRequestURL().toString().replace(request.getRequestURI(), "/user/create") %>" method="POST" >
    <c:import url="/WEB-INF/jsp/ViewHelper/Input/text.jsp">
      <c:param name="name" value="username" />
      <c:param name="label" value="User account" />
      <c:param name="error" value="${v.hasFieldErrors('username')}" />
      <c:param name="otherErrors" value="${v.hasErrors()}" />
      <c:param name="errorMessage" value="${v.getFieldError('username').getDefaultMessage()}" />
      <c:param name="rejectedValue" value="${v.getFieldValue('username')}" />
    </c:import>

    <c:import url="/WEB-INF/jsp/ViewHelper/Input/password.jsp">
      <c:param name="name" value="password" />
      <c:param name="label" value="Password" />
      <c:param name="error" value="${v.hasFieldErrors('password')}" />
      <c:param name="otherErrors" value="${v.hasErrors()}" />
      <c:param name="errorMessage" value="${v.getFieldError('password').getDefaultMessage()}" />
    </c:import>

    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</body>
</html>
