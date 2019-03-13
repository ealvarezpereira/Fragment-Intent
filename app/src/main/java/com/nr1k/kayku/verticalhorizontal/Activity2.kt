package com.nr1k.kayku.verticalhorizontal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity2.*

import org.json.JSONObject
import android.R.attr.data
import android.webkit.WebView



class Activity2 : AppCompatActivity() {

    var horizontal = false
    var valor = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        valor = intent.getStringExtra("id")
        metodoTitulo()
        parseJson()
        //if (savedInstanceState == null) {
        //    supportFragmentManager
        //        .beginTransaction()
        //        .add(R.id.frankmento, FrankMento.newInstance(), "Frankmento")
        //        .commit()
        //}
    }


    fun parseJson(){

        val jsonObj = JSONObject(valor)
        val jSonObjTitulo = jsonObj.getJSONObject("content")
        val strTitulo = jSonObjTitulo.getString("rendered")
        val webview = webview as WebView
        webview.settings.javaScriptEnabled = true
        webview.loadDataWithBaseURL("", strTitulo, "text/html", "UTF-8", "")
    }


    fun metodoTitulo(){

        val jsonObj = JSONObject(valor)
        val jSonObjTitulo = jsonObj.getJSONObject("title")
        val strTitulo = jSonObjTitulo.getString("rendered")
        textotweet.text = strTitulo
    }
}