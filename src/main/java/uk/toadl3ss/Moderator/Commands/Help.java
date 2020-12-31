package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;

public class Help {
    public static void helpCommand(MessageReceivedEvent event, String[] args) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(event.getJDA().getSelfUser().getName(), "https://toadl3ss.uk", event.getJDA().getSelfUser().getAvatarUrl());
        embed.setTitle("Help Page");
        embed.setColor(Color.decode("0x" + Config.INS.getColor()));
        embed.addField("!Avatar", "Gives you a users avatar.", true);
        embed.addField("!Ban", "Bans the specified user.", true);
        embed.addField("!Botinvite", "Gives you a link to invite this bot.", true);
        embed.addField("!Clear", "Clears the specified amount of messages.", true);
        embed.addField("!Eightball", "Gives a random response.", true);
        embed.addField("!Help", "Gives you this help page.", true);
        embed.addField("!Info", "Gives you useless info about this bot.", true);
        embed.addField("!Invite", "Gives you an invite to a guild.", true);
        embed.addField("!Kick", "Kicks the specified user.", true);
        embed.addField("!Prefix", "Changes the prefix for the guild.", true);
        embed.addField("!Uptime", "Displays the bots uptime.", true);
        embed.addField("!Warn", "Warns the user.", true);
        embed.setFooter("Bot designed by Toadless#0001", "https://cdn.discordapp.com/avatars/582560658575589381/a_6d04d5080801695228949bfe59c9a138.gif");
        event.getChannel().sendMessage(embed.build()).queue();
    }
}