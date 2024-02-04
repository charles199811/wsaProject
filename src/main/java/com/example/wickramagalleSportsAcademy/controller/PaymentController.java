package com.example.wickramagalleSportsAcademy.controller;

import com.example.wickramagalleSportsAcademy.dto.paginate.PaginatedResponsePaymentDetails;
import com.example.wickramagalleSportsAcademy.dto.requests.RequestPaymentSaveDto;
import com.example.wickramagalleSportsAcademy.service.PaymentService;
import com.example.wickramagalleSportsAcademy.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wsaPayment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> savePayment(@RequestBody RequestPaymentSaveDto requestPaymentSaveDto){
        String id = paymentService.savePayment(requestPaymentSaveDto);

        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", id), HttpStatus.CREATED
        );
        return standardResponse;
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-payment-details"}
    )
    public ResponseEntity<StandardResponse> getPaymentDetails(
            @RequestParam (value = "stateType") String stateType,
            @RequestParam (value = "page") int page,
            @RequestParam (value = "size") int size
    ){
        PaginatedResponsePaymentDetails p = null;
        if (stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active")? true:false;
            p = paymentService.getPaymentDetails(status,page,size);
        }
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", p), HttpStatus.OK
        );
        return standardResponse;
    }
}
