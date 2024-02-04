package com.example.wickramagalleSportsAcademy.repo;

import com.example.wickramagalleSportsAcademy.entity.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ClassRepo extends JpaRepository<ClassEntity, Integer> {

    Page<ClassEntity> findAllByActiveStateEquals(boolean activeState, PageRequest of);
    int countAllByActiveStateEquals(boolean activeState);
}
