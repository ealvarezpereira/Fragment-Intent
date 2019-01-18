package com.nr1k.kayku.verticalhorizontal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.toast


class Activity2 : AppCompatActivity() {

    var horizontal = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        val valor = intent.getIntExtra("id",0)
        toast(valor.toString())
        //dialContactPhone(valor.toString())

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frankmento, FrankMento.newInstance(), "Frankmento")
                .commit()
        }
    }
    private fun dialContactPhone(phoneNumber: String) {
        startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)))
    }
}