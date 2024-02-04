package com.example.wickramagalleSportsAcademy.service.impl;

import com.example.wickramagalleSportsAcademy.dto.ClassDto;
import com.example.wickramagalleSportsAcademy.dto.paginate.PaginateAllClassDto;
import com.example.wickramagalleSportsAcademy.dto.requests.ClassUpdateDto;
import com.example.wickramagalleSportsAcademy.entity.ClassEntity;
import com.example.wickramagalleSportsAcademy.exeption.NotFoundExeption;
import com.example.wickramagalleSportsAcademy.repo.ClassRepo;
import com.example.wickramagalleSportsAcademy.service.ClassService;
import com.example.wickramagalleSportsAcademy.util.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceIMPL implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private ClassRepo classRepo;

    @Override
    public String saveClass(ClassDto classDto) {
        ClassEntity classEntity = classMapper.dtoToEntity(classDto);
        if (!classRepo.existsById(classEntity.getClassId())) {
            classRepo.save(classEntity);
            return classDto.getClassName() + " saved successfully";
        } else {
            throw new NotFoundExeption("This student all ready added");
        }
    }

    @Override
    public String updateClassDetails(ClassUpdateDto classUpdateDto) {
        if (classRepo.existsById(classUpdateDto.getClassId())) {
            ClassEntity classEntity = classRepo.getReferenceById(classUpdateDto.getClassId());
            classEntity.setClassName(classUpdateDto.getClassName());
            classEntity.setClassCategory(classUpdateDto.getClassCategory());
            classEntity.setClassFeePerMonth(classUpdateDto.getClassFeePerMonth());
            classEntity.setActiveState(classUpdateDto.isActiveState());
            classRepo.save(classEntity);
            return classUpdateDto.getClassName() + " updated successfully";
        } else {
            throw new NotFoundExeption("No ID found");
        }
    }

    @Override
    public String deleteClassDetails(int classId) {
        if (classRepo.existsById(classId)) {
            classRepo.deleteById(classId);
            return classId + "delete successful";
        }
        throw new NotFoundExeption("No id found");
    }

    @Override
    public ClassDto getClassById(int classId) {
        ClassEntity classEntity = classRepo.getReferenceById(classId);
        if (classRepo.existsById(classEntity.getClassId())) {
            ClassDto classDto = classMapper.entityToDto(classEntity);
            return classDto;
        } else {
            throw new NotFoundExeption("No id found");
        }
    }

    @Override
    public PaginateAllClassDto getAllClassByActiveStateWithPaginate(boolean activeState, int page, int size) {
        Page<ClassEntity> classEntities = classRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page, size));
        if (classEntities.getSize() > 0) {
            PaginateAllClassDto paginateAllClassDto = new PaginateAllClassDto(
                    classMapper.listEntityToPgeDto(classEntities),
                    classRepo.countAllByActiveStateEquals(activeState)
            );
            return paginateAllClassDto;
        }else{
            throw new NotFoundExeption("No class found");
        }
    }
}