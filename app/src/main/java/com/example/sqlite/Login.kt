package com.example.sqlite

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonRegistrarUsuario.setOnClickListener {
            startActivity<AddActivity>()
        }

    }

    var Usuario:String?=null
    var password:String?=null







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