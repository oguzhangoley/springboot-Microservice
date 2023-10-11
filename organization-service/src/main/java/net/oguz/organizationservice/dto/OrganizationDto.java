package net.oguz.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "OrganizationDto Model Description"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private long id;
    @Schema(name = "Organization Name")
    private String organizationName;
    @Schema(name = "Organization Description")
    private String organizationDescription;
    @Schema(name = "Organization Code")
    private String organizationCode;
    @Schema(name = "Organization CreatedDate")
    private LocalDateTime organizationCreatedDate;
}
