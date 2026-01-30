import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    
        // 1. Создайте метод printThreeWords(), который при вызове должен
        //  отпечатать в столбец три слова: , Banana, Apple
        public static void printThreeWords(){
            System.out.println("Orange\nBanana\nApple");
        }

//        2. Создайте метод checkSumSign(), в теле которого объявите две
//        int переменные a и b, и инициализируйте их любыми значениями,
//        которыми захотите. Далее метод должен просуммировать эти переменные,
//        и если их сумма больше или равна 0, то вывести в консоль сообщение
//        “Сумма положительная”, в противном случае - “Сумма отрицательная”;

        public static void  checkSumSign(){
            int a = -52;
            int b = 90;
            int sum = a + b;

            if (0 <= sum) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }

        }
//        3. Создайте метод printColor() в теле которого задайте int
//        переменную value и инициализируйте ее любым значением. Если
//        value меньше 0 (0 включительно), то в консоль метод должен
//        вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно)
//        до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) -
//                “Зеленый”;

        public static void printColor() {
            int value = 42; // Объявляем и инициализируем внутри метода

            if (value <= 0) {
                System.out.println("Красный");
            } else if (value <= 100) {
                System.out.println("Жёлтый");
            } else {
                System.out.println("Зелёный");
            }
        }

//        4. Создайте метод compareNumbers(), в теле которого объявите две
//        int переменные a и b, и инициализируйте их любыми значениями,
//        которыми захотите. Если a больше или равно b, то необходимо
//        вывести в консоль сообщение “a >= b”, в противном случае “a < b”;


        public static void compareNumbers() {
            int a = 15;
            int b = 10;

            if (a >= b) {
                System.out.println("a >= b");
            } else {
                System.out.println("a < b");
            }
        }

//        5. Напишите метод, принимающий на вход два целых числа и проверяющий,
//        что их сумма лежит в пределах от 10 до 20 (включительно), если да –
//        вернуть true, в противном случае – false.

        public static boolean checkSumInRangeIfElse(int a, int b) {
            int sum = a + b;
            if (sum >= 10 && sum <= 20) {
                return true;
            } else {
                return false;
            }
        }

//        6. Напишите метод, которому в качестве параметра передается целое число,
//        метод должен напечатать в консоль, положительное ли число передали
//        или отрицательное. Замечание: ноль считаем положительным числом.

        public static void checkNumberSign(int number) {
            if (number >= 0) {
                System.out.println("Число " + number + " положительное");
            } else {
                System.out.println("Число " + number + " отрицательное");
            }
        }
//        7. Напишите метод, которому в качестве параметра передается целое число.
//        Метод должен вернуть true, если число отрицательное, и вернуть false
//        если положительное.
//        Замечание: ноль считаем положительным числом.
        public static boolean isNegativeIfElse(int number) {
            if (number < 0) {
                return true;
            } else {
                return false;
            }
        }
//8. Напишите метод, которому в качестве аргументов передается строка и число,
//        метод должен отпечатать в консоль указанную строку, указанное количество раз;
        public static void printStringMultipleTimesSafe(String text, int count) {
            if (text == null) {
                System.out.println("Ошибка: текст не может быть null");
                return;
            }

            if (count <= 0) {
                System.out.println("Количество повторений должно быть положительным числом");
                return;
            }

            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ": " + text);
            }
        }

//        9. Напишите метод, который определяет, является ли год високосным,
//        и возвращает boolean (високосный - true, не високосный - false).
//        Каждый 4-й год является високосным, кроме каждого 100-го, при этом
//            каждый 400-й – високосный.
            public static boolean isLeapYear(int year) {
                if (year <= 0) {
                    System.out.println("Ошибка: год должен быть положительным числом (получено: " + year + ")");
                    return false;
                }

                if (year % 400 == 0) {
                    return true; // кратен 400 - високосный
                } else if (year % 100 == 0) {
                    return false; // кратен 100, но не 400 - не високосный
                } else if (year % 4 == 0) {
                    return true; // кратен 4, но не 100 - високосный
                } else {
                    return false; // не кратен 4 - не високосный
                }
            }

//10. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла
//        и условия заменить 0 на 1, 1 на 0;
        public static void printAndConvertArray(int[] array) {

            if (array == null) {
                System.out.println("Массив не может быть null");
                return;
            }

            if (array.length == 0) {
                System.out.println("Массив пуст");
                return;
            }

            System.out.print("Исходный массив: [");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = 1;
                } else if (array[i] == 1) {
                    array[i] = 0;
                } else if (array[i] < 0) {
                    System.out.println("  Внимание: элемент [" + i + "] = " + array[i] +
                            " (отрицательное число) - оставлен без изменений");
                } else {
                    System.out.println("  Внимание: элемент [" + i + "] = " + array[i] +
                            " (не 0 и не 1) - оставлен без изменений");
                }
            }

            System.out.print("Результат:       [");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }


