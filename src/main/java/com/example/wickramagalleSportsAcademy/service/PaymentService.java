package com.example.wickramagalleSportsAcademy.service;

import com.example.wickramagalleSportsAcademy.dto.paginate.PaginatedResponsePaymentDetails;
import com.example.wickramagalleSportsAcademy.dto.requests.RequestPaymentSaveDto;
import org.springframework.stereotype.Service;


public interface PaymentService {
    String savePayment(RequestPaymentSaveDto requestPaymentSaveDto);
    PaginatedResponsePaymentDetails getPaymentDetails(boolean status, int page, int size);


}
