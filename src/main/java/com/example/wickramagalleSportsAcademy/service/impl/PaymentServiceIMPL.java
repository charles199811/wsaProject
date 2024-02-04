package com.example.wickramagalleSportsAcademy.service.impl;

import com.example.wickramagalleSportsAcademy.dto.paginate.PaginatedResponsePaymentDetails;
import com.example.wickramagalleSportsAcademy.dto.requests.RequestPaymentSaveDto;
import com.example.wickramagalleSportsAcademy.dto.response.PaymentDetailGetResponsDTO;
import com.example.wickramagalleSportsAcademy.entity.PaymentDetailsEntity;
import com.example.wickramagalleSportsAcademy.entity.PaymentEntity;
import com.example.wickramagalleSportsAcademy.exeption.NotFoundExeption;
import com.example.wickramagalleSportsAcademy.queryInterface.PaymentDetailsInterface;
import com.example.wickramagalleSportsAcademy.repo.ClassRepo;
import com.example.wickramagalleSportsAcademy.repo.PaymentDetailRepo;
import com.example.wickramagalleSportsAcademy.repo.PaymentRepo;
import com.example.wickramagalleSportsAcademy.repo.StudentRepo;
import com.example.wickramagalleSportsAcademy.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ClassRepo classRepo;
    @Autowired
    private PaymentDetailRepo paymentDetailRepo;


    @Override
    @Transactional
    public String savePayment(RequestPaymentSaveDto requestPaymentSaveDto) {
        PaymentEntity paymentEntity = new PaymentEntity(
                studentRepo.getReferenceById(requestPaymentSaveDto.getStudent()),
                requestPaymentSaveDto.getDate(),
                requestPaymentSaveDto.getPaymentMonth(),
                requestPaymentSaveDto.getAmount(),
                requestPaymentSaveDto.getNic()
        );
        paymentRepo.save(paymentEntity);

        if (paymentRepo.existsById(paymentEntity.getPaymentId())) {
            List<PaymentDetailsEntity> paymentDetailsEntities = modelMapper.map(requestPaymentSaveDto.getPaymentDetails(), new TypeToken<List<PaymentDetailsEntity>>() {
            }.getType());
            for (int i = 0; i < paymentDetailsEntities.size(); i++) {
                paymentDetailsEntities.get(i).setPayments(paymentEntity);
                paymentDetailsEntities.get(i).setClasses(classRepo.getReferenceById(requestPaymentSaveDto.getPaymentDetails().get(i).getClasses()));
            }
            if (paymentDetailsEntities.size() > 0) {
                paymentDetailRepo.saveAll(paymentDetailsEntities);
            }
            return "saved";
        } else {
            throw new NotFoundExeption("Save failed");
        }
    }



    @Override
    public PaginatedResponsePaymentDetails getPaymentDetails(boolean status, int page, int size) {
        List<PaymentDetailsInterface> paymentDetailsInterfaces = paymentRepo.getFilteredPaymentDetails(status, PageRequest.of(page,size));

        List<PaymentDetailGetResponsDTO> list = new ArrayList<>();
        for (PaymentDetailsInterface p: paymentDetailsInterfaces){
            PaymentDetailGetResponsDTO paymentDetailGetResponsDTO = new PaymentDetailGetResponsDTO(
                    p.getStudentName(),
                    p.getClassName(),
                    p.getDate(),
                    p.getPaymentMonth(),
                    p.getAmount()
            );
            list.add(paymentDetailGetResponsDTO);
        }
        PaginatedResponsePaymentDetails paginatedResponsePaymentDetails = new PaginatedResponsePaymentDetails(
                list,
                paymentRepo.countAllByPaymentDetails(status)
        );
        return paginatedResponsePaymentDetails;
    }
}
