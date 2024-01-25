/* TASK 3

CALCULATOR APP

● Prompt the user for two numbers and an operator using Scanner.
● Perform the corresponding arithmetic operation based on the operator (+, -, *, /).
● Display the result.
● Use try and catch to handle division by zero or other exceptions. */

import java.util.Scanner;

class CalculatorApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter num2: ");
        int num2 = sc.nextInt();
        System.out.println("Enter operator: ");
        String operator = sc.next();
        switch (operator) {
            case "+":
                System.out.println(num1 + num2);
                break;
            
            case "-":
                System.out.println(num1 - num2);
                break;
            
            case "*":
                System.out.println(num1 * num2);
                break;
            
            case "/":
               try {
                    System.out.println(num1 / num2);
                    break;
                } catch (Exception e) {
                    
                    System.out.println("undefined");
                }
        }
        sc.close();
    }
}