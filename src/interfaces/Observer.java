package interfaces;

import instances.Book;

public interface Observer {
    void update(Book book);
}