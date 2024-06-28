package com.example.hangman;

public class Characters {
    public static SpecialCharacters[] specialCharacters = new SpecialCharacters[]
            {
                    new SpecialCharacters("a", new String[]{"á", "â", "ä"}),
                    new SpecialCharacters("a", new String[]{"é", "ê", "ë"}),
                    new SpecialCharacters("a", new String[]{"í", "î", "ï"}),
                    new SpecialCharacters("a", new String[]{"ó", "ô", "ö"}),
                    new SpecialCharacters("a", new String[]{"ú", "û", "ü"})
            };

    public static SpecialCharacters GetSpecialChar(String letter)
    {
        for (int i = 0; i< specialCharacters.length; i++)
        {
            if(specialCharacters[i].value.equals(letter))
            {
                return specialCharacters[i];
            }
        }
        return null;
    };
}

class SpecialCharacters
{
    public String value;
    public String[] result;

    public SpecialCharacters(String value, String[] result) {
        this.value = value;
        this.result = result;
    }
}