<%@ include file="/WEB-INF/jsp/ViewHelper/jstl.jsp" %>

<html>
<%@ include file="/WEB-INF/jsp/ViewHelper/html_head.jsp" %>

<body>
  <title>my login</title>
  <div class="container">
    <form class="form-signin" method="post" action="/login">
      <h2 class="form-signin-heading">My Please sign in</h2>
      <p>
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="My Username" required="" autofocus="">
      </p>
      <p>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="My Password" required="">
      </p>
      <input name="_csrf" type="hidden" value="a10d55a7-a113-4b34-b56e-c2607eb7fdea">
      <button class="btn btn-lg btn-primary btn-block" type="submit">My Sign in</button>
    </form>
  </div>
</body>

</html>
