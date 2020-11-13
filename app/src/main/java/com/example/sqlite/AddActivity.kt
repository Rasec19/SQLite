package com.example.sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import java.lang.Exception

class AddActivity : AppCompatActivity() {

    var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        try{
            val bundle: Bundle? = intent.extras
            id = bundle!!.getInt("ID",0)

            if(id!=0){
                editTextNombreEmpleado.setText(bundle.getString("Nombre"))
                editTextCargo.setText(bundle.getString("Cargo"))
                editTextCorreo.setText(bundle.getString("Correo"))
                editTextNumeroTelefono.setText(bundle.getString("Telefono"))
            }
        }catch(e:Exception){}


    }

    fun btnAdd(view: View){

        val baseDatos = DBManager(this)

        val values = ContentValues()
            values.put("Nombre",editTextNombreEmpleado.text.toString())
            values.put("Cargo",editTextCargo.text.toString())
            values.put("Correo",editTextCorreo.text.toString())
            values.put("Telefono",editTextNumeroTelefono.text.toString())


        if(id == 0){
            val ID = baseDatos.insert(values)
            if(ID>0) {
                Toast.makeText(this, "El registro se ingreso con exito", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"El registro no se realizo!",Toast.LENGTH_LONG).show()
            }
        }else{
            val selectionArgs = arrayOf(id.toString())

            val ID = baseDatos.actualizar(values,"ID=?",selectionArgs)

            if(ID>0){
                Toast.makeText(this,"El registro se realizo con exito",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"El registro no se realizo con exito",Toast.LENGTH_LONG).show()
            }
        }


    }
}