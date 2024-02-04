package com.example.wickramagalleSportsAcademy.dto.requests;

import com.example.wickramagalleSportsAcademy.entity.ClassEntity;
import com.example.wickramagalleSportsAcademy.entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestPaymentDetailsSaveDto {

    private String studentName;
    private String className;
    private int classes;

}
