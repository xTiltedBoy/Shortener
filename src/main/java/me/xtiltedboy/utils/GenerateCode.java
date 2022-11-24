package me.xtiltedboy.utils;

import java.util.Random;

public class GenerateCode {

    //Declaro la bateria de caracteres
    private static String characters = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNPQRSTUVWXYZ"
            + "0123456789";
    private static Random random = new Random();

    public static String getRandomCode(int lenth){
        //Genero el code
        String code = "";

        for (int i=1; i<=lenth; i++){
            int randomIndex = random.nextInt(characters.length());
            code += characters.charAt(randomIndex);
        }

        return code;
    }
}
