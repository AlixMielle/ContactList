<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css">
<script type="text/javascript">
    function clearSearch() {
        window.location = "${pageContext.request.contextPath}/contacts/all";
    }
</script>

<header>
    <div class="collapse bg" style="background-color: darkslategray" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">A propos</h4>
                    <p class="text-muted">Bienvenue dans votre carnet d'adresses</p>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Contact</h4>
                    <ul class="list-unstyled ">
                        <li><a href="#" class="text-white">Follow on Twitter</a></li>
                        <li><a href="#" class="text-white">Like on Facebook</a></li>
                        <li><a href="#" class="text-white">Email me</a></li>
                        <%--  <form action="${pageContext.request.contextPath}/logout" method="post">
                              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                              <button type="submit">Logout</button>
                          </form>--%>
                        <%--<sec:authorize access="!isAuthenticated()">
                            &lt;%&ndash;<p>Welcome <sec:authentication property="principal.username"/></p>&ndash;%&gt;
                            <form:form action="/signin" method="get">
                                <li><button type="submit" class="btn btn-light" style="color: darkslategray">Se connecter</button></li>
                            </form:form>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <form:form action="/logout" method="post">
                                <li><button type="submit" class="btn btn-light" style="color: darkslategray">Logout</button></li>
                            </form:form>
                        </sec:authorize>--%>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="navbar navbar-dark shadow-sm" style="background-color: darkslategray">
        <div class="container">
            <a href="${pageContext.request.contextPath}/contacts/all" class="navbar-brand d-flex align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" aria-hidden="true" class="me-2" viewBox="0 0 24 24"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
                <strong>Mon Carnet d'adresses</strong>
            </a>
            <div class="row navbar-brand d-flex align-items-center justify-content-around">
                <div class="col-10">
                    <form action="${pageContext.request.contextPath}/contacts/all" class="navbar-brand d-flex justify-content-between" role="search">
                        <input class="form-control me-2" type="search" name="keyword" value="${keyword}" id="keyword" placeholder="Chercher un contact" aria-label="Search">
                        <button class="navbar-toggler" type="submit">Rechercher</button>
                        <button class="navbar-toggler" type="button" onclick="clearSearch()">Effacer</button>
                    </form>
                </div>
                <div class="col-2">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</header>