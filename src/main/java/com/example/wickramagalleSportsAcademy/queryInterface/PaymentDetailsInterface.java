package com.example.wickramagalleSportsAcademy.queryInterface;


import java.util.Date;

public interface PaymentDetailsInterface {
    String getStudentName();

    String getClassName();

    Date getDate();

    String getPaymentMonth();

    Double getAmount();
}