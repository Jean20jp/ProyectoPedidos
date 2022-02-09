$(() => {
    getDetalles();
})

const getDetalles = () => {
    $('#tabla-detalle > tbody').empty();

    $.ajax({
        type: "GET",
        url: "http://localhost:8081/detalle_ped",
        success: function (response) {
            $.each(response, function (i, detalle) {
                let row = `
                <tr>
                    <td>${detalle.idDet}</td>
                    <td>${detalle.idPed}</td>
                    <td>${detalle.cant}</td>
                    <td>${detalle.idArt}</td>
                    <td>
                        <button type="button" class="btn btn-warning" onclick="getDetalle(${detalle.idDet})" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button>
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


const setDetalle = () => {
    let idPed = $('#id-ped').val();
    let cantidad = $('#cantidad').val();
    let idArt = $('#id-art').val();

    if (validarCampos(idPed, cantidad, idArt)) {
        
        const detalle = {
            idPed: idPed,
            cant: cantidad,
            idArt: idArt
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8081/detalle_ped",
            data: JSON.stringify(detalle),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                getDetalles();
                $("#btn-cerrar").click();
                limpiarCampos();
                //alert(response.mensaje);
            },
            error: function (error) {

                $('#mensaje-formulario').text(error.responseJSON.mensaje);
                setTimeout(() => {
                    $('#mensaje-formulario').toggle();
                }, 1500);
                $('#mensaje-formulario').toggle();
            }
        });
    }
}

const limpiarCampos = () => {
    $('#idPed').val('');
    $('#cantidad').val('');
    $('#idArt').val('');
    $('#btn-aceptar').attr("onclick", "setDetalle()");
}

const validarCampos = (idPed, cantidad, idArt) => {
    if(!idPed || !cantidad || !idArt){
        $('#mensaje-formulario').text("Se debe rellenar todos los campos");
        setTimeout(() => {
            $('#mensaje-formulario').toggle();
        }, 1500);
        $('#mensaje-formulario').toggle();
        return false;
    }else{
        return true;
    }
}

const getDetalle = (idDet) => {
    console.log(idDet);
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/detalle_ped/detalle?idDet=" + idDet,
        success: function (detalle) {
            $('#id-det').val(detalle.idDet);
            $('#id-ped').val(detalle.idPed);
            $('#cantidad').val(detalle.cant);
            $('#id-art').val(detalle.idArt);
            $('#btn-aceptar').attr("onclick", "editDetalle()");

        },
        error: function (error) {
            //alert(error.responseJSON.mensaje);
            location.reload();
        }
    })
}

const editDetalle = () => {
    let idDet = $('#id-det').val();
    let idPed = $('#id-ped').val();
    let cantidad = $('#cantidad').val();
    let idArt = $('#id-art').val();


    if (validarCampos(idPed, cantidad, idArt)) {
        const detalle = {
            idDet : idDet,
            idPed: idPed,
            cant: cantidad,
            idArt: idArt
        };
        $.ajax({
            type: "PUT",
            url: "http://localhost:8081/detalle_ped",
            data: JSON.stringify(detalle),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                //alert(response.mensaje);
                limpiarCampos();
                getDetalles();
                $('#btn-cerrar').click();
            },
            error: function (error) {
                alert(error.mensaje);
                location.reload();
            }
        });
    }
}

const deleteDetalle = (idDet) => {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/detalle_ped?idDet=" + idDet,
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