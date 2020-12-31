package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Main;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;

public class Info {
    public static void infoCommand(MessageReceivedEvent event, String[] args) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(event.getJDA().getSelfUser().getName(), "https://toadl3ss.uk", event.getJDA().getSelfUser().getAvatarUrl());
        embed.setTitle("Info");
        embed.setColor(Color.decode("0x" + Config.INS.getColor()));
        embed.addField("Version", Main.version, true);
        embed.addField("Library", "JDA", true);
        embed.addField("Creator", "Toadless", true);
        event.getChannel().sendMessage(embed.build()).queue();
    }
}
