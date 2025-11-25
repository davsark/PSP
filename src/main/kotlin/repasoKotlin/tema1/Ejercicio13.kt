package org.example.repasoKotlin.tema1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Ejercicio13 {
}



class IntegrationTest {

    @Test
    fun testProcessIntegrationWindows() {
        val temp = File.createTempFile("test", ".txt")

        // En Windows, redirigimos la salida de cmd /c echo
        ProcessBuilder("cmd", "/c", "echo hola mundo")
            .redirectOutput(temp)
            .start()
            .waitFor()

        // Leemos el contenido del archivo directamente en Kotlin
        val output = temp.readText().trim()

        assertEquals("hola mundo", output)

        temp.delete()
    }
}