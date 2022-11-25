package me.xtiltedboy;

import me.xtiltedboy.commands.Shorten;
import me.xtiltedboy.commands.Help;
import me.xtiltedboy.utils.ReadToken;
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


    public static void main(String[] args) throws LoginException, InterruptedException {

        //Definimos los atributos del bot
        builder = JDABuilder
                .createDefault(ReadToken.getToken())
                .addEventListeners(new Shorten())
                .addEventListeners(new Help());
        builder
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("Info  + Adelante"));

        //Construimos el bot
        shardman = builder.build();
        sleep(5000);

        //Añadimos el comando shorten
        shardman.getGuildById("1044782214409371738").upsertCommand("shorten", "Create a shortened link")
                .addOption(OptionType.STRING, "url", "URL you want to shorten", true).queue();

        //Añadimos el comando help
        shardman.getGuildById("1044782214409371738").upsertCommand("help", "Show bot help")
                .addOption(OptionType.STRING, "command", "COMMAND you want to describe", false).queue();


    }
}