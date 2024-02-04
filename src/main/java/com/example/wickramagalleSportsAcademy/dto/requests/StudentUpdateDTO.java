package com.example.wickramagalleSportsAcademy.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentUpdateDTO {
    private int studentId;
    private String studentName;
    private String studentAddress;
    private ArrayList contactNumber;
    private  String nic;
    private boolean activeState;
}
