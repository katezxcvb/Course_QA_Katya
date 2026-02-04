// Интерфейс фигуры
interface Shape {
    String getFillColor();
    String getBorderColor();

    // Методы, которые фигуры должны реализовать
    double getPerimeter();
    double getArea();

    // Дефолтный метод вывода информации
    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("---------------------------");
    }
}

// Круг
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}

// Прямоугольник
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getArea() {
        return width * height;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}

// Треугольник
class Triangle implements Shape {
    private double a, b, c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double p = getPerimeter() / 2; // полупериметр
        return Math.sqrt(p * (p - a) * (p - b) * (p - c)); // формула Герона
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}


public class GeometryApp {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Белый");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Зеленый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}