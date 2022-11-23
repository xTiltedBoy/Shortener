package me.xtiltedboy;

import me.xtiltedboy.commands.Shorten;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

import static java.lang.Thread.sleep;

public class Main {

    public static JDA shardman;
    public static JDABuilder builder;
    static ReadToken token = new ReadToken();

    public static void main(String[] args) throws LoginException, InterruptedException {

        //Definimos los atributos del bot
        builder = JDABuilder
                .createDefault(token.getToken())
                .addEventListeners(new Shorten());
        builder
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("Info  + Adelante"));

        //Construimos el bot
        shardman = builder.build();
        sleep(5000);

        //Añadimos el comando shorten
        shardman.getGuildById("1044782214409371738").upsertCommand("shorten", "Crea un enlace acortado")
                .addOption(OptionType.STRING, "url", "url que desea acortar", true).queue();

    }
}