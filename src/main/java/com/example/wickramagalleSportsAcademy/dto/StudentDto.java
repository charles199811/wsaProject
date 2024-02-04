package com.example.wickramagalleSportsAcademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

    private String studentName;
    private String studentAddress;
    private Date regDate;
    private ArrayList contactNumber;
    private  String nic;
    private boolean activeState;


}
