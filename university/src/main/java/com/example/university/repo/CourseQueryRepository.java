package com.example.university.repo;

import com.example.university.domain.Course;
import com.example.university.view.CourseView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Declaring a CourseQueryRepository which can only query the Database
 */
public interface CourseQueryRepository extends ReadOnlyRepository<Course, Integer> {
    Optional<Course> findByName(String name);

    List<Course> findByDepartmentChairMemberLastName(String chair);

    // JPQL
    // Named query params
    @Query("SELECT c FROM Course c WHERE c.department.chair.member.lastName=:chair")
    List<Course> findByChairLastName(@Param("chair")String chairLastName);

    // Alternative option to named params, numbered params
    @Query("Select c from Course c join c.prerequisites p where p.id = ?1")
    List<Course> findCourseByPrerequisite(int id);

    // Return Custom POJO with limited info
    // Creating new object in query via constructor??
    @Query("Select new com.example.university.view.CourseView" +
            "(c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1")
    CourseView getCourseView(int courseId) ;

    List<Course> findByCredits(@Param("credits") int credits);

    // Implements paging
    Page<Course> findByCredits(@Param("credits") int credits, Pageable pageable);

    Course findByDepartmentName(String deptName);

    @Query("Select new com.example.university.view.CourseView" +
            "(c.name, c.instructor.member.lastName, c.department.name) from Course c where c.name=?1")
    Optional<CourseView> getCourseViewByName(String name);
}