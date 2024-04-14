package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputValueSC = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = inputValueSC.nextLine();
        System.out.println("result:"+ calc(input));

    }

    public static String calc(String input) {

        int value1 = 0;
        int value2 = 0;
        Integer result = 0;
        boolean arabic = true;
        String parts[] = input.split(" ");
        if (parts.length > 3) {
            throw new ArrayIndexOutOfBoundsException("Введены неккоректные данные");
        }
        try {
            value1 = Integer.parseInt(parts[0]);
            value2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            arabic = false;
            value1 = Converter.convertToInt(parts[0]);
            value2 = Converter.convertToInt(parts[2]);
        }
        if ((value1 < 1 || value1 > 10) || (value2 < 1 || value2 > 10)) {
            throw new IllegalArgumentException("Введеные числа не подходят по условию");
        }
        String operator = parts[1];
        if (operator.equals("-")) {
            result = value1 - value2;
        }
        if (operator.equals("+")) {
            result = value1 + value2;
        }
        if (operator.equals("*")) {
            result = value1 * value2;
        }
        if (operator.equals("/")) {
            result = value1 / value2;
        }
        if (arabic == false) {
            if (result <= 0) {
                throw new IllegalArgumentException("Римское число не может быть отрицательным или равным нулю");
            }
            System.out.println(Converter.convertResultToRomes(result));
        }
        return result.toString();
    }

}