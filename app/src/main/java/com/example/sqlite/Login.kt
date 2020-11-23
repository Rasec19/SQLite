package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import org.jetbrains.anko.startActivity


class Login : AppCompatActivity(){
    var ListaUsuarios = ArrayList<Usuarios>()
    var Usuario:String?=null
    var password:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonRegistrarUsuario.setOnClickListener {
            startActivity<AddActivity>()
        }

          buttonIngresar.setOnClickListener{

              val values: ArrayList<String>
              var Usuario:String?=null
              var password:String?=null
              Usuario=editTextUsuario.toString()
              textViewIntent.text=edad.toString()
              values.add(Usuario)
              values.add("")


              if(id == 0){
                  val ID = baseDatos.insert(values)
                  val ID = baseDatos.query(values)
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









    class UsuariAdapter(contexto: Context, var ListaUsuarios: ArrayList<Usuarios>): BaseAdapter() {


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            TODO("Not yet implemented")
        }


        override fun getCount(): Int {
            return ListaUsuarios.size
        }

        override fun getItem(position: Int): Any {
            return ListaUsuarios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
    }


}