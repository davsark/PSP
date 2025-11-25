package org.example.repasoKotlin.tema1

import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter
import kotlin.concurrent.thread

class Ejercicio10 {
}


fun main() {
    // Creamos un logger que escribirá en "app.log"
    val logger = Logger.getLogger("MyLogger")
    val fileHandler = FileHandler("app.log", true) // "true" = agrega al archivo
    fileHandler.formatter = SimpleFormatter()
    logger.addHandler(fileHandler)

    // Lista para guardar los hilos y poder esperarlos
    val hilos = mutableListOf<Thread>()

    // Creamos 5 hilos concurrentes
    repeat(5) { i ->
        val t = thread {
            logger.info("Iniciando proceso $i")

            // Simulamos trabajo durmiendo entre 1 y 3 segundos
            Thread.sleep((1000..3000).random().toLong())

            logger.info("Finalizando proceso $i")
        }
        hilos.add(t)
    }

    // Esperamos a que todos los hilos terminen antes de salir
    hilos.forEach { it.join() }

    println("Todos los procesos han finalizado. Logs en app.log")
}
