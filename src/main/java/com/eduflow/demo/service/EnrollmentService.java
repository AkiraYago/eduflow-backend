package com.eduflow.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.eduflow.demo.repository.EnrollmentRepository;
import com.eduflow.demo.entity.Enrollment;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollmentDetails) {
        Enrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

        enrollment.setStudent(enrollmentDetails.getStudent());
        enrollment.setCourse(enrollmentDetails.getCourse());

        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        enrollmentRepository.delete(enrollment);
    }
}