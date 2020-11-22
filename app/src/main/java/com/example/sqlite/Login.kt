package com.example.sqlite

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*


class Login : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        buttonRegistrarUsuario.setOnClickListener {
            var intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

    }


    var Usuario:String?=null
    var password:String?=null
}