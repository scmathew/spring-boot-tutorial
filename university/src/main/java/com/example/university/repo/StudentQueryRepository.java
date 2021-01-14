package com.example.university.repo;

import com.example.university.domain.Person;
import com.example.university.domain.Student;

import java.util.List;

/**
 * Declaring a StudentQueryRepository which can only query the Database
 */
public interface StudentQueryRepository extends ReadOnlyRepository<Student, Integer>{
    //Simple Query Methods
    List<Student> findByFullTime(boolean fullTime);
    List<Student> findByAge(Integer age);
    List<Student> findByAttendeeLastName(String last);

    //Query Methods with Clauses and Expressions
    Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);
    Student findByAttendee(Person person);

    List<Student> findByAgeGreaterThan(int minimumAge);
    List<Student> findByAgeLessThan(int maximumAge);

    List<Student> findByAttendeeLastNameIgnoreCase(String lastName);
    List<Student> findByAttendeeLastNameLike(String likeString);

    // Find highest student by alphabet
    // Pay attention: findFirst ByOrder ByAttendeeLastName Asc
    Student findFirstByOrderByAttendeeLastNameAsc();

    // Find oldest student
    Student findTopByOrderByAgeDesc();
    // Find 3 oldest students
    List<Student> findTop3ByOrderByAgeDesc();
}
