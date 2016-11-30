package dao;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDAOimpl implements UserDAO{

    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("book_exchange");
    private EntityManager entityManager = emfactory.createEntityManager();

    public void create(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public User read(int id){
        User user = entityManager.find(User.class, id);
        return user;
    }

    public void update(int id, User newDataUser){
        User user = entityManager.find(User.class, id);
        user.setName(newDataUser.getName());
        user.setSurname(newDataUser.getSurname());
        user.setCountry(newDataUser.getCountry());
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void delete(int id){
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public List<User> getAllUsers(){
        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    public User findByLogin(String login){
        Query query = entityManager.createQuery("select u from User u Where login = '" + login +"'");
        return (User)query.getResultList().get(0);
    }
}
