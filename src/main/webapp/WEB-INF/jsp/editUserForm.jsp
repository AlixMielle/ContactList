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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css">
    <script type="text/javascript">
        function clearSearch() {
            window.location = "${pageContext.request.contextPath}/contacts/all";
        }
    </script>
</head>
<body class="bg-light">

<jsp:include page="header.jsp"/>

<div class="container">
    <main>
        <div class="py-5">
            <h2>Modifiez votre profil</h2>
            <p class="lead">C'est l'occasion de mettre à jour vos coordonnées</p>
            <hr class="my-1">
        </div>

        <div class="row g-3">
            <div class="col-md-7 col-lg-8">
                <form action="${pageContext.request.contextPath}/edit/${user.id}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${user.id}">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="lastname" class="form-label">Nom</label>
                            <input type="text" class="form-control" id="lastname" name="lastname" value="${user.lastname}">
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="firstname" class="form-label">Prénom</label>
                            <input type="text" class="form-control" id="firstname" name="firstname" value="${user.firstname}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="password" class="form-label">Mot de passe</label>
                            <input type="password" class="form-control" id="password" name="password" value="${user.password}">
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
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button class="btn my-2 text-white" style="background-color: darkslategray" type="submit">Modifier le profil</button>
                    <button class="btn my-2 text-white" style="background-color: darkslategray" type="reset">Annuler</button>
                    <div>
                        <a href="${pageContext.request.contextPath}/contacts/all" style="color: darkslategray">Retour à la liste</a>
                    </div>
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