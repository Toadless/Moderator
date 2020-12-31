package uk.toadl3ss.Moderator.Commands;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import uk.toadl3ss.Moderator.Database.Database;
import uk.toadl3ss.Moderator.Resources.noPermissionEmbed;

public class Prefix extends ListenerAdapter {
    public static void prefixCommand(MessageReceivedEvent event, String[] args, DBObject query, DBCursor cursor) {
        if (!event.getMember().hasPermission(Permission.getFromOffset(0x00000020))) {
            noPermissionEmbed.sendNoPermissionEmbed(event);
            return;
        }
        if (args.length < 2) {
            event.getChannel().sendMessage("Your current prefix is:" + " " + cursor.one().get("prefix")).queue();
            return;
        }
        try {
            DBObject update = new BasicDBObject("prefix", args[1]);
            update.put("id", event.getGuild().getId());
            //Database.guild.findAndModify(query, blank, blank, false, new BasicDBObject("$set", "prefix", args[1]), true ,true); // Updating the guilds database document
            Database.guild.update(query, update);
            event.getChannel().sendMessage("Successfully set this guilds prefix to" + " " + args[1]).queue();
        } catch (Error e) {
            event.getChannel().sendMessage("An error occured.").queue();
            return;
        }
    }
}