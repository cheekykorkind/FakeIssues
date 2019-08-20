<%@ include file="/WEB-INF/jsp/ViewHelper/jstl.jsp" %>

<html>
<%@ include file="/WEB-INF/jsp/ViewHelper/html_head.jsp" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Fake issue</a>
  <form class="form-inline my-2 my-lg-0">
    <input class="form-control mr-sm-2" type="search" placeholder="Search">
    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
  </form>

  <div class="collapse navbar-collapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ml-3">
        <a class="nav-link" href="#">Repository</a>
      </li>
    </ul>

    <div class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        user name
      </a>
      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
        <a class="dropdown-item" href="#">Action</a>
        <a class="dropdown-item" href="#">Another action</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#">Something else here</a>
      </div>
    </div>
  </div>
</nav>

<div class="container">
  <body>
    <form action="<%= request.getRequestURL().toString().replace(request.getRequestURI(), "/repository/create") %>" method="POST">
      <div class="row mt-4">
        <h3 class="col-md-auto">
          Create a new repository
        </h3>
      </div>
      <div class="dropdown-divider mt-3 mb-3"></div>

      <div class="row mt-1">
        <div class="col-md-6">
          <c:import url="/WEB-INF/jsp/ViewHelper/Input/text.jsp">
            <c:param name="name" value="name" />
            <c:param name="label" value="Repository name" />
            <c:param name="error" value="${v.hasFieldErrors('name')}" />
            <c:param name="otherErrors" value="${v.hasErrors()}" />
            <c:param name="errorMessage" value="${v.getFieldError('name').getDefaultMessage()}" />
            <c:param name="rejectedValue" value="${v.getFieldValue('name')}" />
          </c:import>
        </div>
      </div>

      <div class="row mt-1">
        <div class="col-md-9">
          <c:import url="/WEB-INF/jsp/ViewHelper/Input/text.jsp">
            <c:param name="name" value="description" />
            <c:param name="label" value="Description" />
            <c:param name="error" value="${v.hasFieldErrors('description')}" />
            <c:param name="otherErrors" value="${v.hasErrors()}" />
            <c:param name="errorMessage" value="${v.getFieldError('description').getDefaultMessage()}" />
            <c:param name="rejectedValue" value="${v.getFieldValue('description')}" />
          </c:import>
        </div>
      </div>
      <div class="dropdown-divider mt-3 mb-3"></div>

      <div class="row mt-1">
        <div class="col-md-6">
          <c:import url="/WEB-INF/jsp/ViewHelper/Input/radio.jsp">
            <c:param name="checked" value="true" />
            <c:param name="name" value="type" />
            <c:param name="value" value="1" />
            <c:param name="rejectedValue" value="${v.getFieldValue('type')}" />
            <c:param name="id" value="type_public" />
            <c:param name="_class" value="float-left mt-3 mr-1" />
          </c:import>
          <label class="float-left mt-1 mr-2" for="type_public">
            <i class="fas fa-lock-open fa-2x"></i>
          </label>
          <span>
            Public<br>
            Anyone can see this repository. You choose who can commit.
          </span>
        </div>
      </div>

      <div class="row mt-1">
        <div class="col-md-6">
          <c:import url="/WEB-INF/jsp/ViewHelper/Input/radio.jsp">
            <c:param name="name" value="type" />
            <c:param name="value" value="2" />
            <c:param name="rejectedValue" value="${v.getFieldValue('type')}" />
            <c:param name="id" value="type_private" />
            <c:param name="_class" value="float-left mt-3 mr-1" />
          </c:import>
          <label class="float-left mt-1 mr-2" for="type_private">
            <i class="fas fa-lock fa-2x"></i>
          </label>
          <span>
            Private<br>
            You choose who can see and commit to this repository.
          </span>
        </div>
      </div>
      <div class="dropdown-divider mt-3 mb-3"></div>

      <button class="btn btn-primary" type="submit">Submit form</button>
    </form>
  </body>
</div>

</html>
