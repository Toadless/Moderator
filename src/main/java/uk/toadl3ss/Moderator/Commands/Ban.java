package uk.toadl3ss.Moderator.Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Resources.noPermissionEmbed;

public class Ban {
    public static void banCommand(MessageReceivedEvent event, String[] args) {
        if (!event.getMember().hasPermission(Permission.getFromOffset(0x00000004))) {
            noPermissionEmbed.sendNoPermissionEmbed(event);
            return;
        }
        if (args.length < 2) {
            event.getChannel().sendMessage("Please provide a member to ban!").queue();
            return;
        }
        if (event.getMessage().getMentionedUsers().isEmpty()) {
            event.getChannel().sendMessage("Please provide a valid member to ban!").queue();
            return;
        }
        final Member target = event.getMessage().getMentionedMembers().get(0);
        final Member selfMember = event.getGuild().getSelfMember();
        if (!selfMember.canInteract(target) || !selfMember.hasPermission(Permission.BAN_MEMBERS)) {
            event.getChannel().sendMessage("Missing permissions to ban:" + " " + target.getNickname() + ".").queue();
            return;
        }
        try {
            event.getGuild()
                    .ban(target, 1)
                    .queue();
            event.getChannel().sendMessage("Banned" + " " + target.getNickname());
        } catch (Error e) {
            event.getChannel().sendMessage("An error occured. I guess that I dont have permissions.").queue();
            return;
        }

    }
}
