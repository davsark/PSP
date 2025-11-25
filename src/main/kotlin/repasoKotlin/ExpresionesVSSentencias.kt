package org.example.repasoKotlin

class ExpresionesVSSentencias {
    fun categoriaPersona(edad: Int) : String{
        return when {
            edad < 0 -> "Edad inválida"
            edad <= 12 -> "Niño"
            edad <= 17 -> "Adolescente"
            edad <= 64 -> "Adulto"
            else -> "Adulto Mayor"
        }
    }
    fun descuentoEntrada(edad: Int): Double{
        return when {
            edad <= 18 || edad >= 65 -> 0.5
            else -> 1.0
        }
    }
}

  /*  fun main() {
        val edades = listOf(5, 16, 25, 70, -1)

        edades.forEach { edad ->
            val categoria = categoriaPersona(edad)
            val descuento = descuentoEntrada(edad)
            println("Edad: $edad -> Categoría: $categoria, Descuento: ${(1-descuento)*100}%")
        }
    }*/