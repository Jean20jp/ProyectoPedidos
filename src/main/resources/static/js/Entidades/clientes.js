$(() => {
    getClientes();
})

const getClientes = () => {
    $('#tabla-clientes > tbody').empty();

    $.ajax({
        type: "GET",
        url: "https://projectpedidos.herokuapp.com/clientes",
        success: function (response) {
            $.each(response, function (i, cliente) {
                let row = `
                <tr>
                    <td>${cliente.idCli}</td>
                    <td>${cliente.nomCli}</td>
                    <td>${cliente.apeCli}</td>
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
    let contcli = $('#contcli').val();

    if (validarCampos(idcli, nomcli, apecli, contcli)) {
        
        const cliente = {
            idCli: idcli,
            nomCli: nomcli,
            apeCli: apecli,
            contCli: contcli
        };

        $.ajax({
            type: "POST",
            url: "https://projectpedidos.herokuapp.com/clientes",
            data: JSON.stringify(cliente),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                getClientes();
                $("#btn-cerrar").click();
                limpiarCampos();
                
            },
            error: function (error) {

                $('#mensaje-formulario').text(error.responseJSON.mensaje);
                alert("Cedula o contraseña incorrecta")
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
    $('#contcli').val('');
    $('#idcli').attr('disabled', false);
    $('#btn-aceptar').attr("onclick", "setCliente()");
}

const validarCampos = (idcli, nomcli, apecli, contcli) => {
    if (!idcli || !nomcli || !apecli || !contcli) {
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
        url: "https://projectpedidos.herokuapp.com/clientes/cliente?idCli=" + idCli,
        success: function (cliente) {
            $('#idcli').val(cliente.idCli);
            $('#nomcli').val(cliente.nomCli);
            $('#apecli').val(cliente.apeCli);
            $('#contcli').val(cliente.contCli);
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
    let contCli = $('#contcli').val();
    console.log(contCli);

    if (validarCampos(idCli, nomCli, apeCli, contCli)) {
        const cliente = {
            idCli: idCli,
            nomCli: nomCli,
            apeCli: apeCli,
            contCli: contCli
        };
        $.ajax({
            type: "PUT",
            url: "https://projectpedidos.herokuapp.com/clientes",
            data: JSON.stringify(cliente),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                limpiarCampos();
                getClientes();
                $('#btn-cerrar').click();
            },
            error: function (error) {
                alert(error.responseJSON.mensaje);
                location.reload();
            }
        });
    }
}

const deleteCliente = (idCli) => {
    $.ajax({
        type: "DELETE",
        url: "https://projectpedidos.herokuapp.com/clientes?idCli=" + idCli,
        success: function (response) {
            
            getClientes();
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    });
}

const registroCliente = () => {
    let idcli = $('#cedula').val();
    let nomcli = $('#nombre').val();
    let apecli = $('#apellido').val();
    let contcli = $('#contraseña').val();

    if (validarCampos(idcli, nomcli, apecli, contcli)) {
        
        const cliente = {
            idCli: idcli,
            nomCli: nomcli,
            apeCli: apecli,
            contCli: contcli
        };

        $.ajax({
            type: "POST",
            url: "https://projectpedidos.herokuapp.com/clientes",
            data: JSON.stringify(cliente),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
            },
            error: function (error) {

                $('#mensaje-formulario').text(error.responseJSON.mensaje);
                alert("Cedula o contraseña incorrecta")
                setTimeout(() => {
                    $('#mensaje-formulario').toggle();
                }, 100);
                $('#mensaje-formulario').toggle();
            }
        });
    }
}