package org.example.dao;

import org.example.config.HibernateUtils;
import org.example.entity.onetomany.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseRepository {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();


    public void insert(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try {
            session.save(course);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public Course findById(int courseId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try{
            Course course = session.get(Course.class, courseId);
            session.getTransaction().commit();
            return course;

        }catch (HibernateException hibernateException){
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    public List findAll(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        try{
            List courses = session.createQuery("from Course").getResultList();
            session.getTransaction().commit();
            return courses;

        }catch (HibernateException hibernateException){
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }


}
