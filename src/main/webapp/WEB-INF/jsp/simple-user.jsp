<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="login" value="/simple-user/login" />
<c:url var="logout" value="/simple-user/logout" />
<c:url var="show" value="/simple-user/show" />

<h1>Simple User</h1>

<c:if test="${message != null}">
  <div class="alert alert-success" role="alert">
    <c:out value="${message}" />
  </div>
</c:if>

<p>name: <c:out value="${simpleUser.name}" default="no name" /></p>

<p>
  <a class="btn btn-primary mx-2" href="${show}">Show</a>
  <a class="btn btn-primary mx-2" href="${login}">Login</a>
  <a class="btn btn-primary mx-2" href="${logout}">Logout</a>
</p>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>