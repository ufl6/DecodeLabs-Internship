
import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bot: Hello! I'm a simple chatbot.");
        System.out.println("Bot: You can ask me what's my name, how I am, about the weather,or just say hello!");
        System.out.println("Bot: Type 'help' if you get stuck.");
        System.out.println("Type 'exit' or 'quit' or 'bye'  to end the conversation.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("exit") || userInput.equals("quit") || userInput.equals("bye")) {
                System.out.println("Bot: Goodbye! Have a great day!");
                break;
            } else if (userInput.equals("help")) {
                System.out.println("Bot: You can ask me the following questions:");
                System.out.println("- 'What is your name?'");
                System.out.println("- 'How are you?'");
                System.out.println("- 'Hello' or 'Hi'");
                System.out.println("- 'What is the weather like?'");
                System.out.println("You can also say 'exit', 'quit', or 'bye' to end the conversation.");
            } else if (userInput.contains("hello") || userInput.equals("hi") || userInput.equals("hey")) {
                System.out.println("Bot: Hello! How can I assist you today?");
            } else if (userInput.contains("how are you")) {
                System.out.println("Bot: I'm just a bot, but I'm doing great! Thanks for asking.");
            } else if (userInput.contains("your name")) {
                System.out.println("Bot: I'm Chatbot, your friendly virtual assistant.");
            } else if (userInput.contains("weather")) {
                System.out.println("Bot: Let's just look outside and see! Just kidding, I don't have access to real-time weather data. But I hope it's nice where you are!");
            } else {
                System.out.println("Bot: I'm sorry, I don't understand that. Can you please rephrase?");
            }
        }

        scanner.close();
    }
}
