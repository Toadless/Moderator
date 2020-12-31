package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BotInvite {
    public static void botinviteCommand(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessageFormat("My invite: https://discord.com/api/oauth2/authorize?client_id=%s&permissions=2147483639&scope=bot", event.getJDA().getSelfUser().getId()).queue();
    }
}