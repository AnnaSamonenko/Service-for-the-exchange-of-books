package controllers;

import dao.UserDAO;
import dao.UserDAOimpl;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "userRegistrationBean")
public class RegistrationManageBean {

    @ManagedProperty(value = "#{user}")
    private User user;

    private UserDAO userDAO = new UserDAOimpl();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void create(User user) {
        userDAO.create(user);
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/Coursework/book-list.xhtml");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public List<String> findAllRoles(){
        List<String> roles = new  LinkedList<>();
        roles.add("User");
        roles.add("Admin");
        return roles;
    }
}
