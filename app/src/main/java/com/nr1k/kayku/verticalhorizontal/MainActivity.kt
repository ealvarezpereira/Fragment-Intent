package com.nr1k.kayku.verticalhorizontal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast



class MainActivity : AppCompatActivity() {

    var horizontal = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_boton.setOnClickListener{

            //Si el id del textview de la vista en horizontal esta activo le asignamos
            //el valor true a la variable horizontal
            if(id_horizontal != null){

                horizontal = true
            }

            //si es true que muestre un toast
            if (horizontal){
                toast("Horizontal")
            }else{
                //si es false creamos un intent que llame a la Activity2
                //val intent = Intent(this, Activity2::class.java).apply{
                    //Con el putExtra enviamos datos a la activity nueva
                //    putExtra("id",5)
                //}
                //iniciamos la activity del intent
                //startActivity(intent)

                //Inicia la actividad pero simplificado con anko
                startActivity(intentFor<Activity2>("id" to 5))
            }
        }
    }
}
