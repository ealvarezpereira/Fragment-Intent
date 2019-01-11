package com.nr1k.kayku.verticalhorizontal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast



class MainActivity : AppCompatActivity() {

    var horizontal = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //if (windowManager.defaultDisplay.rotation == Surface.ROTATION_90) {
        //    toast("horizontal")
        //}

        if(id_horizontal != null){

            horizontal = true
        }

        if (horizontal){
            toast("Horizontal")
        }
    }
}
