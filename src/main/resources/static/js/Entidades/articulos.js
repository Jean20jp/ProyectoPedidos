$(() => {
    getArticulos();
})

const getArticulos = () => {
    $('#tabla-articulos > tbody').empty();

    $.ajax({
        type: "GET",
        url: "http://localhost:8081/articulos",
        success: function (response) {
            $.each(response, function (i, articulo) {
                let row = `
                <tr>
                    <td>${articulo.idArt}</td>
                    <td>${articulo.nomArt}</td>
                    <td>${articulo.pesArt}</td>
                    <td>
                        <button type="button" class="btn btn-warning" onclick="getArticulo(${articulo.idArt})" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button>
                        <button type="button" class="btn btn-danger" onclick="deleteArticulo(${articulo.idArt})">Eliminar</button>
                    </td>
                </tr>
                `;
                $('#tabla-articulos > tbody').append(row);
            });
        },
        error: function (error) {
            $('#mensaje').toggle();
            $('#mensaje').text(error.responseJSON.mensaje);
        }
    });
}

const setArticulo = () => {
    let id = $('#id').val();
    let nombre = $('#nombre').val();
    let peso = $('#peso').val();

    if (validarCampos(id, nombre,peso)) {
        
        const articulo = {
            idArt: id,
            nomArt: nombre,
            pesArt: peso
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8081/articulos",
            data: JSON.stringify(articulo),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                getArticulos();
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
    $('#id').val('');
    $('#nombre').val('');
    $('#peso').val('');
    $('#id').attr('disabled', false);
    $('#btn-aceptar').attr("onclick", "setArticulo()");
}

const validarCampos = (id, nombre, peso) => {
    if(!id || !nombre || !peso){
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

const getArticulo = (idArt) => {
    console.log(idArt);
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/articulos/articulo?idArt=" + idArt,
        success: function (articulo) {
            $('#id').val(articulo.idArt);
            $('#nombre').val(articulo.nomArt);
            $('#peso').val(articulo.pesArt);
            $('#id').attr('disabled', true);
            $('#btn-aceptar').attr("onclick", "editArticulo()");

        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    })
}

const editArticulo = () => {
    let id = $('#id').val();
    let nombre = $('#nombre').val();
    let peso = $('#peso').val();


    if (validarCampos(id, nombre, peso)) {
        const articulo = {
            idArt: id,
            nomArt: nombre,
            pesArt: peso
        };
        $.ajax({
            type: "PUT",
            url: "http://localhost:8081/articulos",
            data: JSON.stringify(articulo),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Articulo Editado");
                limpiarCampos();
                getArticulos();
                $('#btn-cerrar').click();
            },
            error: function (error) {
                alert(error.mensaje);
                location.reload();
            }
        });
    }
}

const deleteArticulo = (idArt) => {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/articulos?idArt=" + idArt,
        success: function (response) {
            alert("Articulo Eliminado Correctamente")
            getArticulos();
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    });
}