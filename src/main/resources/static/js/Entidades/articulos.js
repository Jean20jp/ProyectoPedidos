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
                        <button type="button" class="btn btn-warning">Editar</button>
                        <button type="button" class="btn btn-danger">Eliminar</button>
                    </td>
                </tr>
                `;
                $('#tabla-articulos > tbody').append(row);
            });
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
                console.log(response);
            }
        });
    }
}

const limpiarCampos = () => {
    let id = $('#id').val('');
    let nombre = $('#nombre').val('');
    let peso = $('#peso').val('');
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

const editArticulo = () => {
    let id = $('#id').val();
    let nombre = $('#nombre').val();
    let peso = $('#peso').val();


    if (validarCampos(id, nombre, peso)) {
        const estudiante = {
            idArt: id,
            nomArt: nombre,
            pesArt: peso
        };
        $.ajax({
            type: "PUT",
            url: "http://localhost:8081/articulos",
            data: JSON.stringify(estudiante),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert(response.mensaje);
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

const deleteArticulos = (idArt) => {

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8081/articulos?idArt=" + idArt,
        success: function (response) {
            alert(response.mensaje)
            getEstudiantes();
        },
        error: function (error) {
            alert(error.responseJSON.mensaje);
            location.reload();
        }
    });
}