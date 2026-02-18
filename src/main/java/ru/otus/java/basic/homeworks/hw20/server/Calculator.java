package ru.otus.java.basic.homeworks.hw20.server;

import java.text.DecimalFormat;

public class Calculator {
    public String getResult(String inputStr) {
        String[] parts = inputStr.split("\\s+");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Некорректный формат ввода.");
        }

        double operand1;
        double operand2;
        try {
            operand1 = Double.parseDouble(parts[0]);
            operand2 = Double.parseDouble(parts[2]);

        } catch (NumberFormatException e) {
            throw new RuntimeException("Один из операндов не является числом.");
        }

        double result;
        DecimalFormat df = new DecimalFormat("#.###");

        result = switch (parts[1]) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new RuntimeException("Неподдерживаемый оператор.");
        };

        return df.format(result);
    }
}
