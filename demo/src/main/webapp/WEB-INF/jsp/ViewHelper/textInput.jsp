<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.validation.BindingResult" %>

<%
  BindingResult validation = (BindingResult) request.getParameter("validation");
  boolean hasError = validation != null;
  String name = "username";
  String label = "User account";
%>

<label><%= label %></label>
<% if (hasError && validation.hasFieldErrors(name)) { %>
  <input type="text" class="form-control is-invalid" name="<%= name %>" value="<%= validation.getFieldError(name).getRejectedValue() %>">
    <div class="invalid-feedback">
      <%= validation.getFieldError(name).getDefaultMessage() %>
    </div>
<% } else { %>
  <input type="text" class="form-control" name="<%= name %>">
<% } %>
