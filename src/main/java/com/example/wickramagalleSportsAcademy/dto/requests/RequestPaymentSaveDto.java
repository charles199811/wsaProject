package com.example.wickramagalleSportsAcademy.dto.requests;

import com.example.wickramagalleSportsAcademy.entity.PaymentDetailsEntity;
import com.example.wickramagalleSportsAcademy.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestPaymentSaveDto {

    private int student;
    private Date Date;
    private String  paymentMonth;
    private Double amount;
    private  String nic;
    private List<RequestPaymentDetailsSaveDto> paymentDetails;
}
