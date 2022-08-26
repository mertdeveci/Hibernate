package org.example.config;

import org.example.entity.manytomany.Student;
import org.example.entity.onetomany.Course;
import org.example.entity.onetomany.Intructor;
import org.example.entity.onetoone.Person;
import org.example.entity.onetoone.Vehicle;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private final static Configuration configuration =
            new Configuration()
                    .configure("hibernate.cfg.xml")
//                    .setProperty("hibernate.connection.driver_class","org.postgresql.Driver")
//                    .setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5430/testdb")
//                    .setProperty("hibernate.connection.username","user")
//                    .setProperty("hibernate.connection.password","password")
//                    .setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect")
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Vehicle.class)
                    .addAnnotatedClass(Intructor.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Student.class);


    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
