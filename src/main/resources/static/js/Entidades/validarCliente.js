const validarCliente = () => {
    let user = $('#user').val();
    let clave = $('#clave').val();
    console.log(user);
    console.log(clave);
    $.ajax({
        type: "GET",
        url: "https://projectpedidos.herokuapp.com/clientes/validar?idCli=" + user + "&contCli=" + clave,
        success: function (response) {
            $.each(response, function (i, cliente) {
                window.location.href = "https://projectpedidos.herokuapp.com/vistas/pedidos.html";
            });
        },
        error: function (error) {
            //alert(error.responseJSON.mensaje);
            location.reload();
        }
    })
}

const validarAdmin = () => {
    let user = $('#user').val();
    let clave = $('#clave').val();
    console.log(user);
    console.log(clave);
    $.ajax({
        type: "GET",
        url: "https://projectpedidos.herokuapp.com/admin/validar?user=" + user + "&clave=" + clave,
        success: function (response) {
            $.each(response, function (i, cliente) {
                window.location.href = "https://projectpedidos.herokuapp.com/vistas/articulos.html";
            });
        },
        error: function (error) {
            //alert(error.responseJSON.mensaje);
            location.reload();
        }
    })
}
