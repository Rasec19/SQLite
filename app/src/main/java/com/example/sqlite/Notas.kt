package com.example.sqlite

class Notas{

    var notasID: Int? = null
    var nombre: String? = null
    var cargo: String? = null
    var correo: String? = null
    var telefono: String? = null

    constructor(notasID: Int,nombre: String,cargo: String,correo: String,telefono: String){


        this.notasID = notasID
        this.nombre = nombre
        this.cargo = cargo
        this.correo = correo
        this.telefono = telefono
    }


}