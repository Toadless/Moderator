package uk.toadl3ss.Moderator.Commands.Owner;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Resources.noPermissionEmbed;
import uk.toadl3ss.Moderator.Utils.Config;
import uk.toadl3ss.Moderator.Utils.CurrentDate;

public class Shutdown {
    public static void shutdownCommand(MessageReceivedEvent event, String[] args) {
        final String id = event.getMember().getId();
        if (!id.equals(Config.INS.getOwnerId())) {
            noPermissionEmbed.sendNoPermissionEmbed(event);
            return;
        }
        event.getChannel().sendMessage("Bot shutting down!").queue();
        System.out.println(CurrentDate.date + "System shutting down.");
        System.exit(0);
    }
}