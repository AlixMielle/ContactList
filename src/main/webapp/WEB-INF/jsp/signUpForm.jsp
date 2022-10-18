<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Contacts | Se connecter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css">
</head>
<body>

<main>

    <section class="py-2 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Mon carnet d'adresses</h1>
                <p class="lead text-muted">Faites de nouvelles rencontres et enregistrez-les simplement !</p>
            </div>
        </div>
    </section>

    <div class="album py-2 bg-light">
        <div class="py-2 container">

            <form action="${pageContext.request.contextPath}/signup" method="post">
                <div class="col-sm-6 m-2">
                    <label for="lastname">Nom</label>
                    <input type="text" name="lastname" id="lastname" class="form-control" required>
                </div>
                <div class="col-sm-6 m-2">
                    <label for="firstname">Prénom</label>
                    <input type="text" name="firstname" id="firstname" class="form-control" required>
                </div>
                <div class="col-sm-6 m-2">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" class="form-control" required>
                </div>
                <div class="col-sm-6 m-2">
                    <label for="password">Mot de passe</label>
                    <input type="password" name="password" id="password" class="form-control" required>
                </div>
                <%-- Picture Url --%>
                <div class="col-sm-6 m-2">
                    <label for="pictureUrl">Photo de profil :</label>
                    <input id="pictureUrl" type="text" class="form-control" name="pictureUrl"
                           placeholder="http://www.picture.website.fr/my-picture.png" required="">
                    <div class="invalid-feedback">Une URL valide est obligatoire.</div>
                </div>
        </div>
        <div class="col-sm-6 m-2">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit" class="btn my-2 text-white" style="background-color: darkslategray">Créer mon profil
            </button>
            <button type="reset" class="btn my-2 text-white" style="background-color: darkslategray">Annuler</button>
        </div>
        </form>
    </div>
    </div>
</main>


<jsp:include page="footer.jsp"/>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

</body>
</html>