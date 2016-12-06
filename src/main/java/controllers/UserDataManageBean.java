package controllers;

import dao.UserDAO;
import dao.UserDAOimpl;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.security.Principal;

@ManagedBean(name = "userData")
public class UserDataManageBean {

    private UserDAO userDAO = new UserDAOimpl();

    @ManagedProperty(value = "#{user}")
    private User currentUser;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        Principal userPrincipal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        String login = userPrincipal.getName();
        System.out.print(login);
        User user = userDAO.findByLogin(login);
        return user;
    }
}
