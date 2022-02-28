package ru.learnup.feb;

public class Main {

    public static void main(String[] args) {
        try {
            int first = Integer.parseInt(args[0]);
            String op = args[1];
            int second = Integer.parseInt(args[2]);
            switch (op) {
                case "+" -> System.out.printf("%d + %d = %d\n", first, second, first + second);
                case "-" -> System.out.printf("%d - %d = %d\n", first, second, first - second);
                default -> System.out.println("Unknown operation");
            }
        } catch (Exception e) {
            System.out.println("Wrong input.... Good buy");
        }
    }
}
