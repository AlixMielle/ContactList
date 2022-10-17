<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Contacts | Modification</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css">
    <script type="text/javascript">
        function clearSearch() {
            window.location = "${pageContext.request.contextPath}/books/all";
        }
    </script>
</head>
<body class="bg-light">

<jsp:include page="header.jsp"/>

<div class="container">
    <main>
        <div class="py-5">
            <h2>Modifiez un contact</h2>
            <p class="lead">C'est l'occasion de mettre à jour votre carnet d'adresses</p>
            <hr class="my-1">
        </div>

        <div class="row g-3">
            <div class="col-md-7 col-lg-8">
                <form action="${pageContext.request.contextPath}/contacts/edit/${contact.id}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${contact.id}">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="lastname" class="form-label">Nom</label>
                            <input type="text" class="form-control" id="lastname" name="lastname" value="${contact.lastname}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="firstname" class="form-label">Prénom</label>
                            <input type="text" class="form-control" id="firstname" name="firstname" value="${contact.firstname}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="${contact.email}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="mobile" class="form-label">Téléphone</label>
                            <input type="text" class="form-control" id="mobile" name="mobile" value="${contact.mobile}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="dateBirth" class="form-label">Date de naissance</label>
                            <input type="date" class="form-control" id="dateBirth" name="dateBirth" value="${contact.dateBirth}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="link" class="form-label">Lien de parenté</label>
                            <input type="text" class="form-control" id="link" name="link" value="${contact.link}">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <label for="company" class="form-label">Entreprise</label>
                            <input type="text" class="form-control" id="company" name="company" value="${contact.company}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="job" class="form-label">Emploi</label>
                            <input type="text" class="form-control" id="job" name="job" value="${contact.job}">
                        </div>
                    </div>
                    <%-- Toogle switch --%>
                    <div class="row g-3">
                        <div class="col-sm-12 form-check form-switch">
                            <label class="form-check-label" for="togglePictureOptions">Photo de profil</label>
                            <input id="togglePictureOptions" class="form-check-input" type="checkbox" role="switch"
                                   checked>
                        </div>
                        <%-- Picture file --%>
                        <div class="col-sm-12 mb-1">
                            <label for="pictureFile">Chargez une photo :</label>
                            <input id="pictureFile" type="file" name="pictureFile" required="" disabled>
                            <div class="invalid-feedback">Un fichier valide est demandé.</div>
                        </div>
                        <%-- Picture Url --%>
                        <div class="col-sm-12 mb-3">
                            <label for="pictureUrl">ou saisissez une adresse URL :</label>
                            <input id="pictureUrl" type="text" class="form-control" name="pictureUrl"
                                   placeholder="http://www.picture.website.fr/my-picture.png" required="" value="${contact.pictureUrl}">
                            <div class="invalid-feedback">Une URL valide est obligatoire.</div>
                        </div>
                    </div>
                    <script>
                        let checkboxPictures = document.getElementById("togglePictureOptions");
                        checkboxPictures.addEventListener('change', function () {
                            document.getElementById("pictureUrl").disabled = !this.checked;
                            document.getElementById("pictureFile").disabled = this.checked;
                        });
                    </script>
                    <div class="col-12">
                        <label for="note" class="form-label">Notes</label>
                        <div class="input-group">
                            <textarea class="form-control" id="note" name="note" rows="3">${contact.note}"</textarea>
                        </div>
                    </div>
                    <%--<div class="col-sm-6">
                        <label for="author" class="form-label">Author</label>
                        <select class="form-select" id="author" name="authorIds" required="true" multiple>
                            <option disabled selected>Choose...</option>
                            <c:forEach items="${authorList}" var="author">
                                <option value="${author.id}">${author.firstname} ${author.lastname}</option>
                            </c:forEach>
                        </select>
                    </div>--%>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button class="btn btn-primary btn-sm my-3" type="submit">Modifier le contact</button>
                    <button class="btn btn-secondary btn-sm my-3" type="reset">Annuler</button>
                </form>
            </div>
        </div>

    </main>


    <jsp:include page="footer.jsp"/>
</div>

<script src="${pageContext.request.contextPath}/docs/5.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<script src="form-validation.js"></script>


</body>