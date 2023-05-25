package com.dewiz.springdatajpatest.repository;

import com.dewiz.springdatajpatest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
