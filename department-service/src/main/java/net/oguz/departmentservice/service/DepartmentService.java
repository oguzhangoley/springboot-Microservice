package net.oguz.departmentservice.service;

import net.oguz.departmentservice.DepartmentServiceApplication;
import net.oguz.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);
}
