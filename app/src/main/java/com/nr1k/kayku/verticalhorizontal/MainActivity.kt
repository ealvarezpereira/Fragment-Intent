package com.nr1k.kayku.verticalhorizontal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast



class MainActivity : AppCompatActivity() {

    var horizontal = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_boton.setOnClickListener{

            if(id_horizontal != null){

                horizontal = true
            }

            if (horizontal){
                toast("Horizontal")
            }else{
                val intent = Intent(this, Activity2::class.java).apply{
                    putExtra("id",5)
                }
                startActivity(intent)
            }
        }
    }
}
