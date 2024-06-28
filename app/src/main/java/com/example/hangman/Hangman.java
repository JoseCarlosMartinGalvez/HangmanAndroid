package com.example.hangman;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import com.example.hangman.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman extends AppCompatActivity {

    static private List<String> letters;

    static public String currentWord;

    static public int errorCount;

    static public MainActivity mainActivity = new MainActivity();

    static public String word;

    static public int totalletters;


    static public void GetRandomWord()
    {
        Random random = new Random();
        int indexRand = random.nextInt(Words.wordList.length);
        GetWordByIndex(indexRand);
    }

    static public void GetWordByIndex(int index)
    {
        letters = new ArrayList<>();
        currentWord = Words.wordList[index];
    }
    static public void AddLetter(String letter, Context context)
    {
        String lowerLetter = letter.toLowerCase();
        String lowerWord = currentWord.toLowerCase();
        if (letters.contains(lowerLetter))
        {
            //Esta letra ya la habias utilizado
        }
        else
        {
            letters.add(lowerLetter);
            SpecialCharacters getChars = Characters.GetSpecialChar(lowerLetter);
            if(getChars != null)
            {
                for (int i = 0 ; i < getChars.result.length; i++)
                {
                    letters.add(getChars.result[i]);
                }
            }
            boolean hasLetter = lowerWord.contains(lowerLetter);
            if(hasLetter)
            {
                if (totalletters >= currentWord.length()-1)
                {
                    Intent intent = new Intent(context, win.class);
                    context.startActivity(intent);
                }
            }
            else
            {
                errorCount++;
                if (errorCount >= Words.imageError.length -1)
                {
                    Intent intent = new Intent(context, loose.class);
                    context.startActivity(intent);
                }
            }
        }
    }

    public void loose()
    {
        Intent intent = new Intent(this, loose.class);
        startActivity(intent);
    }


    static public String GetWordInGame()
    {
        totalletters =0;
        String finalWord = "";
        for (int i = 0; i<currentWord.length(); i++)
        {
            String lowerLetter = String.valueOf(currentWord.charAt(i)).toLowerCase();
            //comprobar tilde y sobreescribir el lowerLetter por la del diccionario

            //lowerLetter = checkSpainDictionary(lowerLetter);
            boolean hasLetter = letters.contains(lowerLetter);
            if (hasLetter)
            {
                finalWord += String.valueOf(currentWord.charAt(i));
                totalletters = finalWord.length();
                System.out.println(totalletters);
            }
            else
            {
                finalWord += "_";
            }
        }
        totalletters = countNonUnderscoreCharacters(finalWord);

        System.out.println(totalletters);
        return finalWord;
    }

    static private int countNonUnderscoreCharacters(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != '_')
            {
                count++;
            }
        }
        return count;
    }

}
