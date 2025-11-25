package org.example.repasoKotlin.tema1

import java.io.BufferedReader
import java.io.InputStreamReader

/*Ejercicio 7: Comunicación entre procesos
Enunciado: Escribe un programa que ejecute el comando echo hola y redirija su salida como entrada a otro proceso que ejecute tr a-z A-Z (convierte a mayúsculas). Requisitos:

Usar streams para conectar procesos.*/
class Ejercicio7 {
}
fun main() {
    // Creamos un proceso de PowerShell que imprime "hola" y lo convierte a mayúsculas
    val process = ProcessBuilder(
        "powershell", "-Command", "'hola'.ToUpper()"
    ).start()

    // Leemos la salida del proceso
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    reader.lines().forEach { println(it) } // Imprime "HOLA"
}