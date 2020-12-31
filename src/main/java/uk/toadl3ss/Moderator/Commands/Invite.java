package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Invite {
    public static void inviteCommand(MessageReceivedEvent event, String[] args) {
        final TextChannel channel = event.getTextChannel();
        channel.createInvite()
                .flatMap(invite -> channel.sendMessage("here's the invite " + invite.getUrl()))
                .queue();
    }
}