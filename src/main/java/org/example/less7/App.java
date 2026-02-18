package org.example.less7;
public class App
{
    public static int getFactorial(int f){
        int result = 1;
        for(int i =1; i <= f; i++){
            result = result * i;
        }
        return result;
    }
    public static double calculateTriangle(double a, double b, double c){
        double s = (a+b+c)/2;//полупериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static int calculate(int a, int b, char operation){
        switch (operation){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/':
                if(b==0){
                    throw new IllegalArgumentException("Нельзя делить на 0");
                }
                return a/b;
            default: throw new IllegalArgumentException("Неизвестная операция" + operation);
        }
    }

    public static String compareInts(int a, int b){
        if (a > b) return "a больше b";
        if (a < b) return "a меньше b";
        return "a равно b";

    }
    public static void main( final String[] args )
    {
        System.out.println( "args: " + java.util.Arrays.toString( args ) );
    }
}
