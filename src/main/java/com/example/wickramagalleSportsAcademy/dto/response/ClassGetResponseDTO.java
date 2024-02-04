package com.example.wickramagalleSportsAcademy.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassGetResponseDTO {
    private int classId;
    private String className;
    private String classCategory;
    private double classFeePerMonth;
    private boolean activeState;
}
