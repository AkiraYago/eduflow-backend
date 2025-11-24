package com.eduflow.demo.controller;

import com.eduflow.demo.api.ApiResponse;
import com.eduflow.demo.dto.InstructorDTO;
import com.eduflow.demo.entity.Instructor;
import com.eduflow.demo.mapper.InstructorMapper;
import com.eduflow.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<InstructorDTO>>> getAllInstructors() {
        ApiResponse<List<InstructorDTO>> apiResponse = new ApiResponse<>();

        try {
            List<InstructorDTO> instructors = instructorService.getAllInstructors();
            apiResponse.setSuccess(true);
            apiResponse.setMessage("success");
            apiResponse.setData(instructors);

            return ResponseEntity.ok().body(apiResponse);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
            apiResponse.setData(null);

            return ResponseEntity.status(500).body(apiResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InstructorDTO>> getInstructorById(@PathVariable Long id) {
        ApiResponse<InstructorDTO> apiResponse = new ApiResponse<>();

        try {
            InstructorDTO instructorDTO = instructorService.getInstructorById(id);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("success");
            apiResponse.setData(instructorDTO);
            return ResponseEntity.ok().body(apiResponse);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
            apiResponse.setData(null);
            return ResponseEntity.status(500).body(apiResponse);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InstructorDTO>> createInstructor(@RequestBody @Validated Instructor instructor) {
        ApiResponse<InstructorDTO> apiResponse = new ApiResponse<>();
        try {
            InstructorDTO instructorDTO = instructorService.createInstructor(instructor);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("success");
            apiResponse.setData(instructorDTO);
            return ResponseEntity.ok().body(apiResponse);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
            apiResponse.setData(null);

            return ResponseEntity.status(500).body(apiResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InstructorDTO>> updateInstructor(@PathVariable Long id, @RequestBody @Validated Instructor instructor) {
        ApiResponse<InstructorDTO> apiResponse = new ApiResponse<>();
        try {
            InstructorDTO instructorDTO = instructorService.updateInstructor(id, instructor);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("success");
            apiResponse.setData(instructorDTO);
            return ResponseEntity.ok().body(apiResponse);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
            apiResponse.setData(null);
            return ResponseEntity.status(500).body(apiResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteInstructor(@PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse<>();
        try {
            instructorService.deleteInstructor(id);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("success");
            apiResponse.setData(null);
            return ResponseEntity.ok().body(apiResponse);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
            apiResponse.setData(null);
            return ResponseEntity.status(500).body(apiResponse);
        }
    }
}
