package com.example.wickramagalleSportsAcademy.dto.paginate;

import com.example.wickramagalleSportsAcademy.dto.response.ClassGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginateAllClassDto {
    List<ClassGetResponseDTO> List;
    private long dataCount;
}
