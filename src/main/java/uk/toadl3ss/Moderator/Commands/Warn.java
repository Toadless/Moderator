package uk.toadl3ss.Moderator.Commands;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bson.Document;
import org.bson.types.ObjectId;
import uk.toadl3ss.Moderator.Database.Database;
import uk.toadl3ss.Moderator.Resources.noPermissionEmbed;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;

public class Warn {
    public static void warnCommand(MessageReceivedEvent event, String[] args) {
        if (!event.getMember().hasPermission(Permission.getFromOffset(0x00000004))) {
            noPermissionEmbed.sendNoPermissionEmbed(event);
            return;
        }
        if (args.length < 2) {
            event.getChannel().sendMessage("Please provide a member to warn!").queue();
            return;
        }
        if (event.getMessage().getMentionedUsers().isEmpty()) {
            event.getChannel().sendMessage("Please provide a valid member to warn!").queue();
            return;
        }
        final Member target = event.getMessage().getMentionedMembers().get(0);
        final Member selfMember = event.getGuild().getSelfMember();
        if (!selfMember.canInteract(target) || !selfMember.hasPermission(Permission.BAN_MEMBERS)) {
            event.getChannel().sendMessage("Missing permissions to warn:" + " " + target.getNickname() + "." + " " + "Required permission: BAN_MEMBERS.").queue();
            return;
        }
        DBObject query = new BasicDBObject("id", target.getId() + event.getGuild().getId());
        DBCursor cursor = Database.user.find(query);
        if (cursor.one() == null) {
            try {
                DBObject user = new BasicDBObject("id", target.getId() + event.getGuild().getId())
                        .append("warns", 0);
                Database.user.insert(user);
            } catch (Error e) {
               event.getChannel().sendMessage("An unknown error occurred. Please try again!").queue();
            }
        }
        BasicDBObject incValue = new BasicDBObject("warns", 1);
        BasicDBObject intModifier = new BasicDBObject("$inc", incValue);
        Database.user.update(query, intModifier, false, false, WriteConcern.SAFE);
        int warnInt = (int) cursor.one().get("warns");
        if (warnInt >= 3) {
            incValue = new BasicDBObject("warns", -3);
            intModifier = new BasicDBObject("$inc", incValue);
            Database.user.update(query, intModifier, false, false, WriteConcern.SAFE);
            event.getGuild()
                    .ban(target, 1)
                    .queue()
            ;
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.decode("0x" + Config.INS.getColor()));
            embed.setDescription(":white_check_mark: **Banned**" + " " + target.getEffectiveName() + " " + "because the have reached 3 infractions.");
            event.getChannel().sendMessage(embed.build()).queue();
            return;
        }
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.decode("0x" + Config.INS.getColor()));
        embed.setDescription(":white_check_mark: **Warned**" + " " + target.getEffectiveName() + ". " + "They now have" + " " + cursor.one().get("warns") + " " + "warn(s).");
        event.getChannel().sendMessage(embed.build()).queue();
    }
}