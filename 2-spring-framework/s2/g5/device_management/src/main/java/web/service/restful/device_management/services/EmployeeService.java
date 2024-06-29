package web.service.restful.device_management.services;

import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import web.service.restful.device_management.Models.entities.Device;
import web.service.restful.device_management.Models.entities.Employee;
import web.service.restful.device_management.Models.inputDto.EmployeeInputDto;
import web.service.restful.device_management.Models.outputDto.ConfirmOutputDto;
import web.service.restful.device_management.exception_handling.BadRequestException;
import web.service.restful.device_management.exception_handling.InternalServerErrorException;
import web.service.restful.device_management.exception_handling.NotFoundException;
import web.service.restful.device_management.repositories.DeviceRepository;
import web.service.restful.device_management.repositories.EmployeeRepository;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    DeviceRepository deviceRepository;

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee findById(UUID id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Employee with id='" + id + "' not found. Cannot update")
        );
    }

    @Transactional
    public Employee findByIdWithDevices(UUID id) throws NotFoundException {
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

    public ConfirmOutputDto assignDeviceToEmployee(UUID deviceId, UUID employeeId) throws NotFoundException {

        Device device = deviceRepository.findById(deviceId).orElseThrow(
                () -> new NotFoundException("Device with id='" + deviceId + "' not found")
        );

        Employee employee = employeeRepository.findById(deviceId).orElseThrow(
                () -> new NotFoundException("Employee with id='" + employeeId + "' not found")
        );

        device.setEmployee(employee);
        device.setAssigned(true);
        deviceRepository.save(device);

        return new ConfirmOutputDto(HttpStatus.OK.value(), "Device with id='" + deviceId
                + "' has been correctly assigned to employee with id ='" + employeeId + "'");

    }

    public ConfirmOutputDto removeDeviceFromEmployee(UUID deviceId) throws NotFoundException {

        Device device = deviceRepository.findById(deviceId).orElseThrow(
                () -> new NotFoundException("Device with id='" + deviceId + "' not found")
        );

        device.setEmployee(null);
        device.setAssigned(false);
        deviceRepository.save(device);

        return new ConfirmOutputDto(HttpStatus.OK.value(), "Device with id='" + deviceId
                + "' has been removed from its employee");


    }

    public Employee updateById(EmployeeInputDto employeeInputDto, UUID id) throws NotFoundException, BadRequestException, InternalServerErrorException {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Employee with id='" + id + "' not found")
        );

        employee.setUsername(employeeInputDto.username());
        employee.setFirstName(employeeInputDto.firstName());
        employee.setLastName(employeeInputDto.lastName());
        employee.setEmail(employeeInputDto.email());

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

    public ConfirmOutputDto deleteById(UUID id) throws NotFoundException {
        Employee employee = findByIdWithDevices(id);
        for (Device d : employee.getDevices()) {
            d.setEmployee(null);
            deviceRepository.save(d);
        }
        employeeRepository.delete(employee);
        return new ConfirmOutputDto(HttpStatus.OK.value(), "Employee with id='" + id
                + "' has been successfully removed");
    }

}
