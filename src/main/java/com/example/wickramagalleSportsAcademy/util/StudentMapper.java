package com.example.wickramagalleSportsAcademy.util;

import com.example.wickramagalleSportsAcademy.dto.StudentDto;
import com.example.wickramagalleSportsAcademy.dto.response.StudentGetResponseDTO;
import com.example.wickramagalleSportsAcademy.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity dtoToEntity (StudentDto studentDto);

    StudentDto entityToDto(StudentEntity studentEntity);


    List<StudentGetResponseDTO>ListDtoToPage(Page<StudentEntity> studentEntity);
}
