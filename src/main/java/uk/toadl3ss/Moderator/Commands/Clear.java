package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Resources.noPermissionEmbed;

import java.util.List;

public class Clear {
    public static void clearCommand(MessageReceivedEvent event, String[] args) {
        if (!event.getMember().hasPermission(Permission.getFromOffset(0x00000010))) {
            noPermissionEmbed.sendNoPermissionEmbed(event);
            return;
        }
        if (args.length <= 1) {
            event.getChannel().sendMessage("Please provide args bigger that are greater than 1!").queue();
            return;
        }
        if (args.length >= 100) {
            event.getChannel().sendMessage("I cannot bulk delete 100 messages at a time! 99 is the maximum.").queue();
            return;
        }
        final MessageChannel channel = event.getChannel();
        MessageHistory history = new MessageHistory(channel);
        List<Message> msgs;
        msgs = history.retrievePast(Integer.parseInt(args[1])).complete();
        event.getChannel().purgeMessages(msgs);
    }
}
