package me.xtiltedboy.utils;

import java.util.Random;

public class GenerateCode {

    private String code = "";

    public GenerateCode() {
        //Genero el code

        int i;
        for (i=1; i<=4; i++){
            //Declaro la bateria de caracteres
            String characters = "abcdefghijklmnopqrstuvwxyz"
                    + "ABCDEFGHIJKLMNPQRSTUVWXYZ"
                    + "0123456789";
            Random random = new Random();
            int randomIndex = random.nextInt(characters.length());
            code += characters.charAt(randomIndex);
        }
    }

    public String getCode() {
        return code;
    }
}
