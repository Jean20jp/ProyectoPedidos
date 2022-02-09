$(() => {
    getPedidos();
    getDetalles();
})

const getPedidos = () => {
    $('#tabla-pedido > tbody').empty();

    $.ajax({
        type: "GET",
        url: "https://projectpedidos.herokuapp.com/pedidos",
        success: function (response) {
            $.each(response, function (i, detalle) {
                let row = `
                <tr>
                    <td>${detalle.idPed}</td>
                    <td>${detalle.fec_ped}</td>
                    <td>${detalle.idCli}</td>
                    <td>
                        <button type="button" class="btn btn-danger" onclick="deletePedido(${detalle.idPed})">Eliminar</button>
                    </td>
                </tr>
                `;
                $('#tabla-pedido > tbody').append(row);
            });
        },
        error: function (error) {
            $('#mensaje').toggle();
            $('#mensaje').text(error.responseJSON.mensaje);
        }
    });
}

const getPedido = (cedula) => {
    $('#tabla-pedido > tbody').empty();

    $.ajax({
        type: "GET",
        url: "https://projectpedidos.herokuapp.com/pedidos/pedidoCed?idCli=" + cedula,
        success: function (response) {
            $.each(response, function (i, pedido) {
                let row = `
                <tr>
                    <td>${pedido.idPed}</td>
                    <td>${pedido.fec_ped}</td>
                    <td>${pedido.idCli}</td>
                    <td>
                        <button type="button" class="btn btn-danger" onclick="deletePedido(${pedido.idPed})">Eliminar</button>
                    </td>
                </tr>
                `;
                $('#tabla-pedido > tbody').append(row);
            });
        },
        error: function (error) {
            $('#mensaje').toggle();
            $('#mensaje').text(error.responseJSON.mensaje);
        }
    });
}

const getDetalles = () => {
    $('#tabla-detalle > tbody').empty();

    $.ajax({
        type: "GET",
        url: "https://projectpedidos.herokuapp.com/detalle_ped",
        success: function (response) {
            $.each(response, function (i, detalle) {
                let row = `
                <tr>
                    <td>${detalle.idDet}</td>
                    <td>${detalle.idPed}</td>
                    <td>${detalle.cant}</td>
                    <td>${detalle.idArt}</td>
                    <td>
                        <button type="button" class="btn btn-danger" onclick="deleteDetalle(${detalle.idDet})">Eliminar</button>
                    </td>
                </tr>
                `;
                $('#tabla-detalle > tbody').append(row);
            });
        },
        error: function (error) {
            $('#mensaje').toggle();
            $('#mensaje').text(error.responseJSON.mensaje);
        }
    });
}

const deletePedido = (idPed) => {
    $.ajax({
        type: "DELETE",
        url: "https://projectpedidos.herokuapp.com/pedidos?idPed=" + idPed,
        success: function (response) {
            //alert(response.mensaje)
            getDetalles();
            getPedidos();
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    });
}

const deleteDetalle = (idDet) => {
    $.ajax({
        type: "DELETE",
        url: "https://projectpedidos.herokuapp.com/detalle_ped?idDet=" + idDet,
        success: function (response) {
            //alert(response.mensaje)
            getDetalles();
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    });
}