package net.oguz.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.oguz.departmentservice.DepartmentServiceApplication;
import net.oguz.departmentservice.dto.DepartmentDto;
import net.oguz.departmentservice.entity.Department;
import net.oguz.departmentservice.exception.exceptions.NotFoundException;
import net.oguz.departmentservice.repository.DepartmentRepository;
import net.oguz.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(() ->
                new NotFoundException("Department", "departmentCode", departmentCode)
        );
        return modelMapper.map(department, DepartmentDto.class);
    }
}
