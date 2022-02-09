const validarCliente = () => {
    let user = $('#user').val();
    let clave = $('#clave').val();
    console.log(user);
    console.log(clave);
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/clientes/validar?idCli=" + user + "&contCli=" + clave,
        success: function (response) {
            $.each(response, function (i, cliente) {
                window.location.href = "http://127.0.0.1:5500/vistas/pedidos.html";
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
        url: "http://localhost:8081/admin/validar?user=" + user + "&clave=" + clave,
        success: function (response) {
            $.each(response, function (i, cliente) {
                window.location.href = "http://127.0.0.1:5500/vistas/articulos.html";
            });
        },
        error: function (error) {
            //alert(error.responseJSON.mensaje);
            location.reload();
        }
    })
}
