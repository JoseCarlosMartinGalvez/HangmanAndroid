package com.example.hangman

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class loose: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loose)
    }

    public fun menu(View: View)
    {
        startActivity(Intent(this,menu::class.java))
    }
}