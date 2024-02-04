package com.example.wickramagalleSportsAcademy.controller;

import com.example.wickramagalleSportsAcademy.dto.ClassDto;
import com.example.wickramagalleSportsAcademy.dto.StudentDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllClassDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllStudentDto;
import com.example.wickramagalleSportsAcademy.dto.requests.ClassUpdateDto;
import com.example.wickramagalleSportsAcademy.dto.requests.StudentUpdateDTO;
import com.example.wickramagalleSportsAcademy.service.ClassService;
import com.example.wickramagalleSportsAcademy.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wsaClass")
@CrossOrigin
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping("/ClassSave")
    public ResponseEntity<StandardResponse> saveClass(@RequestBody ClassDto classDto) {
        String message = classService.saveClass(classDto);
        //Standard Response part
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @PutMapping("/ClassUpdate")
    public ResponseEntity<StandardResponse> updateClass(@RequestBody ClassUpdateDto classUpdateDto) {
        String message = classService.updateClassDetails(classUpdateDto);
        //Standard Response part
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return standardResponse;
    }
    @DeleteMapping(
            path = "delete-class/{id}"
    )
    public ResponseEntity<StandardResponse> DeleteClass(@PathVariable(value = "id") int classId) {
        String message = classService.deleteClassDetails(classId);
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
    public ResponseEntity<StandardResponse> getClassById(@RequestParam(value = "id") int classId) {
        ClassDto classDto = classService.getClassById(classId);
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", classDto), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @GetMapping(
            path = "/get-by-active-state-paginate",
            params = {"activeState", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllClassByActiveState(
            @RequestParam(value = "activeState") boolean activeState,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginateAllClassDto paginateAllClassDto = classService.getAllClassByActiveStateWithPaginate(activeState, page, size);
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", paginateAllClassDto), HttpStatus.CREATED
        );
        return standardResponse;
    }
}
