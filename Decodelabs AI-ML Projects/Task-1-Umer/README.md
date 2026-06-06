# Java Rule-Based Chatbot

A simple console-based chatbot written in Java. The chatbot responds to predefined user inputs using `if`, `else if`, and `else` statements.

## Project Requirements

This project demonstrates:

- Greeting handling
- Exit commands
- Conditional `if-else` logic
- A continuous conversation loop
- Basic user input processing
- Simple rule-based artificial intelligence

## Features

The chatbot can:

- Respond to greetings such as `hello`, `hi`, and `hey`
- Answer questions about its name
- Respond when asked how it is
- Respond to questions about the weather
- Display available commands when the user types `help`
- End the conversation when the user types `exit`, `quit`, or `bye`
- Display a default response when it does not understand the input

## Technologies Used

- Java
- `Scanner` for reading user input
- `while` loop for continuous conversation
- `if-else` statements for decision-making
- String methods such as `.trim()`, `.toLowerCase()`, `.equals()`, and `.contains()`

## How to Run the Program

### 1. Make sure Java is installed

Check your Java installation by running:

```bash
java --version
```

### 2. Compile the program

Open a terminal in the folder containing `Chatbot.java` and run:

```bash
javac Chatbot.java
```

### 3. Run the program

```bash
java Chatbot
```

## Example Conversation

```text
Bot: Hello! I'm a simple chatbot!
Bot: You can ask me what's my name, how I am, or just say hello!
Bot: Type 'help' if you get stuck.
Bot: Type 'exit', 'quit', or 'bye' to end the conversation.

You: hello
Bot: Hello! How can I assist you today?

You: what is your name?
Bot: I'm Chatbot, your friendly virtual assistant.

You: how are you?
Bot: I'm just a bot, but I'm doing great! Thanks for asking.

You: bye
Bot: Goodbye! Have a great day!
```

## How It Works

The program uses a `while (true)` loop to keep the chatbot running. Each time the user enters a message, the input is converted to lowercase and extra spaces are removed:

```java
String userInput = scanner.nextLine().trim().toLowerCase();
```

The chatbot then checks the input against predefined rules using `if-else` statements.

For example:

```java
if (userInput.equals("exit") ||
    userInput.equals("quit") ||
    userInput.equals("bye")) {

    System.out.println("Bot: Goodbye! Have a great day!");
    break;
}
```

The `break` statement stops the loop and ends the program.

## Limitations

This is a rule-based chatbot, so it does not learn from conversations or understand natural language like an advanced AI system. It can only respond to inputs that match its predefined rules.

## Possible Future Improvements

- Add more questions and responses
- Use methods to organise the code
- Store responses in collections such as a `HashMap`
- Add random responses
- Create a graphical user interface
- Connect the chatbot to an external API

## Author

Created as part of the Decode Labs internship project.
