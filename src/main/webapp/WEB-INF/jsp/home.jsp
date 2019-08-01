<%@ include file="/WEB-INF/jsp/ViewHelper/jstl.jsp" %>

<html>
<%@ include file="/WEB-INF/jsp/ViewHelper/html_head.jsp" %>

<body>
  <title>home</title>

  home
  <a
    href="<%= request.getRequestURL().toString().replace(request.getRequestURI(), "/logout") %>"
    class="btn btn-secondary"
  >
    logout!
  </a>
  <a
    href="<%= request.getRequestURL().toString().replace(request.getRequestURI(), "/user/add") %>"
    class="btn btn-secondary"
  >
    user add
  </a>
</body>
</html>
