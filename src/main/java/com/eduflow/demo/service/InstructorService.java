package com.eduflow.demo.service;

import com.eduflow.demo.dto.InstructorDTO;
import com.eduflow.demo.entity.Instructor;
import com.eduflow.demo.exception.NotFoundException;
import com.eduflow.demo.mapper.InstructorMapper;
import com.eduflow.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll().stream().map(InstructorMapper::toDTO).toList();
    }

    public InstructorDTO getInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new NotFoundException("Instructor not found"));

        return InstructorMapper.toDTO(instructor);
    }

    public InstructorDTO createInstructor(Instructor instructor) {
        return InstructorMapper.toDTO(instructorRepository.save(instructor));
    }

    public InstructorDTO updateInstructor(Long id, Instructor instructor) {
        Instructor foundInstructor = instructorRepository.findById(id).orElseThrow(() -> new NotFoundException("Instructor not found"));
        foundInstructor.setDescription(instructor.getDescription());
        foundInstructor.setRating(instructor.getRating());
//        foundInstructor.setUser(instructor.getUser());

        return InstructorMapper.toDTO(instructorRepository.save(foundInstructor));
    }

    public void deleteInstructor(Long id) {
        instructorRepository.findById(id).orElseThrow(() -> new NotFoundException("Instructor not found"));

        instructorRepository.deleteById(id);
    }
}
