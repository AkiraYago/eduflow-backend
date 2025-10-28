package com.eduflow.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.eduflow.demo.service.LessonService;
import com.eduflow.demo.entity.Lesson;

@RestController
@RequestMapping("/api/course-sections")
public class LessonController {
    @Autowired
    private LessonService courseSectionService;

    @GetMapping
    public List<Lesson> getAllCourseSections() {
        return courseSectionService.getAllCourseSections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getCourseSectionById(@PathVariable Long id) {
        return courseSectionService.getCourseSectionById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public List<Lesson> getCourseSectionsByCourseId(@PathVariable Long courseId) {
        return courseSectionService.getCourseSectionsByCourseId(courseId);
    }

    @PostMapping
    public Lesson createCourseSection(@RequestBody Lesson courseSection) {
        return courseSectionService.createCourseSection(courseSection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateCourseSection(@PathVariable Long id, @RequestBody Lesson courseSectionDetails) {
        try {
            Lesson updatedCourseSection = courseSectionService.updateCourseSection(id, courseSectionDetails);
            return ResponseEntity.ok(updatedCourseSection);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseSection(@PathVariable Long id) {
        try {
            courseSectionService.deleteCourseSection(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}