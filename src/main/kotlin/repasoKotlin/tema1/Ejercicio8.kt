package org.example.repasoKotlin.tema1

import java.io.BufferedReader
import java.io.InputStreamReader

/*Ejercicio 8: Monitorizar el uso de CPU de un proceso
Enunciado: Escribe un programa que lance un proceso (por ejemplo, yes > /dev/null) y monitorice su uso de CPU durante 3 segundos usando el comando ps. Requisitos:

Lanzar y monitorizar el proceso.
Mostrar el uso de CPU.*/
class Ejercicio8 {
}
fun main() {
    val process = ProcessBuilder("yes").redirectOutput(ProcessBuilder.Redirect.DISCARD).start()
    val pid = process.pid()
    repeat(3) {
        Thread.sleep(1000)
        val ps = ProcessBuilder("ps", "-p", "$pid", "-o", "%cpu").start()
        val reader = BufferedReader(InputStreamReader(ps.inputStream))
        reader.lines().forEach { println(it) }
    }
    process.destroy()
}