<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>

<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Contacts | List</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<main>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Mon carnet d'adresses</h1>
                <p class="lead text-muted">Faites de nouvelles rencontres et enregistrez-les simplement !</p>
                <p>
                    <a href="${pageContext.request.contextPath}/contacts/all" class="btn my-2 text-white" style="background-color: darkslategray">Liste des contacts</a>
                    <a href="${pageContext.request.contextPath}/contacts/add" class="btn my-2 text-white" style="background-color: lightcoral">Ajouter un contact</a>
                </p>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <div class="col">
                    <div class="card shadow-sm">
                        <img src="${contact.pictureUrl}" alt="photo">
                        <div class="card-body">
                            <h3 class="card-text">${contact.firstname} ${contact.lastname}</h3>
                            <small class="text-muted">(${contact.dateBirth})</small>
                                <%--<c:forEach items="${contact.authors}" var="author">
                                    <h5 class="card-text">${author.firstname} ${author.lastname}</h5>
                                </c:forEach>--%>
                            <p class="card-text">${contact.job} chez ${contact.company}</p>
                            <p class="card-text">${contact.link}</p>
                            <p class="card-text">##${contact.note}</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Modifier</button>
                                    <c:import url="deleteContact.jsp"></c:import>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>

<jsp:include page="footer.jsp"/>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>