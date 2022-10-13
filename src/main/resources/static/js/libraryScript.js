var urllibrary = 'http://localhost:8080/';
function getLibraries(){  //Funcion Get
    $.ajax({
        url : urllibrary + "api/Lib/all",
        type : 'GET',
        dataType : 'json',

        success : function(libraries) {
            let cs = libraries;
            $("#listLibraries").empty();

            let k = ""
            k += "<table class='tb'>";
            k += "<tr>";
            k += "<th class='hidden'>" + "Id" + "</th>";
            k += "<th>" + "Objetivo" + "</th>";
            k += "<th>" + "Capacidad" + "</th>";
            k += "<th>" + "Categoría" + "</th>";
            k += "<th>" + "Nombre" + "</th>";
            k += "</tr>";
            for(i=0;i<cs.length;i++){
                k += "<tr>";
                k += "<td class='hidden'>" + cs[i].id + "</td>";
                k += "<td>" + cs[i].target + "</td>";
                k += "<td>" + cs[i].capacity + "</td>";
                k += "<td>" + cs[i].category_id + "</td>";
                k += "<td>" + cs[i].name + "</td>";
              //  k += "<td>" + "<button onclick='getDetailLibrary("+cs[i].id+")'>Actualizar</button> " + "</td>";
              //  k += "<td>" + "<button onclick='deleteLibrary("+cs[i].id+")'>Eliminar</button><br>" + "</td>";
                k += "</tr>";

//                        $("#listlibraries").append(k);
            }
            k += "</table>";
            $("#listLibraries").append(k);

        },
        error : function(xhr, status) {
            alert('Error al modificar el librarye. Revise los datos y/o conexión con el servidor');
        }
    });
}

function getLibraryData(){
    let data ={
        target:$("#targetLibrary").val(),
        capacity:$("#capacityLibrary").val(),
        category:{
            id:$("#categoryIdLibrary option:selected").val(),
        },
        name:$("#nameLibrary").val(),
        description:$("#descriptionLibrary").val()
    }
    return data;
    //{"target":"Lectura4","capacity":5,"category":{"id":1},"name":"Sala de lectura para 5 personas","description":"Sala de lectura para 5 personas"}
}

