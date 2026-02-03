//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
public class Main {
    abstract static class Animal{
        private static int animalCount;
        protected String name;
        protected int maxRunDistance;
        protected int maxSwimDistance;

        public Animal(String name, int maxRunDistance, int maxSwimDistance) {
            this.name = name;
            this.maxRunDistance = maxRunDistance;
            this.maxSwimDistance = maxSwimDistance;
            animalCount++;
        }
        public void run(int distance) {
            if (distance <= maxRunDistance) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + maxRunDistance + " м.");
            }
        }

        public void swim(int distance) {
            if (maxSwimDistance == 0) {
                System.out.println(name + " не умеет плавать.");
            } else if (distance <= maxSwimDistance) {
                System.out.println(name + " проплыл " + distance + " м.");
            } else {
                System.out.println(name + " не может проплыть " + distance + " м. Максимум: " + maxSwimDistance + " м.");
            }
        }

        public static int getAnimalCount() {
            return animalCount;
        }

        public String getName() {
            return name;
        }
    }
    public static class Dog extends Animal{

        private static int dogCount = 0;

        public Dog(String name) {
            super(name, 500, 10); // собака бежит 500 м, плавает 10 м
            dogCount++;
        }

        public static int getDogCount() {
            return dogCount;
        }
    }
    public static class Cat extends Animal{

        private static int catCount = 0;
        private boolean isHungry = true;

        public Cat(String name) {
            super(name, 200, 0); // кот бежит 200 м, не плавает
            catCount++;
        }

        // Метод для кормления кота из миски
        public void eatFromBowl(Bowl bowl, int amount) {
            if (bowl.hasEnoughFood(amount)) {
                bowl.decreaseFood(amount);
                isHungry = false;
                System.out.println(name + " покушал " + amount + " единиц еды и теперь сыт.");
            } else {
                System.out.println(name + " не может покушать. В миске недостаточно еды.");
            }
        }

        // Метод, чтобы накормить кота стандартной порцией
        public void eatFromBowl(Bowl bowl) {
            int standardAmount = 10; // стандартная порция
            eatFromBowl(bowl, standardAmount);
        }

        public boolean isHungry() {
            return isHungry;
        }

        public static int getCatCount() {
            return catCount;
        }
    }

    public static class Bowl {
        private int foodAmount;

        public Bowl(int initialFood) {
            this.foodAmount = Math.max(initialFood, 0); // гарантируем, что еда не отрицательная
        }

        public boolean hasEnoughFood(int amount) {
            return amount <= foodAmount;
        }

        public void decreaseFood(int amount) {
            if (amount <= foodAmount) {
                foodAmount -= amount;
            } else {
                System.out.println("Недостаточно еды в миске!");
            }
        }

        public void addFood(int amount) {
            if (amount > 0) {
                foodAmount += amount;
                System.out.println("В миску добавлено " + amount + " единиц еды. Теперь в миске: " + foodAmount);
            } else {
                System.out.println("Нельзя добавить отрицательное количество еды!");
            }
        }

        public int getFoodAmount() {
            return foodAmount;
        }

        public void printInfo() {
            System.out.println("В миске " + foodAmount + " единиц еды.");
        }
    }


    public static void main(String[] args) {
        System.out.println("=== Часть 1: Животные бегают и плавают ===\n");

        // Создаем животных
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        // Тестируем бег
        dog1.run(300);
        dog1.run(600);
        cat1.run(150);
        cat1.run(250);

        System.out.println();

        // Тестируем плавание
        dog1.swim(5);
        dog1.swim(15);
        cat1.swim(5);

        System.out.println("\n=== Часть 2: Статистика животных ===\n");

        // Выводим статистику
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

        System.out.println("\n=== Часть 3: Кормление котов ===\n");

        // Создаем миску с едой
        Bowl bowl = new Bowl(50);
        bowl.printInfo();

        // Создаем массив котов
        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(new Cat("Рыжик"));
        cats.add(new Cat("Черныш"));

        System.out.println("\n--- Кормим котов ---");
        // Кормим всех котов из миски
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
        }

        System.out.println("\n--- Состояние сытости котов ---");
        // Выводим информацию о сытости
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isHungry() ? "голоден" : "сыт"));
        }

        bowl.printInfo();

        System.out.println("\n--- Добавляем еду в миску ---");
        // Добавляем еду в миску
        bowl.addFood(30);

        System.out.println("\n--- Кормим голодных котов снова ---");
        // Кормим только голодных котов
        int fedCats = 0;
        for (Cat cat : cats) {
            if (cat.isHungry()) {
                cat.eatFromBowl(bowl);
                fedCats++;
            }
        }

        if (fedCats == 0) {
            System.out.println("Все коты уже сыты!");
        }

        System.out.println("\n--- Финальное состояние сытости котов ---");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isHungry() ? "голоден" : "сыт"));
        }

        bowl.printInfo();

        System.out.println("\n=== Финальная статистика ===\n");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }

}