package com.example.wickramagalleSportsAcademy.dto.paginate;

import com.example.wickramagalleSportsAcademy.dto.response.StudentGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
//get all dto
public class PaginateAllStudentDto {
    List<StudentGetResponseDTO> List;
    private long dataCount;
}
