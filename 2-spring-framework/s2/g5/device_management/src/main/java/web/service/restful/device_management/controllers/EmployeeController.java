package web.service.restful.device_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.service.restful.device_management.Models.entities.Employee;
import web.service.restful.device_management.Models.inputDto.EmployeeInputDto;
import web.service.restful.device_management.Models.outputDto.ConfirmOutputDto;
import web.service.restful.device_management.exception_handling.BadRequestException;
import web.service.restful.device_management.exception_handling.InternalServerErrorException;
import web.service.restful.device_management.exception_handling.NotFoundException;
import web.service.restful.device_management.exception_handling.Validation;
import web.service.restful.device_management.services.EmployeeService;

import java.util.UUID;

@RestController("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> findAll(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable UUID id) throws NotFoundException {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee create(@RequestBody @Validated EmployeeInputDto employeeInputDto, BindingResult validation) throws BadRequestException, InternalServerErrorException {
        Validation.validate(validation);
        return employeeService.create(employeeInputDto);
    }

    @PutMapping("/{id}")
    public Employee updateById(@RequestBody @Validated EmployeeInputDto employeeInputDto, BindingResult validation, @PathVariable UUID id) throws BadRequestException, NotFoundException, InternalServerErrorException {
        Validation.validate(validation);
        return employeeService.updateById(employeeInputDto, id);
    }

    @DeleteMapping("/{id}")
    public ConfirmOutputDto deleteById(@PathVariable UUID id) throws NotFoundException {
        return employeeService.deleteById(id);
    }

    // patch Cloudinary

}
