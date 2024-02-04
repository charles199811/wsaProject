package com.example.wickramagalleSportsAcademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassDto {

    private String className;
    private String classCategory;
    private double classFeePerMonth;
    private boolean activeState;
}
