package com.nr1k.kayku.verticalhorizontal


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    var horizontal = false
    var resp = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        peticionwp()
        if(id_horizontal != null){

            horizontal = true
        }

        //si es true que muestre un toast
        if (horizontal){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frankmentoLand, FrankMento.newInstance(), "Frankmento")
                .commit()
        }

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



                startActivity(intentFor<Activity2>("id" to resp))
            }
        }
    }

    fun peticionwp() {
        var respuesta = ""
        // lanza la corutina NO en el hilo principal
        doAsync{
            // peticion a wordpress
            respuesta = URL("http://18.221.53.69/wp5/?rest_route=/wp/v2/posts/103").readText()
            // Accedemos al hilo principal
            uiThread {
                resp = respuesta
                longToast("Request performed")
            }
        }
    }
}


