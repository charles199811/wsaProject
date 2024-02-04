package com.example.wickramagalleSportsAcademy.service;

import com.example.wickramagalleSportsAcademy.dto.ClassDto;
import com.example.wickramagalleSportsAcademy.dto.StudentDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllClassDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllStudentDto;
import com.example.wickramagalleSportsAcademy.dto.requests.ClassUpdateDto;
import com.example.wickramagalleSportsAcademy.dto.requests.StudentUpdateDTO;

public interface ClassService {

    String saveClass(ClassDto classDto);

    String updateClassDetails(ClassUpdateDto classUpdateDto);

    String deleteClassDetails(int classId);

    ClassDto getClassById(int classId);

    PaginateAllClassDto getAllClassByActiveStateWithPaginate(boolean activeState, int page, int size);
}
