package com.example.sqlite

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }


    var Usuario:String?=null
    var password:String?=null
}