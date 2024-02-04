package com.example.wickramagalleSportsAcademy.controller;

import com.example.wickramagalleSportsAcademy.dto.StudentDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllStudentDto;
import com.example.wickramagalleSportsAcademy.dto.requests.StudentUpdateDTO;
import com.example.wickramagalleSportsAcademy.service.StudentService;
import com.example.wickramagalleSportsAcademy.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wsaStuReg")
@CrossOrigin
public class StudentController {

    @Autowired//DI student service//
    private StudentService studentService;

    @PostMapping("/stuSave")
    public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentDto studentDto) {
        String message = studentService.saveStudent(studentDto);
        //Standard Response part
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @PutMapping("/stuUpdate")
    public ResponseEntity<StandardResponse> updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
        String message = studentService.updateStudentDetails(studentUpdateDTO);
        //Standard Response part
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @DeleteMapping(
            path = "delete-student/{id}"
    )
    public ResponseEntity<StandardResponse> DeleteStudent(@PathVariable(value = "id") int studentId) {
        String message = studentService.deleteStudenDetails(studentId);
        //Standard Response part
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @GetMapping(
            path = "/get-student-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getStudentById(@RequestParam(value = "id") int studentId) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", studentDto), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @GetMapping(
            path = "/get-by-active-state-paginate",
            params = {"activeState", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllStudentByActiveState(
            @RequestParam(value = "activeState") boolean activeState,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginateAllStudentDto paginateAllStudentDto = studentService.getAllStudentByActiveStateWithPaginate(activeState, page, size);
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", paginateAllStudentDto), HttpStatus.CREATED
        );
        return standardResponse;
    }

}
