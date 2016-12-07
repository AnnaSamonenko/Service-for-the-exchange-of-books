package controllers;

import dao.BookDAO;
import dao.BookDAOimpl;
import entities.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "bookBean")
public class BookManageBean {

    @ManagedProperty(value = "#{book}")
    private Book book;

    @ManagedProperty(value = "#{currentUser}")
    private CurrentUserManageBean currentUser = new CurrentUserManageBean();

    private BookDAO bookDAO = new BookDAOimpl();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CurrentUserManageBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUserManageBean currentUser) {
        this.currentUser = currentUser;
    }

    public void create(Book book) {
        bookDAO.create(currentUser.getCurrentUser().getId(), book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void delete(int idBook) {
        bookDAO.delete(idBook);
    }
}
