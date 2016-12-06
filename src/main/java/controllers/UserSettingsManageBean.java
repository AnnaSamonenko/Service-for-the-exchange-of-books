package controllers;

import dao.UserDAO;
import dao.UserDAOimpl;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.security.Principal;

@ManagedBean(name = "userSettingsBean")
public class UserSettingsManageBean {

    @ManagedProperty(value = "#{user}")
    private User user;

    private UserDAO userDAO = new UserDAOimpl();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrentUserId() {
        Principal userPrincipal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        String login = userPrincipal.getName();
        System.out.print(login);
        User user = userDAO.findByLogin(login);
        return user.getId();
    }

    public void update(User user) {
        userDAO.update(getCurrentUserId(), user);
    }

    public void delete() throws IOException {
        userDAO.delete(getCurrentUserId());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/Coursework/login.xhtml");
    }

}
