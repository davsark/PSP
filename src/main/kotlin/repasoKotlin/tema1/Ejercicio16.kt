package org.example.repasoKotlin.tema1
import java.util.*
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

class Ejercicio16 {
}

fun main() {
    val logger = Logger.getLogger("MenuProcesos")
    val fileHandler = FileHandler("procesos.log", true)
    fileHandler.formatter = SimpleFormatter()
    logger.addHandler(fileHandler)

    val bgProcesses = mutableMapOf<Long, Process>()
    val scanner = Scanner(System.`in`)
    var running = true

    while (running) {
        println("\nMenú de procesos (Windows):")
        println("1. Ejecutar comando en primer plano")
        println("2. Ejecutar comando en segundo plano")
        println("3. Listar procesos en segundo plano")
        println("4. Finalizar proceso en segundo plano")
        println("5. Salir")
        print("Opción: ")

        when (scanner.nextLine().trim()) {
            "1" -> {
                print("Comando (ej: dir, timeout 3): ")
                val cmdInput = scanner.nextLine().split(" ")
                // Para Windows, usamos cmd /c antes del comando
                val cmd = mutableListOf("cmd", "/c") + cmdInput
                val process = ProcessBuilder(cmd).start()
                logger.info("Ejecutando en primer plano: ${cmd.joinToString(" ")}")
                process.inputStream.bufferedReader().lines().forEach { println(it) }
                process.waitFor()
            }
            "2" -> {
                print("Comando (ej: timeout 5, dir): ")
                val cmdInput = scanner.nextLine().split(" ")
                val cmd = mutableListOf("cmd", "/c") + cmdInput
                val process = ProcessBuilder(cmd).start()
                val pid = process.pid()
                bgProcesses[pid] = process
                logger.info("Ejecutando en segundo plano (PID $pid): ${cmd.joinToString(" ")}")
                println("Lanzado en segundo plano con PID $pid")
            }
            "3" -> {
                println("Procesos en segundo plano:")
                bgProcesses.forEach { (pid, proc) ->
                    println("PID $pid - Vivo: ${proc.isAlive}")
                }
            }
            "4" -> {
                print("PID a finalizar: ")
                val pid = scanner.nextLine().toLongOrNull()
                if (pid != null && bgProcesses.containsKey(pid)) {
                    bgProcesses[pid]?.destroy()
                    logger.info("Finalizado proceso en segundo plano PID $pid")
                    println("Proceso $pid finalizado")
                    bgProcesses.remove(pid)
                } else {
                    println("PID no válido")
                }
            }
            "5" -> {
                running = false
                logger.info("Menú finalizado por el usuario")
            }
            else -> println("Opción no válida")
        }
    }

    // Al salir, finalizar todos los procesos en segundo plano
    bgProcesses.values.forEach { it.destroy() }
}