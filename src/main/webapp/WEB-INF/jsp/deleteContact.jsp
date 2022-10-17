<!-- MODAL DELETE CONFIRMATION -->
<div class="modal fade" id="delete_modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Confirmation</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Voulez-vous supprimer ce contact ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Non</button>
                <form method="post" action="${pageContext.request.contextPath}/contacts/delete/${contact.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button type="submit" class="btn btn-danger">Oui</button>
                </form>
            </div>
        </div>
    </div>
</div>

<button type="button" class="btn btn-sm btn-outline-danger" data-bs-toggle="modal"
        data-bs-target="#delete_modal">
    Supprimer le contact
</button>