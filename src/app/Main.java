package app;

import domain.Book;
import domain.Catalog;

public class Main {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        // Створення книг повним конструктором
        Book book1 = new Book(
                "Місто",
                "Валер'ян Підмогильний",
                "9786170000001",
                1928
        );

        Book book2 = new Book(
                "Танці з кістками",
                "Андрій Сем'янків",
                "9786170000002",
                2022
        );

        // Створення книги скороченим конструктором
        Book book3 = new Book(
                "Воно",
                "Стівен Кінг"
        );

        // Некоректна книга
        Book invalidBook = new Book(
                "",
                "Невідомий автор",
                "123456789",
                2020
        );

        System.out.println("Додавання книг:");

        System.out.println("Місто: "
                + (catalog.addBook(book1) ? "додано" : "відхилено"));

        System.out.println("Танці з кістками: "
                + (catalog.addBook(book2) ? "додано" : "відхилено"));

        System.out.println("Воно: "
                + (catalog.addBook(book3) ? "додано" : "відхилено"));

        System.out.println("Некоректна книга: "
                + (catalog.addBook(invalidBook) ? "додано" : "відхилено"));

        System.out.println();

        catalog.printCatalog();

        System.out.println();
        System.out.println("=== ПЕРЕВІРКА ЗАХИСТУ СТАНУ ===");

        // Контрольована зміна дозволена
        book3.setYear(1986);

        System.out.println("Рік книги \"Воно\" змінено через метод setYear:");
        System.out.println(book3);

        System.out.println();
        System.out.println("Спроба змінити список книг ззовні:");

        try {
            catalog.getBooks().clear();
            System.out.println("Список змінено.");
        } catch (UnsupportedOperationException e) {
            System.out.println(
                    "Заборонено: внутрішній список каталогу не можна змінити ззовні."
            );
        }

        System.out.println();
        System.out.println("Після спроби зовнішньої зміни:");
        catalog.printCatalog();
    }
}