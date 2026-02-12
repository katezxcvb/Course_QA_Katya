import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        return (double) sum / grades.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name)
                .append(", курс ")
                .append(course)
                .append(", оценки: ");

        for (int i = 0; i < grades.size(); i++) {
            sb.append(grades.get(i));
            if (i < grades.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    //  Удаление студентов со средним баллом < 3
    public static void removeLowGradeStudents(Set<Student> students) {
        Set<Student> toRemove = new HashSet<>();

        for (Student s : students) {
            if (s.getAverageGrade() < 3) {
                toRemove.add(s);
            }
        }

        students.removeAll(toRemove);

    }
    public static double getNumber(List<Integer> list){
        int a = 0;
        for (Integer elem:list){
            a+=elem;
        }
        return (double) a /list.size();
    }

    // Перевод студентов на следующий курс (если средний балл ≥ 3)
    public static void upgradeStudents(Set<Student> students) {
        List<Student> list = students.stream().filter((elem)->
                Student.getNumber(elem.grades)>=3).collect(Collectors.toList());
        System.out.println(Arrays.asList(list));

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    //  Печать студентов определённого курса
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты курса " + course + ":");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }

}




