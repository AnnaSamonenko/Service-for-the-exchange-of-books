package controllers;

import dao.UserDAO;
import dao.UserDAOimpl;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean(name = "userBean")
public class UserManageBean {

    @ManagedProperty(value = "#{currentUser}")
    private CurrentUserManageBean currentUser;

    private UserDAO userDAO = new UserDAOimpl();

    public CurrentUserManageBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUserManageBean currentUser) {
        this.currentUser = currentUser;
    }

    public void update(User user) {
        userDAO.update(currentUser.getCurrentUser().getId(), user);
    }

    public void delete() throws IOException {
        userDAO.delete(currentUser.getCurrentUser().getId());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/Coursework/login.xhtml");
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
