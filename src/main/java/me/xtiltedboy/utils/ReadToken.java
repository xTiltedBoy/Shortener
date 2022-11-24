package me.xtiltedboy.utils;

import java.io.*;

public class ReadToken {

    //Declaramos la constante token
    final private String token;

        //Abrimos el archivo
        File archive = new File("C:\\Users\\migue\\IdeaProjects\\Shortener\\src\\main\\java\\me\\xtiltedboy\\secrets\\token.env");
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
            this.token = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Getter del token
    public String getToken() {
        return this.token;
    }
}
