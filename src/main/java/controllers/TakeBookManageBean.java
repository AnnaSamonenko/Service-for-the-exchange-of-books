package controllers;


import dao.BookDAO;
import dao.BookDAOimpl;
import dao.UserDAO;
import dao.UserDAOimpl;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.security.Principal;

@ManagedBean(name="takeBookBean")
public class TakeBookManageBean {

    private BookDAO bookDAO = new BookDAOimpl();

    private UserDAO userDAO = new UserDAOimpl();

    public int getCurrentUserId() {
        Principal userPrincipal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        String login = userPrincipal.getName();
        User user = userDAO.findByLogin(login);
        return user.getId();
    }

    public void update(int idBook){
        bookDAO.updateOwner(idBook, getCurrentUserId());
    }

}
