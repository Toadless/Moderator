package uk.toadl3ss.Moderator;

import net.dv8tion.jda.api.JDABuilder;
import uk.toadl3ss.Moderator.Commands.Ban;
import uk.toadl3ss.Moderator.Commands.Prefix;
import uk.toadl3ss.Moderator.Events.Mention;
import uk.toadl3ss.Moderator.Events.guildJoinEvent;
import uk.toadl3ss.Moderator.Events.guildLeaveEvent;

public class EventListeners {
    public static void addEventListeners(JDABuilder builder) {
        builder.addEventListeners(
                //Events
                new guildJoinEvent(),
                new guildLeaveEvent(),
                new Mention(),

                //Commands
                new CommandHandler()
        );
    }
}
