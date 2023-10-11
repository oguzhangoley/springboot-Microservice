package net.oguz.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "EmployeeDto Description")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {

    private long id;
    @Schema(name = "first Name")
    private String firstName;
    @Schema(name = "last Name")
    private String lastName;
    @Schema(name = "email")
    private String email;
    @Schema(name = "department code")
    private String departmentCode;
    @Schema(name = "organization code")
    private String organizationCode;

}
