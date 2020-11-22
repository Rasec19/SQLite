package com.example.sqlite

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.molde_notas.*
import kotlinx.android.synthetic.main.molde_notas.view.*
import  org.jetbrains.anko.*

class MainActivity (var adapter: NotasAdapter? = null) : AppCompatActivity() {

    var listaDeNotas = ArrayList<Notas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cargarQuery("%")



    }

    override fun onResume() {
        super.onResume()
        cargarQuery("%")
    }


    fun cargarQuery(titulo: String){
        var baseDatos = DBManager(this)
        val columnas = arrayOf("ID", "Nombre", "Contraseña", "Correo", "Telefono")
        val selectionArgs = arrayOf(titulo)

        var cursor = baseDatos.query(columnas,"Nombre like ?",selectionArgs,"Nombre")

        listaDeNotas.clear()


        if (cursor.moveToFirst()){
            do{
                val ID = cursor.getInt(cursor.getColumnIndex("ID"))
                val nombre = cursor.getString(cursor.getColumnIndex("Nombre"))
                val contraseña = cursor.getString(cursor.getColumnIndex("Contraseña"))
                val correo = cursor.getString(cursor.getColumnIndex("Correo"))
                val telefono = cursor.getString(cursor.getColumnIndex("Telefono"))

                listaDeNotas.add(Notas(ID,nombre,contraseña,correo,telefono))
            }while (cursor.moveToNext())
        }

        adapter = NotasAdapter(this,listaDeNotas)

        listView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        val buscar = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val manejador = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        buscar.setSearchableInfo(manejador.getSearchableInfo(componentName))
        buscar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext,query,Toast.LENGTH_LONG).show()
                cargarQuery("%"+query+"%")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.menuAgregar ->{
                var intent = Intent(this,AddActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    inner class NotasAdapter(contexto: Context, var listaDeNotas: ArrayList<Notas>): BaseAdapter() {

        var contexto: Context? = contexto

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val nota = listaDeNotas[position]

            val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = inflater.inflate(R.layout.molde_notas, null)

            /*miVista.textViewNombreEmpleado.text = nota.nombre
            miVista.textViewCargoEmpleado.text = nota.contraseña
            miVista.textViewCorreo.text = nota.correo
            miVista.textViewNumeroTelefono.text = nota.telefono

            miVista.imageViewBorrar.setOnClickListener{
                val dbManager = DBManager(this.contexto!!)
                val selectionArgs = arrayOf(nota.notasID.toString())

                dbManager.borrar("ID=?",selectionArgs)
                cargarQuery("%")
            }*/

            /*miVista.imageViewEdicion.setOnClickListener{
                val intent = Intent(this@MainActivity,AddActivity::class.java)
                intent.putExtra("ID",nota.notasID)
                intent.putExtra("Nombre",nota.nombre)
                intent.putExtra("Cargo",nota.cargo)
                intent.putExtra("Correo",nota.correo)
                intent.putExtra("Telefono",nota.telefono)



                startActivity(intent)



            }*/


            return miVista
        }

        override fun getItem(position: Int): Any {
            return listaDeNotas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return  listaDeNotas.size
        }

    }

}
