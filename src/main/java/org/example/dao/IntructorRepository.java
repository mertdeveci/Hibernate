package org.example.dao;

import org.example.config.HibernateUtils;
import org.example.entity.onetomany.Course;
import org.example.entity.onetomany.Intructor;
import org.example.entity.onetoone.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class IntructorRepository {

    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private final CourseRepository courseRepository = new CourseRepository();


    public void insert(Intructor intructor) {

        List<Course> courseList = new ArrayList<>();
        Course course = null;

        course = courseRepository.findById(25);
        courseList.add(course);

        course = courseRepository.findById(26);
        courseList.add(course);

        course = courseRepository.findById(27);
        courseList.add(course);

        intructor.setCourses(courseList);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.save(intructor);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getStackTrace());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public Intructor findById(int vehicleId){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session.get(Intructor.class, vehicleId);
    }



}
