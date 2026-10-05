package domain;

public class Book {

    private static int nextId = 1;

    private final int id;
    private final String title;
    private final String author;
    private final String isbn;

    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public Book(String title, String author) {
        this(title, author, "Не вказано", 2026);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    // Змінювана частина даних
    public void setYear(int year) {
        if (year > 0 && year <= 2026) {
            this.year = year;
        }
    }

    // Службова перевірка, доступна тільки в пакеті domain
    boolean isValid() {
        return title != null
                && !title.isBlank()
                && author != null
                && !author.isBlank()
                && year > 0
                && year <= 2026;
    }

    @Override
    public String toString() {
        return "Книга #" + id
                + ": \"" + title + "\""
                + ", автор: " + author
                + ", ISBN: " + isbn
                + ", рік: " + year;
    }
}