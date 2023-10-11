package net.oguz.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DepartmentDto Model Description"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;
    @Schema(name = "Department Name")
    private String departmentName;
    @Schema(name = "Department Description")
    private String departmentDescription;
    @Schema(name = "Department Code")
    private String departmentCode;
}
