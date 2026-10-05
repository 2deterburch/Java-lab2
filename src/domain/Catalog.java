package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalog {

    private final List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        if (book == null || !book.isValid()) {
            return false;
        }

        books.add(book);
        return true;
    }

    public boolean removeBookById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }

    // Повертаємо незмінне представлення списку
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    // Підсумкова характеристика для варіанта 4
    public int getBookCount() {
        return books.size();
    }

    public void printCatalog() {
        System.out.println("=== КАТАЛОГ ===");

        if (books.isEmpty()) {
            System.out.println("Каталог порожній.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        System.out.println("Кількість позицій: " + getBookCount());
    }
}