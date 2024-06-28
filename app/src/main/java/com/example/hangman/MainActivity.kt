package com.example.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var newWord:String
    lateinit var gameWord: TextView
    lateinit var letterSelected:EditText
    lateinit var hangmanImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameWord = findViewById(R.id.Word)
        letterSelected = findViewById(R.id.Letter)
        hangmanImage = findViewById(R.id.hangman)

        Hangman.GetRandomWord();
        System.out.println(Hangman.currentWord);

        newWord = Hangman.GetWordInGame();
        System.out.println(newWord);

        Hangman.errorCount = 0;

        PrintWord();
    }

    public fun PrintWord()
    {
        newWord = Hangman.GetWordInGame()
        gameWord.text = newWord
        letterSelected.text = null
        hangmanImage.setImageResource(Words.imageError[Hangman.errorCount])
        //Printear la imagen segun la cantidad de errores

    }

    public fun CheckLetter(View:View)
    {
        Hangman.AddLetter(letterSelected.text.toString(),this)
        PrintWord()
    }

    public fun menu(View: View)
    {
        startActivity(Intent(this,menu::class.java))
    }
}