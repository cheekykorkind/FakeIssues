<%@ include file="/WEB-INF/jsp/ViewHelper/jstl.jsp" %>

<c:choose>
  <c:when test="${param.rejectedValue == param.value}">
    <input class="${param._class}" type="radio" name="${param.name}" value="${param.value}" id="${param.id}" checked>
  </c:when>

  <c:when test="${param.checked == 'true'}">
    <input class="${param._class}" type="radio" name="${param.name}" value="${param.value}" id="${param.id}" checked>
  </c:when>

  <c:otherwise>
    <input class="${param._class}" type="radio" name="${param.name}" value="${param.value}" id="${param.id}">
  </c:otherwise>
</c:choose>
