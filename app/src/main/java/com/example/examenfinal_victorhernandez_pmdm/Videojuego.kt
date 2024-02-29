package com.example.examenfinal_victorhernandez_pmdm

import java.io.Serializable

data class Videojuego (
    private var id: Int,
    private var nombre: String,
    private var valoracion: Double,
    private var empresaDesarrolladora: String,
    private var anioLanzamiento: Int
): Serializable {

    companion object

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getValoracion(): Double {
        return valoracion
    }

    fun setValoracion(valoracion: Double) {
        this.valoracion = valoracion
    }

    fun getEmpresaDesarrolladora(): String {
        return empresaDesarrolladora
    }

    fun setEmpresaDesarrolladora(empresaDesarrolladora: String) {
        this.empresaDesarrolladora = empresaDesarrolladora
    }

    fun getAnioLanzamiento(): Int {
        return anioLanzamiento
    }

    fun setAnioLanzamiento(anioLanzamiento: Int) {
        this.anioLanzamiento = anioLanzamiento
    }
}