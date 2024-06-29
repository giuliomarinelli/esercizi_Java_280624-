package web.service.restful.device_management.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.service.restful.device_management.Models.entities.Employee;
import web.service.restful.device_management.Models.inputDto.EmployeeInputDto;
import web.service.restful.device_management.exception_handling.BadRequestException;
import web.service.restful.device_management.exception_handling.InternalServerErrorException;
import web.service.restful.device_management.exception_handling.NotFoundException;
import web.service.restful.device_management.repositories.EmployeeRepository;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee findById(UUID id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Employee with id='" + id + "' not found. Cannot update")
        );
    }

    public Employee create(EmployeeInputDto employeeInputDto) throws BadRequestException, InternalServerErrorException {
        Employee employee = new Employee(
                employeeInputDto.username(), employeeInputDto.firstName(),
                employeeInputDto.lastName(), employeeInputDto.email()
        );

        try {
            employeeRepository.save(employee);
        } catch (DataIntegrityViolationException e) {
            if (employeeRepository.getAllEmails().contains(employeeInputDto.email()))
                throw new BadRequestException("Email already exist");
            if (employeeRepository.getAllUsernames().contains(employeeInputDto.email()))
                throw new BadRequestException("Username already exist");
            throw new InternalServerErrorException("Database error");
        }

        return employee;

    }

}
