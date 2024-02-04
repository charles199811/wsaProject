package com.example.wickramagalleSportsAcademy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentGetResponseDTO {
    private int studentId;
    private String studentName;
    private String studentAddress;
    private Date regDate;
    private ArrayList contactNumber;
    private  String nic;
    private boolean activeState;
}
