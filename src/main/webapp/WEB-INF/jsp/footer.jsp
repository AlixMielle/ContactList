<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css">

<footer class="text-muted py-5">
    <div class="container">
        <p class="float-end mb-1">
            <a href="${pageContext.request.contextPath}/contacts/all"><i class="bi bi-arrow-up-square"></i></a>
        </p>
        <jsp:useBean id="now" class="java.util.Date" scope="request"/>
        <p class="mb-1 text-center"><fmt:formatDate value="${now}" pattern="yyyy"/> &copy; Good people, good jobs !</p>
    </div>
</footer>