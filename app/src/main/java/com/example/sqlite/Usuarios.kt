package com.example.sqlite

class Usuarios{

    var ID: Int? = null
    var Nombre: String? = null
    var Contraseña: String? = null
    var Correo: String? = null
    var Telefono: String? = null

    constructor(ID: Int,Nombre: String,Contraseña: String,Correo: String,Telefono: String){


        this.ID = ID
        this.Nombre = Nombre
        this.Contraseña = Contraseña
        this.Correo = Correo
        this.Telefono = Telefono
    }


}