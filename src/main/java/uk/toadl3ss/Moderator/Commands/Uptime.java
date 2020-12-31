package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Uptime {
    public static void uptimeCommand(MessageReceivedEvent event, String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeMXBean.getUptime();
        long uptimeInSeconds = uptime / 1000;
        long numberOfHours = uptimeInSeconds / (60 * 60);
        long numberOfMinutes = (uptimeInSeconds / 60) - (numberOfHours * 60);
        long numberOfSeconds = uptimeInSeconds % 60;

        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(event.getJDA().getSelfUser().getName(), "https://toadl3ss.uk", event.getJDA().getSelfUser().getAvatarUrl());
        embed.setTitle("Uptime");
        embed.setColor(Color.decode("0x" + Config.INS.getColor()));
        embed.addField("Hours:", String.valueOf(numberOfHours), true);
        embed.addField("Minutes:", String.valueOf(numberOfMinutes), true);
        embed.addField("Seconds:", String.valueOf(numberOfSeconds), true);
        event.getChannel().sendMessage(embed.build()).queue();
    }
}