//11. Задать пустой целочисленный массив длиной 100. С помощью цикла
//        заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;

        public static void fillAndPrintArrayFormatted() {
            int[] array = new int[100];

            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }

            System.out.println("Массив из 100 элементов:");
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%3d ", array[i]);

                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
        }

//12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти
//        по нему циклом, и числа меньшие 6 умножить на 2;
        public static void multiplyWithForEach() {
            int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            int[] result = new int[array.length];
            int index = 0;

            System.out.println("\nИсходный массив:");
            printArray(array);

            for (int value : array) {
                if (value < 6) {
                    result[index] = value * 2;
                } else {
                    result[index] = value;
                }
                index++;
            }

            System.out.println("Результат:");
            printArray(result);
        }
        public static void printArray(int[] array) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

//13. Создать квадратный двумерный целочисленный массив
//                (количество строк и столбцов одинаковое),
//        и с помощью цикла(-ов) заполнить его диагональные
//        элементы единицами (можно только одну из диагоналей, если обе сложно).
//        Определить элементы одной из диагоналей можно по следующему принципу:
//        индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];


        public static void fillAndPrintCrossDiagonal() {
            int size = 8;
            int[][] matrix = new int[size][size];

            System.out.println("Заполнение обеих диагоналей (крест):");

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    if (i == j || i + j == size - 1) {
                        matrix[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
//14. Написать метод, принимающий на вход два аргумента: len и initialValue,
//        и возвращающий одномерный массив типа int длиной len, каждая ячейка
//        которого равна initialValue.
        public static int[] createAndPrintArray(int len, int initialValue) {
            if (len <= 0) {
                System.out.println("Ошибка: длина массива должна быть положительной (получено: " + len + ")");
                return new int[0];
            }

            int[] array = new int[len];

            for (int i = 0; i < array.length; i++) {
                array[i] = initialValue;
            }
            System.out.println(Arrays.toString(array));

            return array;
        }

    public static void main(String[] args) {
        System.out.println( "\nМетод 1 - " );
        printThreeWords();
        System.out.println( "\nМетод 2 - " );
        checkSumSign();
        System.out.println("\nМетод 3 - ");
        printColor();
        System.out.println("\n Метод 4 ");
        compareNumbers();
        System.out.println("\n Метод 5 ");
        System.out.println(checkSumInRangeIfElse(5, 5));  // true
        System.out.println(checkSumInRangeIfElse(2, 3));  // false

        System.out.println("\nМетод 6 -");
        checkNumberSign(100);
        checkNumberSign(-53);
        checkNumberSign(0);

        System.out.println("\nМетод 7 -");
        System.out.println("Число - (7) = " + isNegativeIfElse(7));
        System.out.println("Число - (-3) = " + isNegativeIfElse(-3));
        System.out.println("Число - (0) = " + isNegativeIfElse(0));
        System.out.println("\nМетод 8 -");
        printStringMultipleTimesSafe("Тестирование на Java", 3);
        System.out.println("---");
        printStringMultipleTimesSafe("Не напечатается", 0);
        printStringMultipleTimesSafe(null, 5);

        System.out.println("\nМетод 9-");
        System.out.println("2000 год високосный? " + isLeapYear(2000));
        System.out.println("1900 год високосный? " + isLeapYear(1900));
        System.out.println("2024 год високосный? " + isLeapYear(2024));
        System.out.println("2023 год високосный? " + isLeapYear(2023));

        System.out.println("\nМетод 10 -");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Массив 1 ");
        printAndConvertArray(array);
        int[] array2 = {-1, 0, 0, 2, 1, 0, 1, 1, 1, 1};
        System.out.println("Массив 2 ");
        printAndConvertArray(array2);

        System.out.println("\nМетод 11-");
        fillAndPrintArrayFormatted();
        System.out.println("\nМетод 12-");
        multiplyWithForEach();
        System.out.println("\nМетод 13-");
        fillAndPrintCrossDiagonal();

        System.out.println("\nМетод 14-");
        System.out.println("Массив:");
        int [] result1 =createAndPrintArray(5, 10);
        System.out.println(Arrays.toString(result1));

        System.out.println("\n Некорректная длина ");
        int [] result2 = createAndPrintArray(0, 100);
        System.out.println(Arrays.toString(result2));

    }
}
