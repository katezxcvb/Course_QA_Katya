import java.util.*;
public class PhoneBook {

    private Map<String, List<String>> phoneBook = new HashMap<>();

    // Добавление телефона по фамилии
    public void add(String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>())
                .add(phoneNumber);
    }

    // Получение всех телефонов по фамилии
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    // Для удобства — печать всех записей
    public void printAll() {
        for (var entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
