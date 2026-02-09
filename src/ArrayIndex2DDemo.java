public class ArrayIndex2DDemo {

    // --- Исключение размера массива ---
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    // --- Исключение неверных данных ---
    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(int row, int col, String value) {
            super("Ошибка в ячейке [" + row + "][" + col + "]: '" +
                    value + "' нельзя преобразовать в число");
        }
    }

    // --- Проверка размера массива ---
    public static void checkArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }
        }
    }

    // --- Суммирование массива с проверками ---
    public static int sumArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        checkArraySize(array);

        int sum = 0;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                try {
                    sum += Integer.parseInt(array[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, col, array[row][col]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Проверка корректного массива");
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            checkArraySize(arr);
            System.out.println("Размер массива корректный");
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\nПроверка массива неправильного размера");
        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };

        try {
            checkArraySize(arr1);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\nПроверка массива с неверными данными");
        String[][] arr2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "X", "16"} // ошибка здесь
        };

        try {
            int result = sumArray(arr2);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\n Проверка корректного массива (суммирование)");
        String[][] arr4 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(arr4);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива: " + e.getMessage());
        }


        // ---------------------------------------------
        // ✔ Демонстрация ArrayIndexOutOfBoundsException
        // ---------------------------------------------
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        try {
            System.out.println("Пробуем обратиться к элементу [5][5]...");
            int value = matrix[5][5]; // намеренно неверный индекс
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
            System.out.println("Сообщение: " + e.getMessage());
        }

        System.out.println("Программа продолжает работу после исключения");
    }
}
