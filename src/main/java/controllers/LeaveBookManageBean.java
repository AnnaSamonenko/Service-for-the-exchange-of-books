package controllers;

import dao.BookDAO;
import dao.BookDAOimpl;
import dao.UserDAO;
import dao.UserDAOimpl;
import entities.Book;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.security.Principal;

@ManagedBean(name = "leaveBookBean")
public class LeaveBookManageBean {

    @ManagedProperty(value = "#{book}")
    private Book book;

    @ManagedProperty(value = "#{user}")
    private User user;

    private BookDAO bookDAO = new BookDAOimpl();

    private UserDAO userDAO = new UserDAOimpl();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrentUserId() {
        Principal userPrincipal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        String login = userPrincipal.getName();
        User user = userDAO.findByLogin(login);
        return user.getId();
    }

    public void create(Book book){
        bookDAO.create(getCurrentUserId(), book);
    }
}
