package org.example;

import org.example.config.HibernateUtils;
import org.example.crud.TestConnection;
import org.example.dao.*;
import org.example.entity.manytomany.Student;
import org.example.entity.onetoone.Person;
import org.example.entity.onetoone.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {


//        PersonRepository personRepository = new PersonRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
//        CourseRepository courseRepository = new CourseRepository();
//        IntructorRepository intructorRepository = new IntructorRepository();
//        StudentRepository studentRepository = new StudentRepository();
//
//        TestConnection testConnection = new TestConnection();
//        testConnection.test();


        Vehicle vehicle = vehicleRepository.findById(31);

        System.out.println(vehicle);

    }
}