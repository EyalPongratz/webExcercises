package com.example.webHomeExcercise3.repositories;

import com.example.webHomeExcercise3.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findByPriceLessThanEqual(float maxPrice);
    public List<Course> findByDurationBetween(int min, int max);
}
