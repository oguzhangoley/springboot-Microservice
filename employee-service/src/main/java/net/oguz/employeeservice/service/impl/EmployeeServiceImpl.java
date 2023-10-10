package net.oguz.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.oguz.employeeservice.dto.ApiResponseDto;
import net.oguz.employeeservice.dto.DepartmentDto;
import net.oguz.employeeservice.dto.EmployeeDto;
import net.oguz.employeeservice.dto.OrganizationDto;
import net.oguz.employeeservice.entity.Employee;
import net.oguz.employeeservice.exception.exceptions.EmployeeNotFoundException;
import net.oguz.employeeservice.repository.EmployeeRepository;
import net.oguz.employeeservice.service.APIClient;
import net.oguz.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    //    private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    //    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee", "id", employeeId));
//       //RestTemplate-----
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8090/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
//       //----------
//        //Web Client ----
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8090/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//        //----
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8093/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
        return new ApiResponseDto(
                modelMapper.map(employee, EmployeeDto.class),
                departmentDto,
                organizationDto
        );
    }

    public ApiResponseDto getDefaultDepartment(long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee", "id", employeeId));
        DepartmentDto departmentDto = new DepartmentDto(
                0,
                "R&D Department",
                "Research and Development Department",
                "RD001"
        );
        return new ApiResponseDto(
                modelMapper.map(employee, EmployeeDto.class),
                departmentDto,
                new OrganizationDto(
                        0,"ORG","ORG Description","ORG_ORG", LocalDateTime.now()
                )
        );
    }
}
