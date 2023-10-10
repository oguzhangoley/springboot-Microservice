package net.oguz.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.oguz.employeeservice.dto.ApiResponseDto;
import net.oguz.employeeservice.dto.DepartmentDto;
import net.oguz.employeeservice.dto.EmployeeDto;
import net.oguz.employeeservice.entity.Employee;
import net.oguz.employeeservice.exception.exceptions.EmployeeNotFoundException;
import net.oguz.employeeservice.repository.EmployeeRepository;
import net.oguz.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    //    private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public ApiResponseDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee", "id", employeeId));
//       //RestTemplate-----
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8090/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
//       //----------
        //Web Client ----
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8090/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        //----
        return new ApiResponseDto(
                modelMapper.map(employee, EmployeeDto.class),
                departmentDto
        );
    }
}
