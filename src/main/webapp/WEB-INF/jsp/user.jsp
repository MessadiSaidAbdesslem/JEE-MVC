<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="login" value="/user/login" />
<c:url var="logout" value="/user/logout" />
<c:url var="show" value="/user" />

<h1>User <c:out value="${user.name}" default="no name" /></h1>

<p>
  <a class="btn btn-primary mx-2" href="${show}">Show</a>
  <a class="btn btn-primary mx-2" href="${login}">Login</a>
  <a class="btn btn-primary mx-2" href="${logout}">Logout</a>
</p>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>