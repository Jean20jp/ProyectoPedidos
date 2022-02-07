$(() => {
    getClientes();
})

const getClientes = () => {
    $('#tabla-clientes > tbody').empty();

    $.ajax({
        type: "GET",
        url: "http://localhost:8081/clientes",
        success: function (response) {
            $.each(response, function (i, cliente) {
                let row = `
                <tr>
                    <td>${cliente.idCli}</td>
                    <td>${cliente.nomCli}</td>
                    <td>${cliente.apeCli}</td>
                    <td>${cliente.salCli}</td>
                    <td>
                        <button type="button" class="btn btn-warning" onclick="getCliente(${cliente.idCli})" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button>
                        <button type="button" class="btn btn-danger" onclick="deleteCliente(${cliente.idCli})">Eliminar</button>
                    </td>
                </tr>
                `;
                $('#tabla-clientes > tbody').append(row);
            });
        },
        error: function (error) {
            $('#mensaje').toggle();
            $('#mensaje').text(error.responseJSON.mensaje);
        }
    });
}

const setCliente = () => {
    let idcli = $('#idcli').val();
    let nomcli = $('#nomcli').val();
    let apecli = $('#apecli').val();
    let salcli = $('#salcli').val();
    let contcli = $('#contcli').val();

    if (validarCampos(idcli, nomcli, apecli, salcli, contcli)) {
        
        const cliente = {
            idCli: idcli,
            nomCli: nomcli,
            apeCli: apecli,
            salCli: salcli,
            contCli: contcli,
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8081/clientes",
            data: JSON.stringify(cliente),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                getClientes();
                $("#btn-cerrar").click();
                limpiarCampos();
                alert(response.mensaje);
            },
            error: function (error) {

                $('#mensaje-formulario').text(error.responseJSON.mensaje);
                setTimeout(() => {
                    $('#mensaje-formulario').toggle();
                }, 100);
                $('#mensaje-formulario').toggle();
            }
        });
    }
}

const limpiarCampos = () => {
    $('#idcli').val('');
    $('#nomcli').val('');
    $('#apecli').val('');
    $('#salcli').val('');
    $('#contcli').val('');
    $('#idcli').attr('disabled', false);
    $('#btn-aceptar').attr("onclick", "setCliente()");
}

const validarCampos = (idcli, nomcli, apecli, salcli, contcli) => {
    if (!idcli || !nomcli || !apecli || !salcli || !contcli) {
        $('#mensaje-formulario').text("Se debe rellenar todos los campos");
        setTimeout(() => {
            $('#mensaje-formulario').toggle();
        }, 100);
        $('#mensaje-formulario').toggle();
        return false;
    } else { 
        return true;
    }
}

const getCliente = (idCli) => {
    console.log(idCli);
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/clientes/cliente?idCli=" + idCli,
        success: function (cliente) {
            $('#idcli').val(cliente.idCli);
            $('#nomcli').val(cliente.nomCli);
            $('#apecli').val(cliente.apeCli);
            $('#salcli').val(cliente.salCli);
            $('#idcli').attr('disabled', true);
            $('#btn-aceptar').attr("onclick", "editCliente()");
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    })
}

const editCliente = () => {
    let idCli = $('#idcli').val();
    let nomCli = $('#nomcli').val();
    let apeCli = $('#apecli').val();
    let salCli = $('#salcli').val();
    let contCli = $('#contcli').val();

    if (validarCampos(idCli, nomCli, apeCli, salCli, contCli)) {
        const cliente = {
            idcli: idCli,
            nomcli: nomCli,
            apecli: apeCli,
            salcli: salCli,
            contcli: contCli
        };
        $.ajax({
            type: "PUT",
            url: "http://localhost:8081/clientes",
            data: JSON.stringify(cliente),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert(response.mensaje);
                limpiarCampos();
                getClientes();
                $('#btn-cerrar').click();
            },
            error: function (error) {
                alert(error.mensaje);
                location.reload();
            }
        });
    }
}

const deleteCliente = (idCli) => {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/clientes?idCli=" + idCli,
        success: function (response) {
            alert(response.mensaje)
            getClientes();
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    });
}