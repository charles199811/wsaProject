package com.example.wickramagalleSportsAcademy.service.impl;

import com.example.wickramagalleSportsAcademy.dto.StudentDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllStudentDto;
import com.example.wickramagalleSportsAcademy.dto.requests.StudentUpdateDTO;
import com.example.wickramagalleSportsAcademy.entity.StudentEntity;
import com.example.wickramagalleSportsAcademy.exeption.NotFoundExeption;
import com.example.wickramagalleSportsAcademy.repo.StudentRepo;
import com.example.wickramagalleSportsAcademy.service.StudentService;
import com.example.wickramagalleSportsAcademy.util.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepo studentRepo;


    @Override
    public String saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.dtoToEntity(studentDto);
        if (!studentRepo.existsById(studentEntity.getStudentId())) {
            studentRepo.save(studentEntity);
            return studentDto.getStudentName() + " Saved successfully";
        } else {
            throw new NotFoundExeption("This student all ready added");
        }
    }

    @Override
    public String updateStudentDetails(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(studentUpdateDTO.getStudentId())) {
            StudentEntity studentEntity = studentRepo.getReferenceById(studentUpdateDTO.getStudentId());
            studentEntity.setStudentName(studentUpdateDTO.getStudentName());
            studentEntity.setStudentAddress(studentUpdateDTO.getStudentAddress());
            studentEntity.setContactNumber(studentUpdateDTO.getContactNumber());
            studentEntity.setNic(studentUpdateDTO.getNic());
            studentEntity.setActiveState(studentUpdateDTO.isActiveState());
            studentRepo.save(studentEntity);
            return studentUpdateDTO.getStudentName() + " Updated successfully";
        } else {
            throw new NotFoundExeption("No ID found");
        }
    }

    @Override
    public String deleteStudenDetails(int studentId) {
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
            return studentId + " Delete successful";
        } else {
            throw new NotFoundExeption("No ID found");
        }
    }

    @Override
    public StudentDto getStudentById(int studentId) {

        StudentEntity studentEntity = studentRepo.getReferenceById(studentId);
        if (studentRepo.existsById(studentEntity.getStudentId())) {
            StudentDto studentDto = studentMapper.entityToDto(studentEntity);
            return studentDto;
        } else {

        }
        throw new NotFoundExeption("No ID found");
    }

    @Override
    public PaginateAllStudentDto getAllStudentByActiveStateWithPaginate(boolean activeState, int page, int size) {
        Page<StudentEntity> studentEntity = studentRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page, size));
        if (studentEntity.getSize() > 0) {
            PaginateAllStudentDto paginateAllStudentDto = new PaginateAllStudentDto(
                    studentMapper.ListDtoToPage(studentEntity),
                    studentRepo.countAllByActiveStateEquals(activeState)
            );
            return paginateAllStudentDto;
        } else {
            throw new NotFoundExeption("No student found");
        }
    }
}
