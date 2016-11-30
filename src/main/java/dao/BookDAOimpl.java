package dao;

import entities.Book;
import entities.User;

import javax.persistence.*;
import java.util.List;

public class BookDAOimpl implements BookDAO{

    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("book_exchange");
    private EntityManager entityManager = emfactory.createEntityManager();

    public void create(int idOwner, Book book) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, idOwner);
        book.setUser(user);
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public Book read(int id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    // update title, language
    public void update(int id, Book newDataBook) {
        Book book = entityManager.find(Book.class, id);
        book.setLanguage(newDataBook.getLanguage());
        book.setTitle(newDataBook.getTitle());
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
    }

    public List<Book> getAllBooks(){
        Query query = entityManager.createQuery("select b from Book b");
        return query.getResultList();
    }

    public void updateOwner(int idBook, int idOwner) {
        User user = entityManager.find(User.class, idOwner);
        Book book = entityManager.find(Book.class, idBook);
        entityManager.getTransaction().begin();
        book.setUser(user);
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }
}