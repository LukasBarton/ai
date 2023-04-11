import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class FoodBot {
    public static void main(String[] args) {
        JDA jda = null;
        try {
            jda = new JDABuilder("MTA5MjcwNDQwOTczOTM0NTk1MA.Gdr5_2.JNiogOiYZAoVJ9QKiambk2vf_a18VwNvXoXfYI").build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

        jda.addEventListener(new FoodBotListener());
    }

    public static class FoodBotListener extends ListenerAdapter {
        private final String prefix = "!";

        @Override
        public void onMessageReceived(MessageReceivedEvent event) {
            if (event.getAuthor().isBot()) return;

            Message message = event.getMessage();
            MessageChannel channel = event.getChannel();
            String content = message.getContentRaw();

            if (content.startsWith(prefix)) {
                String command = content.substring(prefix.length()).toLowerCase();
                if (command.equals("food")) {
                    channel.sendMessage("Moje oblíbené jídlo je sushi! Co je tvoje?").queue();
                } else if (command.equals("hamburger")) {
                    channel.sendMessage("Hamburgery mám taky rád!").queue();
                } else if (command.equals("chesseburger")) {
                    channel.sendMessage("Chesseburgery jsou skvělý! Máš rád v nich okurku nebo ne?").queue();
                } else if (command.equals("pizza")) {
                    channel.sendMessage("Pizza je skvělá! Jaké zálivky máte rádi?").queue();
                } else if (command.equals("sushi")) {
                    channel.sendMessage("Sushi je moje oblíbené! Máte rádi nigiri nebo maki rolky?").queue();
                } else if (command.equals("nigiri")) {
                    channel.sendMessage("Nigiri jsou skvělý!").queue();
                } else if (command.equals("maki")) {
                    channel.sendMessage("Maki rolky jsou top!").queue();
                } else if (command.contains("pizza") && command.contains("zálivka")) {
                    channel.sendMessage("Mám rád pizzu s rajčatovou omáčkou a ananasem!").queue();
                } else if (command.contains("sushi") && command.contains("tvé oblíbené")) {
                    channel.sendMessage("Mám rád sushi z lososa a tuňáka!").queue();
                } else if (command.contains("chesseburger") && command.contains("okurka ne")) {
                    channel.sendMessage("Máš pravdu je to hrozný!").queue();
                } else if (command.contains("chesseburger") && command.contains("okurka ano")) {
                    channel.sendMessage("Jseš divnej...").queue();
                } else {
                    channel.sendMessage("Omlouvám se, nerozumím.").queue();
                }
            }
        }
    }
}

