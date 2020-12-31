package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;

public class Avatar {
    public static void avatarCommand(MessageReceivedEvent event, String[] args) {
        if (args.length < 2) {
            event.getChannel().sendMessage("Please provide a user").queue();
            return;
        }
        if (event.getMessage().getMentionedUsers().isEmpty()) {
            event.getChannel().sendMessage("Please provide a valid member!").queue();
            return;
        }
        try {
            final User user = event.getMessage().getMentionedUsers().get(0);
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.decode("0x" + Config.INS.getColor()));
            embed.setTitle(user.getName() + "'s avatar.");
            embed.setImage(user.getAvatarUrl());
            embed.setAuthor(event.getJDA().getSelfUser().getName(), "https://toadl3ss.uk", event.getJDA().getSelfUser().getAvatarUrl());
            event.getChannel().sendMessage(embed.build()).queue();
        } catch (Error e) {
            event.getChannel().sendMessage("An error occured.").queue();
        }
    }
}
