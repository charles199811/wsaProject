package com.example.wickramagalleSportsAcademy.service;

import com.example.wickramagalleSportsAcademy.dto.StudentDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllStudentDto;
import com.example.wickramagalleSportsAcademy.dto.requests.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentDto studentDto);

    String updateStudentDetails(StudentUpdateDTO studentUpdateDTO);

    String deleteStudenDetails(int studentId);

    StudentDto getStudentById(int studentId);

    PaginateAllStudentDto getAllStudentByActiveStateWithPaginate(boolean activeState, int page, int size);
}
