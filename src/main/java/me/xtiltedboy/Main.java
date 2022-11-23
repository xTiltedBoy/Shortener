package me.xtiltedboy;

import me.xtiltedboy.commands.shorten;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.internal.entities.ActivityImpl;

import javax.security.auth.login.LoginException;

import static java.lang.Thread.sleep;

public class Main {

    public static JDA shardman;
    public static JDABuilder builder;

    public static void main(String[] args) throws LoginException, InterruptedException {

        builder = JDABuilder
                .createDefault("MTA0NDc3MTM4MzA2ODA2OTg5MA.GDhP_r.TzRyomlRy-PbaACMX9Sm8ZTZw66qn3e4GVaoNw")
                .addEventListeners(new shorten());
        builder
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("Info  + Adelante"));
        shardman = builder.build();
        sleep(5000);
        shardman.getGuildById("1044782214409371738").upsertCommand("shorten", "Crea un enlace acortado")
                .addOption(OptionType.STRING, "url", "url que desea acortar", true).queue();

    }
}