package main.java.com.library.observer;

import main.java.com.library.domain.Book;

public interface Observer {
    void update(Book book);
}