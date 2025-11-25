package org.example.repasoKotlin.tema1

import java.io.BufferedReader
import java.io.InputStreamReader

/* Ejercicio 2: Ejecutar un proceso con argumentos
Enunciado: Modifica el ejercicio anterior para ejecutar el comando ls -l y mostrar la salida. Requisitos:

Pasar argumentos al proceso.*/
class Ejercicio2 {
}
fun main() {
    val p1 = ProcessBuilder("cmd", "/c", "dir C:\\Windows /q")
    val proceso = p1.start()
    val reader = proceso.inputStream.bufferedReader()

    var linea = reader.readLine()

    while (linea != null){
        println(linea)
        linea = reader.readLine()
    }
    proceso.waitFor()
}
