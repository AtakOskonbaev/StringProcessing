package org.example;

public class Main {
    public static void main(String[] args) {
        StringProcessor stringProcessor = new StringProcessor();
        System.out.println("\n");
        //calculateExpression
        System.out.println(stringProcessor.calculateExpression("(1 + 2) * (3 + 4)")); // 21
        System.out.println(stringProcessor.calculateExpression("10 + 2 * 6"));         // 22
        System.out.println(stringProcessor.calculateExpression("100 * 2 + 12"));       // 212
        System.out.println(stringProcessor.calculateExpression("100 * (2 + 12)"));     // 1400
        System.out.println(stringProcessor.calculateExpression("100 * (2 + 12) / 14")); // 100

    }
}
