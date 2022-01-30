package ru.gb.interview.hw5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    public static SessionFactory getFactory(){
        return sessionFactory;
    }
}
