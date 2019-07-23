<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<label>${param.label}</label>
<c:choose>
  <c:when test="${empty param.error}">
    <input type="text" class="form-control" name="${param.name}">
  </c:when>

  <c:otherwise>
    <input type="text" class="form-control is-invalid" name="${param.name}" value="${param.rejectedValue}">
    <div class="invalid-feedback">
      ${param.errorMessage}
    </div>
  </c:otherwise>
</c:choose>
