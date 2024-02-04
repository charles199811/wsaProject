package com.example.wickramagalleSportsAcademy.dto.paginate;

import com.example.wickramagalleSportsAcademy.dto.response.PaymentDetailGetResponsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponsePaymentDetails {
    private List<PaymentDetailGetResponsDTO> list;
    private long dataCount;
}
