package org.example.dao;

import org.example.config.HibernateUtils;
import org.example.entity.manytomany.Student;
import org.example.entity.onetomany.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentRepository {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private final CourseRepository courseRepository = new CourseRepository();


    public Student findById(int studentId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try{
            Student student = session.get(Student.class, studentId);
            session.getTransaction().commit();
            return student;

        }catch (HibernateException hibernateException){
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    public void insert(Student student) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try {
            session.save(student);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}
