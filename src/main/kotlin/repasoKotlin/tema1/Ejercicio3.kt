package org.example.repasoKotlin.tema1

import java.io.BufferedReader
import java.io.InputStreamReader

class Ejercicio3 {
}

fun main() {

    // ProcessBuilder crea un proceso externo del sistema operativo.
    // Aquí intentamos ejecutar un comando que NO existe.
    val pb = ProcessBuilder("cmd.exe", "/c", "echo ¡Mensaje CORRECTO! & type archivo_que_no_existe.txt")

    // Indicamos que NO queremos mezclar la salida estándar con la de error.
    // Si fuera true, errorStream se mezclaría con inputStream.
    pb.redirectErrorStream(false)

    // Se inicia el proceso externo.
    // Como el comando no existe, el proceso producirá error.
    val process = pb.start()

    // Creamos un lector para la salida estándar (lo que normalmente imprime el comando).
    val stdOut = BufferedReader(InputStreamReader(process.inputStream))

    // Creamos un lector para la salida de error (lo que imprime el comando cuando falla).
    val stdErr = BufferedReader(InputStreamReader(process.errorStream))

    var linea = stdOut.readLine()
    // Imprimimos lo que haya en la salida estándar.
    println("Salida estándar:")
        while(linea != null){
            println(linea)
                linea = stdOut.readLine()
        }

    // Imprimimos lo que haya en la salida de error.
    // Aquí aparecerá el mensaje diciendo que el comando no se encontró.
    println("Salida de error:")
    stdErr.lines().forEach { println(it) }
}
