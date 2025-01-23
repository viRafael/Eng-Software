import java.util.ArrayList;
import java.util.List;

import instances.Book;
import instances.User;

public class LibraryData {
    private static LibraryData instance;

    private List<User> users;
    private List<Book> books;

    private LibraryData() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        // Carrega dados de teste aqui
    }

    public static LibraryData getInstance() {
        if (instance == null) {
            instance = new LibraryData();
        }
        return instance;
    }

    public List<User> getUsers() { return users; }
    public List<Book> getBooks() { return books; }

    // Métodos utilitários, exemplo:
    // public User findUserById(int userId) { ... }
    // public Book findBookById(int bookId) { ... }

    // etc...
}
