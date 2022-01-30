package ru.gb.interview.hw5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDao {
    public Student findById(Long id) {
        Session session = null;
        try {
            SessionFactory factory = SessionFactoryProvider.getFactory();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Student> findAll() {
        Session session = null;
        try {
            SessionFactory factory = SessionFactoryProvider.getFactory();
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> students = session.createCriteria(Student.class).list();
            session.getTransaction().commit();
            return students;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Student save(Student student) {
        Session session = null;
        try {
            SessionFactory factory = SessionFactoryProvider.getFactory();
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate("Student", student);
            session.getTransaction().commit();
            return student;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Student student) {
        Session session = null;
        try {
            SessionFactory factory = SessionFactoryProvider.getFactory();
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete("Student", student);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
