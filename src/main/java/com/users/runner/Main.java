package com.users.runner;

import com.users.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            // Load Hibernate configuration
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();

            // Create and save a new user
            User newUser = new User("John Doe","Abc", "Def", "Ghi");
            save(newUser);

            // Find user by ID
            User user = findById(newUser.getId());
            System.out.println("User with ID " + newUser.getId() + ": " + user.getName());

            // Update user
            user.setName("Jane Smith");
            update(user);

            // List all users
            listUsers();
        } finally {
            if (sessionFactory != null) {
              //  sessionFactory.close();
            }
        }
    }

    public static void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public static User findById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public static void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public static void listUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("FROM User", User.class).getResultList();
        session.close();

        for (User user : users) {
            System.out.println("User: " + user.getName());
        }
    }
}
