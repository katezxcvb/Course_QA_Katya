import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.security.MessageDigest;
public class Main {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван", "A1", 1, Arrays.asList(4, 5, 3, 4)));
        students.add(new Student("Мария", "A1", 1, Arrays.asList(2, 2, 3, 2)));
        students.add(new Student("Павел", "B2", 2, Arrays.asList(5, 5, 4, 5)));
        students.add(new Student("Анна", "C3", 3, Arrays.asList(1, 2, 2, 1)));

        System.out.println("\n1-Список студентов");
        for (Student s : students) {
            System.out.println(s);
        }


        System.out.println("\n2-После удаления студентов со ср.баллом < 3");
        Student.removeLowGradeStudents(students);
        for(Student s : students){
            System.out.println(s);
        }

        System.out.println("\n3-Перевод на следующий курс");
        Student.promoteStudents(students);
        for(Student s : students){
            System.out.println(s);
        }

        System.out.println("\n4-Студенты определенного курса");
        Student.printStudents(students, 2);

        System.out.println("\nКЛАСС ТЕЛЕФОННЫЙ СПРАВОЧНИК");
        PhoneBook pb = new PhoneBook();
        pb.add("Иванов", "123-45-67");
        pb.add("Петров", "555-55-55");
        pb.add("Иванов", "987-65-43");   // вторая запись для Иванова
        pb.add("Сидоров", "111-22-33");

        System.out.println("Телефоны Иванова: " + pb.get("Иванов"));
        System.out.println("Телефоны Петрова: " + pb.get("Петров"));
        System.out.println("Телефоны Сидорова: " + pb.get("Сидорова"));

        System.out.println("Телефоны Смирнова: " + pb.get("Смирнов"));

        System.out.println("\nВсе записи в справочнике:");
        pb.printAll();


    }
}
