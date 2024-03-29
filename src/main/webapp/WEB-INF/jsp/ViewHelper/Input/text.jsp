<%@ include file="/WEB-INF/jsp/ViewHelper/jstl.jsp" %>

<label>${param.label}</label>
<c:choose>
  <c:when test="${empty param.error}">
    <input type="text" class="form-control" name="${param.name}">
  </c:when>

  <c:when test="${(param.otherErrors == 'true') and (param.error == 'false')}">
    <input type="text" class="form-control" name="${param.name}" value="${param.rejectedValue}">
  </c:when>

  <c:otherwise>
    <input type="text" class="form-control is-invalid" name="${param.name}" value="${param.rejectedValue}">
    <div class="invalid-feedback">
      ${param.errorMessage}
    </div>
  </c:otherwise>
</c:choose>
