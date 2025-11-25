package org.example.repasoKotlin
//Ejercicio: Crea un programa que declare variables de diferentes tipos
// (String, Int, Double, Boolean) usando tanto var como val.
// Incluye ejemplos de inferencia de tipos y conversiones explícitas.
class VariablesYTiposDeDatos {


}
fun main(){

    // Variables inmutables (val)
    val nombre: String = "Juan"
    val edad = 25 // Inferencia de tipo Int
    val altura = 1.75 // Inferencia de tipo Double
    val esEstudiante: Boolean = true

    // Variables mutables (var)
    var saldo = 1000.0
    var intentos = 0

    // Conversiones explícitas
    val edadString = edad.toString()
    val alturaInt = altura.toInt()

    println("Nombre: $nombre")
    println("Edad: $edad años")
    println("Altura: $altura metros")
    println("Es estudiante: $esEstudiante")
    println("Saldo actual: $saldo€")

    // Modificando variables mutables
    saldo -= 50.0
    intentos++

    println("Nuevo saldo: $saldo€")
    println("Intentos realizados: $intentos")


}