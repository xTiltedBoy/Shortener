package me.xtiltedboy.commands;

import me.xtiltedboy.utils.GenerateCode;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Shorten extends ListenerAdapter {

    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("shorten")) {

            if (event.getOption("url").getAsString().length() < 7) {
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Shorter URL - " + event.getUser().getName())
                        .setDescription("Url no válida")
                        .setColor(new Color(252, 3, 3, 255));
                event.replyEmbeds(embed.build()).queue();
                return;
            }

            String protocolNotSecure = event.getOption("url").getAsString().substring(0, 7);
            String protocolSecure = event.getOption("url").getAsString().substring(0, 8);

            if (protocolNotSecure.equals("http://") || protocolSecure.equals("https://")) {
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Shorter URL - " + event.getUser().getName())
                        .setDescription("Original URL -> " + event.getOption("url").getAsString()
                                + "\nShorter URL -> https://shortener.tech/" + GenerateCode.getRandomCode(4))
                        .setColor(new Color(3, 107, 252));
                event.replyEmbeds(embed.build()).queue();
            } else {
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Shorter URL - " + event.getUser().getName())
                        .setDescription("Url no válida")
                        .setColor(new Color(252, 3, 3, 255));
                event.replyEmbeds(embed.build()).queue();
            }

        }
    }
}
