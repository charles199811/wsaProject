package com.example.wickramagalleSportsAcademy.util;

import com.example.wickramagalleSportsAcademy.dto.ClassDto;
import com.example.wickramagalleSportsAcademy.dto.response.ClassGetResponseDTO;
import com.example.wickramagalleSportsAcademy.entity.ClassEntity;
import com.example.wickramagalleSportsAcademy.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ClassEntity dtoToEntity(ClassDto classDto);

    ClassDto entityToDto(ClassEntity classEntity);

    List<ClassGetResponseDTO> listEntityToPgeDto(Page<ClassEntity> classEntities);
}
