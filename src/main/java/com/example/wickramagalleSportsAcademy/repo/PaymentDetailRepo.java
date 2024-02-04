package com.example.wickramagalleSportsAcademy.repo;

import com.example.wickramagalleSportsAcademy.entity.PaymentDetailsEntity;
import com.example.wickramagalleSportsAcademy.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PaymentDetailRepo extends JpaRepository<PaymentDetailsEntity, Integer> {

}
