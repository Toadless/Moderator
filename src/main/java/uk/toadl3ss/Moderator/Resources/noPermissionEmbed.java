package uk.toadl3ss.Moderator.Resources;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;

public class noPermissionEmbed {
    public static void sendNoPermissionEmbed(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.decode("0x" + Config.INS.getColor()));
        embed.setDescription(":negative_squared_cross_mark: You are not permitted to use that command.");
        event.getChannel().sendMessage(embed.build()).queue();
    }
}