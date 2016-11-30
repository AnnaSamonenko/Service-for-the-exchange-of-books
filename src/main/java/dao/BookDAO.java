package dao;

import entities.Book;

import java.util.List;

public interface BookDAO {
    void create(int idOwner, Book book);

    void update(int id, Book book);

    void delete(int id);

    Book read(int id);

    void updateOwner(int idBook, int idOwner);

    List<Book> getAllBooks();
}
