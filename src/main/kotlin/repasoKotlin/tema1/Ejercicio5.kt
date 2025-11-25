package org.example.repasoKotlin.tema1

import java.io.BufferedReader
import java.io.InputStreamReader

class Ejercicio5 {
}

fun main() {
    // Creamos un ProcessBuilder que ejecutará el comando "ps"
    // "ps" es un comando disponible en Linux/Mac que lista los procesos actuales
   //val p1 = ProcessBuilder("ps")
    val p1 = ProcessBuilder("cmd", "/c", "tasklist")

    // Iniciamos el proceso externo
    val proceso = p1.start()

    // Creamos un lector para capturar la salida estándar del comando
    val reader = BufferedReader(InputStreamReader(proceso.inputStream))

    var lineas = reader.readLine()
    // Leemos cada línea que imprime el comando y la mostramos en pantalla
   // reader.lines().forEach { println(it) }
    while (lineas != null){
        println(lineas)
            lineas = reader.readLine()
    }





}