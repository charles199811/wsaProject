package com.example.wickramagalleSportsAcademy.repo;

import com.example.wickramagalleSportsAcademy.dto.response.PaymentDetailGetResponsDTO;
import com.example.wickramagalleSportsAcademy.entity.PaymentEntity;
import com.example.wickramagalleSportsAcademy.queryInterface.PaymentDetailsInterface;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<PaymentEntity, Integer> {

    @Query(value = "select s.student_name as studentName, cd.class_name as className, p.date as Date, p.paid_month as paymentMonth, p.amount as amount from student_details s , class_details cd, payments p where p.payment_active_state = ?1 and s.student_id = p.student_id ", nativeQuery = true)
    List<PaymentDetailsInterface> getFilteredPaymentDetails(boolean status, Pageable pageable);

    @Query(value = "select count(*) from student_details s , class_details c , payments p where p.payment_active_state = ?1 ", nativeQuery = true)
    long countAllByPaymentDetails(boolean status);
}
