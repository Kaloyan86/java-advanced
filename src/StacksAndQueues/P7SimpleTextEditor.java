package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P7SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArgs = rawCommand.split("\\s+");

            switch (commandArgs[0]) {
                case "1":
                    commands.push(rawCommand);
                    add(text, commandArgs[1]);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int count = Integer.parseInt(commandArgs[1]);
                    saveDeletedElements(text, count, removedElements);
                    delete(text, count);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArgs[1]);
                    System.out.printf("%s%n", text.charAt(index - 1));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    String[] lastCommandArgs = lastCommand.split("\\s+");
                    String lastCommandType = lastCommandArgs[0];
                    if (lastCommandType.equals("1")) {
                        int numberOfElementsToDelete = lastCommandArgs[1].length();
                        delete(text, numberOfElementsToDelete);
                    } else {
                        add(text, removedElements.pop());
                    }
                    break;
            }
        }
    }

    private static void saveDeletedElements(StringBuilder text, int count, ArrayDeque<String> removedElements) {

        String removedText = text.substring(text.length() - count, text.length());
        removedElements.push(removedText);

        //        StringBuilder sb = new StringBuilder();
        //        for (int i = text.length() - count; i < text.length(); i++) {
        //            sb.append(text.charAt(i));
        //        }
        //       removedElements.push(sb);

    }

    private static void delete(StringBuilder text, int count) {

        text.replace(text.length() - count, text.length(), "");

//        int textLength = text.length();
//        for (int i = 1; i <= count; i++) {
//            text.deleteCharAt(textLength - i);
//        }
    }

    private static void add(StringBuilder text, String commandArg) {
        text.append(commandArg);
    }
}
