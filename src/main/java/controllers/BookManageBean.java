package controllers;

import dao.BookDAO;
import dao.BookDAOimpl;
import entities.Book;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "bookBean")
public class BookManageBean {
    private BookDAO bookDAO = new BookDAOimpl();

    public List<Book> books() {
        return bookDAO.getAllBooks();
    }
}
