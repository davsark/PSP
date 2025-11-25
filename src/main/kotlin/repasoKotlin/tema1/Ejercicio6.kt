package org.example.repasoKotlin.tema1

import kotlin.concurrent.thread

class Ejercicio6 {
}

fun main() {
    val comandos = listOf("1", "2", "3")

    val hilos = comandos.map { segundos ->
        thread {
            // En Windows se usa cmd para ejecutar "timeout /t X /nobreak"
            val process = ProcessBuilder(
                "cmd", "/c", "timeout", "/t", segundos, "/nobreak"
            ).start()

            process.waitFor()
            println("Proceso timeout $segundos terminado")
        }
    }

    hilos.forEach { it.join() }
}
