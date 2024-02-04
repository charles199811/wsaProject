package com.example.wickramagalleSportsAcademy.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassUpdateDto {

    private int classId;
    private String className;
    private String classCategory;
    private double classFeePerMonth;
    private boolean activeState;

}
