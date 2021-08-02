package com.example.les7.rest;

import com.example.les7.exceptions.BadRequestException;
import com.example.les7.exceptions.NotFoundException;
import com.example.les7.repr.StudentRepr;
import com.example.les7.responses.Response;
import com.example.les7.serviceimplementation.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Student resource API", description = "API allows you to manipulate data Student resources")
@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    private final StudentService service;

    @Autowired
    public StudentRestController(StudentService service) {
        this.service = service;
    }

    @Operation(summary = "Get All Students")
    @GetMapping(path = "/all", produces = "application/json")
    public List<StudentRepr> findAll() {
        log.info("Get Request ALL Students");
        return service.findAll();
    }


    @Operation(summary = "Get Student by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Student",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentRepr.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content)
    })
    @GetMapping(path = "/{id}", produces = "application/json")
    public StudentRepr findById(@Parameter(description = "ID of student to be got") @PathVariable("id") Long id) {
        log.info("Get Request Student by id : {}", id);
        return service.findStudentById(id).orElseThrow(() -> new NotFoundException("Student by Id: " + id + " does not exists"));
    }

    @Operation(summary = "Create new Student")
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> create(@RequestBody StudentRepr studentRepr) {
        log.info("Post Request. Create student: {}", studentRepr);
        if (studentRepr.getId() != null) {
            log.warn("Post Request. Create student.  Error. Id is not null");
            throw new BadRequestException("Id is not null");
        }
        log.info("Post Request. Create student. Saved ...");
        service.saveOrUpdate(studentRepr);
        return new ResponseEntity<>(new Response("Student: " + studentRepr + " added success", "0"), HttpStatus.OK);
    }

    @Operation(summary = "Update data of student and save into DB")
    @PutMapping(path = "/update", produces = "application/json")
    public ResponseEntity<Response> update(@RequestBody StudentRepr studentRepr) {
        log.info("Put Request. Update student: {}", studentRepr);
        if (studentRepr.getId() == null) {
            log.warn("Put Request. Update student.  Error. Id is null");
            throw new BadRequestException("Id is null");
        }
        log.info("Put Request. Update student. Saved ...");
        service.saveOrUpdate(studentRepr);
        return new ResponseEntity<>(new Response("Student: " + studentRepr + " updated success", "0"), HttpStatus.OK);
    }

    @Operation(summary = "Delete Student by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })

    @DeleteMapping(path= "/delete/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteById(@Parameter(description = "ID of student to be deleted") @PathVariable("id") Long id) {
        log.info("Delete Request. Delete student by ID: {}", id);
        if(service.deleteById(id)) {
            return new ResponseEntity<>(new Response("Student by ID: " + id + "deleted success", "0"), HttpStatus.OK);
        }
        return notFoundException(new NotFoundException("Student by Id: " + id + " does not exists"));
    }

    @ExceptionHandler
    public ResponseEntity<Response> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(new Response("Entity not found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Response> badRequestException(BadRequestException e) {
        return new ResponseEntity<>(new Response("Bad request exceptions", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
