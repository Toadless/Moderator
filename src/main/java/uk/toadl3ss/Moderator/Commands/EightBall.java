package uk.toadl3ss.Moderator.Commands;

import com.mongodb.DBCursor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import uk.toadl3ss.Moderator.Utils.Config;

import java.awt.*;
import java.util.Random;

public class EightBall {
    public static void eightballCommand(MessageReceivedEvent event, String[] args, DBCursor cursor) {
        if (args.length < 2) {
            event.getChannel().sendMessage("Please provide a message for me to awnser.").queue();
            return;
        }
        String[] answers = {
                "Yes",
                "No",
                "Maybe",
                "For sure, dude!",
                "Nah...",
                "No, really, no..."
        };
        Integer randomInt = new Random().nextInt(6);
        String question = event.getMessage().getContentRaw().replaceFirst("^" + cursor.one().get("prefix") + "8ball" + " ", "");
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.decode("0x" + Config.INS.getColor()));
        embed.setAuthor(event.getJDA().getSelfUser().getName(), "https://toadl3ss.uk", event.getJDA().getSelfUser().getAvatarUrl());
        embed.addField("Question:", question, false);
        embed.addField("Answer:", answers[randomInt], false);
        event.getChannel().sendMessage(embed.build()).queue();
    }
}
