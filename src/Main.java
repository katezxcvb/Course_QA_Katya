import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    Создать класс "Товар" с полями: название, дата производства,
//    производитель, страна происхождения, цена,
//    состояние бронирования покупателем.
    public static class Product{
        private String name;
        private LocalDate productionDate;
        private String manufactor;
        private String country;
        private double price;
        private boolean Isreserved;

//    Конструктор класса должен заполнять эти поля при создании объекта.
    public Product(String name,LocalDate productionDate, String manufactor,
                   String country,double price, boolean Isreserved ){
        this.name = name;
        this.productionDate = productionDate;
        this.manufactor = manufactor;
        this.country = country;
        this.price = price;
        this.Isreserved = Isreserved;
    }

//    Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
    public void Info(){
        System.out.println("---------- Информация о товаре ----------");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufactor);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: %.2f руб.\n: " + price);
        System.out.println("Состояние бронирования: " + ( Isreserved ? "Забронирован" : "Свободен"));

    }
  }

    public static class Park {
        private String parkName;
        private String location;
        private ArrayList<Attraction> attractions;

        // Конструктор класса Park
        public Park(String parkName, String location) {
            this.parkName = parkName;
            this.location = location;
            this.attractions = new ArrayList<>();
        }
        // Метод для вывода основной информации о парке
        public void displayParkInfo() {
            System.out.println("=== ИНФОРМАЦИЯ О ПАРКЕ ===");
            System.out.println("Название парка: " + parkName);
            System.out.println("Местоположение: " + location);
            System.out.println("Количество аттракционов: " + attractions.size());
            System.out.println("=========================");
        }

        public class Attraction {
            private String attractionName;
            private LocalTime openingTime;
            private LocalTime closingTime;
            private double price;
            private int minAge;
            private int maxCapacity;

            // Конструктор внутреннего класса
            public Attraction(String attractionName, LocalTime openingTime, LocalTime closingTime,
                              double price, int minAge, int maxCapacity) {
                this.attractionName = attractionName;
                this.openingTime = openingTime;
                this.closingTime = closingTime;
                this.price = price;
                this.minAge = minAge;
                this.maxCapacity = maxCapacity;
            }


            public void displayInfo() {
                System.out.println("Аттракцион: " + attractionName);
                System.out.println("Время работы: " + openingTime + " - " + closingTime);
                System.out.printf("Стоимость: %.2f руб.\n", price);
                System.out.println("Минимальный возраст: " + minAge + " лет");
                System.out.println("Максимальная вместимость: " + maxCapacity + " человек");
                System.out.println("Парк: " + parkName);
                System.out.println("---------------------------");
            }
        }
    }
    public static void main(String[] args) {

        Product product1 = new Product(
                "Смартфон Apple",
                LocalDate.of(2024, 1, 15),
                "XYZ Tech",
                "Китай",
                29999.99,
                true
        );
        Product product2 = new Product(
                "Ноутбук XYZ",
                LocalDate.of(2024, 1, 15),
                "ABC Computers",
                "Китай",
                29999.99,
                false
        );


        System.out.println("Товар 1:");
        product1.Info();

        System.out.println("\nТовар 2:");
        product2.Info();

        System.out.println("Массив товаров ------- ");
        Product[] productsArray = new Product[5];

        // 2. Заполняем массив объектами товаров
        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                LocalDate.of(2025, 2, 1),
                "Samsung Corp.",
                "Korea",
                5599.99,
                true
        );

        productsArray[1] = new Product(
                "iPhone 16 Pro",
                LocalDate.of(2024, 9, 15),
                "Apple Inc.",
                "China",
                1299.99,
                false
        );

        productsArray[2] = new Product(
                "Sony WH-1000XM5",
                LocalDate.of(2023, 11, 10),
                "Sony Corporation",
                "Japan",
                349.99,
                true
        );

        productsArray[3] = new Product(
                "Lenovo ThinkPad X1 Carbon",
                LocalDate.of(2024, 3, 20),
                "Lenovo",
                "China",
                1899.99,
                false
        );

        productsArray[4] = new Product(
                "Dyson V15 Detect",
                LocalDate.of(2024, 1, 5),
                "Dyson Ltd.",
                "Malaysia",
                799.99,
                true
        );

        System.out.println("=== ИНФОРМАЦИЯ О ВСЕХ ТОВАРАХ ===");
        System.out.println("Всего товаров: " + productsArray.length + "\n");

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар #" + (i + 1) + ":");
            productsArray[i].Info();
            System.out.println();
        }

        System.out.println("\nПарк и Аттракционы\n");
        Park park = new Park("Центральный парк", "Москва");

        // Создаем несколько аттракционов
        Park.Attraction attraction1 = park.new Attraction(
                "Американские горки",
                LocalTime.of(10, 0),
                LocalTime.of(22, 0),
                500.0,
                12,
                24
        );

        Park.Attraction attraction2 = park.new Attraction(
                "Колесо обозрения",
                LocalTime.of(9, 0),
                LocalTime.of(23, 0),
                300.0,
                3,
                40
        );

        Park.Attraction attraction3 = park.new Attraction(
                "Детские карусели",
                LocalTime.of(11, 0),
                LocalTime.of(20, 0),
                200.0,
                0,
                30
        );
        park.displayParkInfo();
        attraction1.displayInfo();
        attraction2.displayInfo();
        attraction3.displayInfo();
    }
}