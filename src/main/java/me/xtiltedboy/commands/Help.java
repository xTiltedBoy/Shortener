package me.xtiltedboy.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Help extends ListenerAdapter {

    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("help")) {

            if (event.getOption("command").getAsString().equals("shorten")) {
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Help - " + event.getUser().getName())
                        .setDescription("The function of the bot is to shorten links, for more information execute " +
                                "/help shorten or /help unshorten")
                        .setColor(new Color(252, 3, 3, 255));
                event.replyEmbeds(embed.build()).queue();
            }

        }
    }
}
