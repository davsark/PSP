package org.example.repasoKotlin.tema1
/*Ejercicio 4: Esperar a que termine un proceso
Enunciado: Escribe un programa que ejecute el comando sleep 2
y muestre un mensaje antes y después de la espera. Requisitos:
Usar waitFor() para esperar la finalización.*/
class Ejercicio4 {
}
fun main() {
    // Muestra un mensaje indicando que el proceso va a comenzar
    println("Iniciando proceso...")
    // ProcessBuilder crea un proceso del sistema operativo.
    // Aquí se ejecuta el comando "sleep 2".
    //
    // "sleep" es un comando de Linux/Mac que hace que el proceso espere.
    // "2" significa que el proceso dormirá durante 2 segundos.
    //
    // En Windows este comando no existe; habría que usar "timeout".
    val p1 = ProcessBuilder("timeout", "2")
    val proceso = p1.start()

    // Espera a que el proceso externo termine.
    // Esto bloquea el programa actual hasta que el comando finalice.
    proceso.waitFor()

    // Se imprime cuando el comando ha terminado de ejecutarse.
    println("Proceso finalizado.")
}
