package org.example.repasoKotlin.tema1
/*Ejercicio 1: Ejecutar un comando simple
Enunciado: Escribe un programa en Kotlin que ejecute el comando ls (o dir en Windows) y muestre la salida por pantalla. Requisitos:

Usar ProcessBuilder.
Mostrar la salida estándar del proceso. */


class Ejercicio1 {
}
 fun main(){
    val p1 = ProcessBuilder("cmd", "/c", "dir")
    val proceso = p1.start()
    val reader = proceso.inputStream.bufferedReader()
    var linea = reader.readLine()

    while(linea != null){
        println(linea)
            linea = reader.readLine()
    }
     proceso.waitFor()
}
