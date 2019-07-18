<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ page import="org.springframework.validation.BindingResult" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>user add</title>
</head>
<body>
<%
  BindingResult validation = (BindingResult) request.getAttribute("v");
  boolean hasError = validation != null;
%>
  <form class="login-form" action="<%= request.getRequestURL().toString().replace(request.getRequestURI(), "/user/create") %>" method="POST" >
    <div class="form-group">
      <label>User account</label>
      <% if (hasError && validation.hasFieldErrors("username")) { %>
        <input type="text" class="form-control is-invalid" name="username" value="<%= validation.getFieldError("username").getRejectedValue() %>">
          <div class="invalid-feedback">
            <%= validation.getFieldError("username").getDefaultMessage() %>
          </div>
      <% } else { %>
        <input type="text" class="form-control" name="username">
      <% } %>
    </div>

    <div class="form-group">
      <label>Password</label>
      <% if (hasError && validation.hasFieldErrors("password")) { %>
        <input type="password" class="form-control is-invalid" name="password">
          <div class="invalid-feedback">
            <%= validation.getFieldError("password").getDefaultMessage() %>
          </div>
      <% } else { %>
        <input type="password" class="form-control" name="password">
      <% } %>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</body>
</html>
