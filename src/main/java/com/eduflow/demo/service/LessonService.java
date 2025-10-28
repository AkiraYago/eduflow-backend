package com.eduflow.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.eduflow.demo.repository.LessonRepository;
import com.eduflow.demo.entity.Lesson;

@Service
public class LessonService {
    @Autowired
    private LessonRepository courseSectionRepository;

    public List<Lesson> getAllCourseSections() {
        return courseSectionRepository.findAll();
    }

    public Optional<Lesson> getCourseSectionById(Long id) {
        return courseSectionRepository.findById(id);
    }

    public List<Lesson> getCourseSectionsByCourseId(Long courseId) {
        return courseSectionRepository.findByCourseId(courseId);
    }

    public Lesson createCourseSection(Lesson courseSection) {
        return courseSectionRepository.save(courseSection);
    }

    public Lesson updateCourseSection(Long id, Lesson courseSectionDetails) {
        Lesson courseSection = courseSectionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course Section not found with id: " + id));

        courseSection.setTitle(courseSectionDetails.getTitle());
        courseSection.setDescription(courseSectionDetails.getDescription());
        courseSection.setCourse(courseSectionDetails.getCourse());

        return courseSectionRepository.save(courseSection);
    }

    public void deleteCourseSection(Long id) {
        Lesson courseSection = courseSectionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course Section not found with id: " + id));
        courseSectionRepository.delete(courseSection);
    }
}