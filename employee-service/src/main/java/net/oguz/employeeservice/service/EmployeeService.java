package net.oguz.employeeservice.service;

import net.oguz.employeeservice.dto.ApiResponseDto;
import net.oguz.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(long employeeId);
}
