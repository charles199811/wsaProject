package com.example.wickramagalleSportsAcademy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDetailGetResponsDTO {

    //student table
    private String studentName;

    //class table
    private String className;

    //payment table
    private Date Date;
    private String  paymentMonth;
    private Double amount;
}
