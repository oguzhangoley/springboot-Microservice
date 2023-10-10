package net.oguz.organizationservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime organizationCreatedDate;
}
