package net.oguz.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.oguz.employeeservice.dto.ApiResponseDto;
import net.oguz.employeeservice.dto.EmployeeDto;
import net.oguz.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - EmployeeController",
        description = "Employee Controller Exposes REST APIs for Employee-Service"
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save employee object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get employee object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable long id) {
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
