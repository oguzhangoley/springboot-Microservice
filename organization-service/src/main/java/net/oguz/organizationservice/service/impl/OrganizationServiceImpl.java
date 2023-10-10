package net.oguz.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.oguz.organizationservice.dto.OrganizationDto;
import net.oguz.organizationservice.entity.Organization;
import net.oguz.organizationservice.mapper.OrganizationMapper;
import net.oguz.organizationservice.repository.OrganizationRepository;
import net.oguz.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.toEntity(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.toDto(savedOrganization);

    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode).get();
        return OrganizationMapper.toDto(organization);
    }
}
