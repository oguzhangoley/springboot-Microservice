package net.oguz.organizationservice.mapper;

import net.oguz.organizationservice.dto.OrganizationDto;
import net.oguz.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto toDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getOrganizationCreatedDate()
        );
    }

    public static Organization toEntity(OrganizationDto organizationDto) {
        return new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getOrganizationCreatedDate()
        );
    }
}
