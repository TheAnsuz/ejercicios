const inputFilas = document.getElementById("filas");
const inputColumnas = document.getElementById("columnas");

document.getElementById("submit").onclick = function () {
    filas = inputFilas.value;
    columnas = inputColumnas.value;

    console.log(filas + " " + columnas);
    createTable(filas, columnas);
}

function createTable(filas, columnas) {
    elem = document.getElementById("tablaPersonalizada");
    var tableData = "<table id='tablaPersonalizada' border='2'>";

    for (rows = 0; rows < filas; rows++) {
        tableData += "<tr>";

        for (column = 0; column < columnas; column++) {
            tableData += "<td>" + "Fila " + rows + " Columna " + column + "</td>";
        }

        tableData += "</tr>";
    }

    tableData += "</table>";
    document.write(inputFilas + inputColumnas + tableData);
}
