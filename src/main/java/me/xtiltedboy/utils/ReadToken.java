package me.xtiltedboy.utils;

import java.io.*;

public class ReadToken {

    //Declaramos la constante token
    private static String token = null;

    public static String getToken() {

        //Abrimos el archivo
        File archive = new File("D:\\Informatica por mi cuenta\\Java\\Shortener\\Shortener\\src\\main\\java\\me\\xtiltedboy\\secrets\\token.env");
        FileReader fr;
        {
            try {
                fr = new FileReader(archive);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = new BufferedReader(fr);

        //Leemos el token.env
        {
            try {
                token = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return token;
    }

}
